package com.movieq

import com.movieq.query.{DomainExpression, IsExpression, SearchExpression, WhoseExpression}
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.webapp.WebAppContext
import org.scalatra.servlet.ScalatraListener

object MovieqServer {
  def main(args: Array[String]) {
    val port = 8080

    val server = new Server(port)
    val context = new WebAppContext()
    val search = new SearchExpression(new DomainExpression("movie"), new WhoseExpression(
      new IsExpression("id","325138")
    ))

    val sql = search.toSQLExpression

    println(sql)


    context setContextPath "/"
    context.setResourceBase("src/main/webapp")
    context.setInitParameter(ScalatraListener.LifeCycleKey, "com.movieq.MovieqBootstrap")
    context.addEventListener(new ScalatraListener)

    server.setHandler(context)

    server.start
    server.join
  }
}
