package com.movieq.domain

class ProductionCountry(val code: String, val name: String) {

  override def hashCode(): Int = code.hashCode

  override def equals(that: Any): Boolean = {
    that match {
      case that: ProductionCountry => that.isInstanceOf[ProductionCountry] && code.equals(that.code)
      case _ => false
    }
  }
}
