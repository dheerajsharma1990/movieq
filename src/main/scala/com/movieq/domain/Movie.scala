package com.movieq.domain

class Movie(val id: Int, val title: String) {

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
