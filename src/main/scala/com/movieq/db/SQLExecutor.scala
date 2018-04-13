package com.movieq.db

import java.nio.file.{Files, Paths}
import java.sql.DriverManager

import org.h2.tools.Server

object SQLExecutor extends App {

  private val movieqDbPath = "./target/movieqdb"

  val h2Server = Server.createTcpServer("-tcpAllowOthers").start()
  val sqlConnection = DriverManager.getConnection("jdbc:h2:tcp://localhost:9092/" + movieqDbPath, "sa", "")
  val sqlResource = getClass.getClassLoader.getResource("sql")

  Files
    .walk(Paths.get(sqlResource.toURI))
    .filter(path => path.endsWith(".sql"))
    .map[SFile](path => SFile(path.toFile))
    .forEach(sqlFile => {
      sqlFile.getSQLs.foreach(sql => {
        val statement = sqlConnection.prepareStatement(sql)
        statement.execute()
        statement.close()
      })
    })

  sqlConnection.close()
  h2Server.stop()
}


