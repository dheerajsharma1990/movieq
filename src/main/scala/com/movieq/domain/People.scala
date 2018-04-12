package com.movieq.domain

import com.movieq.domain.Gender._

class People(id: Int, name: String, gender: Gender) {

  override def toString: String = id + "," + name + "," + gender
}
