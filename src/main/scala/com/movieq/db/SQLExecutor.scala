package com.movieq.db

import java.io.File
import java.nio.file.{Files, Paths}
import java.sql.DriverManager

import org.h2.tools.Server

object SQLExecutor extends App {

  private val movieqDbPath = "./target/movieqdb"

  val h2Server = Server.createTcpServer("-tcpAllowOthers").start()
  val sqlResource = getClass.getClassLoader.getResource("sql")
  try {
    val sqlConnection = DriverManager.getConnection("jdbc:h2:tcp://localhost:9092/" + movieqDbPath, "sa", "")
    try {
      Files
        .walk(Paths.get(sqlResource.toURI))
        .map[File](path => path.toFile)
        .filter(file => !file.isDirectory)
        .map[SFile](file => SFile(file))
        .sorted()
        .forEach(sqlFile => {
          sqlFile.getSQLs.foreach(sql => {
            val statement = sqlConnection.prepareStatement(sql)
            statement.execute()
            statement.close()
          })
        })
    } finally {
      sqlConnection.close()
    }
  } catch {
    case e: Exception =>
      h2Server.stop()
      throw e
  }
}


