package com.movieq.db

import java.io.File

import scala.io.Source

class SFile(val majorVersion: Int, val minorVersion: Int, sqlFile: File) extends Ordered[SFile] {

  def getSQLs: List[String] = {
    val bufferedSource = Source.fromFile(sqlFile)
    try {
      bufferedSource.getLines().toList
    } finally {
      bufferedSource.close()
    }
  }

  override def compare(that: SFile): Int = {
    if (majorVersion == that.majorVersion) {
      minorVersion - that.minorVersion
    } else {
      majorVersion - that.majorVersion
    }
  }
}

object SFile {

  private val sqlFileRegex = """(\d+).(\d+)_([a-zA-Z0-9]+).sql""".r

  def apply(file: File): SFile = {
    file.getName match {
      case sqlFileRegex(major, minor, _) => new SFile(major.toInt, minor.toInt, file)
      case _ => throw new IllegalArgumentException("Incorrect SQL File Format." + file.getName)
    }
  }
}

