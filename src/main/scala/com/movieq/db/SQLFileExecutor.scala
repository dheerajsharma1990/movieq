package com.movieq.db

import java.sql.Connection

class SQLFileExecutor(connection: Connection) {

  def execute(sqlFile: SQLFile): Unit = {
    sqlFile.getSQLs
      .foreach(sql => {
        val statement = connection.prepareStatement(sql)
        statement.execute()
        statement.close()
      })
  }

  def close(): Unit = {
    connection.close()
  }
}

object SQLFileExecutor {
  def apply(connection: Connection): SQLFileExecutor = new SQLFileExecutor(connection)
}


