package com.movieq.query

trait FilterExpression extends Expression {

  override def toSQLExpression: com.movieq.query.sql.FilterExpression

}
