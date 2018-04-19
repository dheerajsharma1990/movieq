package com.movieq

import com.movieq.query.{IsExpression, SearchExpression, Where}
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.webapp.WebAppContext
import org.scalatra.servlet.ScalatraListener

object MovieqServer {
  def main(args: Array[String]) {
    val port = 8080

    val search = new SearchExpression("movies", new Where(new IsExpression("id", "325138")))
    val mysqlQuery = search.toMySQL
    println(mysqlQuery)

    val server = new Server(port)
    val context = new WebAppContext()
    context setContextPath "/"
    context.setResourceBase("src/main/webapp")
    context.setInitParameter(ScalatraListener.LifeCycleKey, "com.movieq.MovieqBootstrap")
    context.addEventListener(new ScalatraListener)

    server.setHandler(context)

    server.start
    server.join
  }
}
