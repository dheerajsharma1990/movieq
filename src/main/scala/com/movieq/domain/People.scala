package com.movieq.domain

import com.movieq.domain.Gender._

class People(val id: Int, val name: String, val gender: Gender) {

  override def hashCode(): Int = id

  override def equals(that: Any): Boolean = {
    that match {
      case that: People => that.isInstanceOf[People] && id == that.id
      case _ => false
    }
  }


}
