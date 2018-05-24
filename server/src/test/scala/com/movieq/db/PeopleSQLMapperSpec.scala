package com.movieq.db

import java.io.File
import java.nio.file.{Files, Paths}
import java.sql.DriverManager

import org.h2.tools.Server
import org.scalatest.FlatSpec

class PeopleSQLMapperSpec extends FlatSpec {

  val mapper = new PeopleSQLMapper

  val sqlResource = getClass.getClassLoader.getResource("sql")
  val movieqDbPath = "jdbc:h2:tcp://localhost:9092/./target/movieqdb"
  val h2Server = Server.createTcpServer("-tcpAllowOthers").start()
  try {
    val connection = DriverManager.getConnection(movieqDbPath, "sa", "")
    val sqlFileExecutor = SQLFileExecutor(connection)
    try {
      Files
        .walk(Paths.get(sqlResource.toURI))
        .map[File](path => path.toFile)
        .filter(file => !file.isDirectory)
        .map[SQLFile](file => SQLFile(file))
        .sorted()
        .forEach(sqlFile => sqlFileExecutor.execute(sqlFile))
    } finally {
      sqlFileExecutor.close()
    }
  } catch {
    case e: Exception =>
      h2Server.stop()
      throw e
  }


  "PeopleSQLMapper" should "map sql rows to People" in {
    val connection = DriverManager.getConnection(movieqDbPath, "sa", "")
    val statement = connection.prepareStatement("select people.id, people.name, people.gender from People people")
    val resultSet = statement.executeQuery()
    val people = mapper.map(resultSet)
    assert(people.size === 60)
    connection.close()
    h2Server.stop()
  }

}
