package com.movieq.domain

class Genre(val id: Int, val name: String) {

  override def hashCode(): Int = id

  override def equals(that: Any): Boolean = {
    that match {
      case that: Genre => that.isInstanceOf[Genre] && id == that.id
      case _ => false
    }
  }

}
