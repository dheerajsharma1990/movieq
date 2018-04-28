package com.movieq.query

import com.movieq.query.sql.TableExpression

class DomainExpression(domainName: String) extends Expression {

  override def toSQLExpression: TableExpression = {
    if (domainName.startsWith("movie")) {
      new TableExpression("Movie m inner join GenreInMovie gim on m.id = gim.movie_id join Genre g on g.id = gim.genre_id ")
    } else {
      throw new RuntimeException("Invalid Query.")
    }
  }

  override def toString: String = domainName
}
