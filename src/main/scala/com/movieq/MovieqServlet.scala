package com.movieq

import org.scalatra.ScalatraServlet

class MovieqServlet extends ScalatraServlet {
  get("/search/:query") {
    val query = params("query")
    println(query)
  }
}
