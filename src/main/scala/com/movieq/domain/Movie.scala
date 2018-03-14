package com.movieq.domain

class Movie(val id: Long, val title: String) {

  def this(id: Long) = {
    this(id, "")
  }

  def wordsInTitle(): Int = {
    title.split(" ").length
  }

  def hasSameTitleLength(movie: Movie): Boolean = {
    title.length == movie.title.length
  }

  override def toString: String = {
    "Id: " + id + " Title: " + title
  }
}

object Movie {

  private val allMovies = List(new Movie(123L, "Kaminey"));

  def printAllMovies(): Unit = {
    for (movie <- allMovies) {
      println(movie)
    }
  }
}
