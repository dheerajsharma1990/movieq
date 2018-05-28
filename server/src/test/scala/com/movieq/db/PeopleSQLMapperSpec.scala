package com.movieq.db

import java.io.File
import java.nio.file.{Files, Paths}
import java.sql.DriverManager

import org.h2.tools.Server
import org.scalatest.FlatSpec

class PeopleSQLMapperSpec extends FlatSpec {

  val mapper = new MovieMapper

  val sqlResource = getClass.getClassLoader.getResource("sql")
  val movieqDbPath = "jdbc:h2:tcp://localhost:9092/./target/movieqdb"
  val h2Server = Server.createTcpServer("-tcpAllowOthers").start()
  try {
    val connection = DriverManager.getConnection(movieqDbPath, "sa", "")
    val sqlFileExecutor = SQLFileExecutor(connection)
    try {
      Files
        .walk(Paths.get(sqlResource.toURI))
        .map[File](path => path.toFile)
        .filter(file => !file.isDirectory)
        .map[SQLFile](file => SQLFile(file))
        .sorted()
        .forEach(sqlFile => sqlFileExecutor.execute(sqlFile))
    } finally {
      sqlFileExecutor.close()
    }
  } catch {
    case e: Exception =>
      h2Server.stop()
      throw e
  }

  "MovieMapper" should "map sql rows to Movie" in {
    val connection = DriverManager.getConnection(movieqDbPath, "sa", "")
    val statement = connection.prepareStatement("select movie.id, movie.title, movie.description, movie.rating, movie.release_date, productionCountry.code, productionCountry.name, " +
      "people.id, people.name, people.gender, genre.id, genre.name from Movie movie inner join ProductionCountry productionCountry on movie.production_country_code = productionCountry.code inner join PeopleInMovie peopleInMovie on " +
      "movie.id = peopleInMovie.movie_id inner join People people on people.id = peopleInMovie.people_id inner join GenreInMovie genreInMovie on movie.id = genreInMovie.movie_id inner join Genre genre on genre.id = genreInMovie.genre_id " +
      "where movie.id > 0")
    val resultSet = statement.executeQuery()
    val movies = mapper.map(resultSet)
    assert(movies.size === 6)
    connection.close()
    h2Server.stop()
  }

}
