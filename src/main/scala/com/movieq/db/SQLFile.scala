package com.movieq.db

import java.io.File

import scala.io.Source

class SQLFile(private val majorVersion: Int, private val minorVersion: Int, sqlFile: File) extends Ordered[SQLFile] {

  def getSQLs: List[String] = {
    val bufferedSource = Source.fromFile(sqlFile)
    try {
      bufferedSource.getLines().toList
    } finally {
      bufferedSource.close()
    }
  }

  override def compare(that: SQLFile): Int = {
    if (majorVersion == that.majorVersion) {
      minorVersion - that.minorVersion
    } else {
      majorVersion - that.majorVersion
    }
  }
}

object SQLFile {

  private val sqlFileRegex = """(\d+).(\d+)_([a-zA-Z0-9]+).sql""".r

  def apply(file: File): SQLFile = {
    file.getName match {
      case sqlFileRegex(major, minor, _) => new SQLFile(major.toInt, minor.toInt, file)
      case _ => throw new IllegalArgumentException("Incorrect SQL File Format." + file.getName)
    }
  }
}

