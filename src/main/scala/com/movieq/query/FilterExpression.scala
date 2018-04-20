package com.movieq.query

trait FilterExpression extends Expression {

  override def toMySQLExpression: com.movieq.query.mysql.FilterExpression

}
