package com.movieq

import java.io.File
import java.nio.file.{Files, Paths}
import java.sql.DriverManager

import com.movieq.db.{SQLFile, SQLFileExecutor}
import javax.servlet.ServletContext
import org.h2.tools.Server
import org.scalatra.LifeCycle

class MovieqBootstrap extends LifeCycle {

  override def init(context: ServletContext) {
    val sqlResource = getClass.getClassLoader.getResource("sql")
    val movieqDbPath = "jdbc:h2:tcp://localhost:9092/./target/movieqdb"
    val h2Server = Server.createTcpServer("-tcpAllowOthers").start()
    try {
      val sqlFileExecutor = SQLFileExecutor(DriverManager.getConnection(movieqDbPath, "sa", ""))
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
    context.mount(new MovieqServlet, "/")
  }
}
