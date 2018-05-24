package com.movieq.db

import java.sql.ResultSet

import com.movieq.domain.{Gender, People}

class PeopleSQLMapper {

  private val tableAlias: String = "people"

  private val id: String = tableAlias + "." + "id"
  private val name: String = tableAlias + "." + "name"
  private val gender: String = tableAlias + "." + "gender"

  def map(resultSet: ResultSet): List[People] = {
    new Iterator[People] {
      override def hasNext: Boolean = resultSet.next()
      override def next(): People = new People(resultSet.getInt(id), resultSet.getString(name), Gender.withName(resultSet.getString(gender)))
    }.toList
  }

}
