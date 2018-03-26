package com.movieq.random
import scala.language.dynamics
import reflect.ClassTag
import scala.reflect.runtime.universe._
import com.movieq.domain.{Genre, Movie, People, ProductionCountry}

object Main  {

  def i(string: String) = Identifier[Int](string)

  def s(string: String) = Identifier[String](string)

  def d(string: String) = Identifier[Double](string)

  def pc(string: String) = Identifier[ProductionCountry](string)

  def ppl(string: String) = ListIdentifier[People](string)

  val genre = new Genre(1 , "Comedy")

  genre.id.equals(2)

  trait Runner {
    def runAway()
  }

  class Player extends Runner {
    def runAway() {
      println("Running away")
    }
  }

  class Thrower[T <: Runner](val self: T) {
    def throwBall() {
      println("Ball thrown")
      self.runAway()
    }
  }

  trait Delegate[T] extends Dynamic {
    var delegate: T = _

    import scala.reflect.runtime.{universe => ru}
    def applyDynamic(method: String)(args: Any*)(implicit tTag: TypeTag[T], cTag: ClassTag[T]) = {
      val m = ru.runtimeMirror(delegate.getClass.getClassLoader)
      val sym = ru.typeTag[T].tpe.decl(ru.TermName(method)).asMethod
      val im = m.reflect(delegate)
      val methodMirror = im.reflectMethod(sym)
      methodMirror.apply(args:_*)
    }
  }

  def main(args: Array[String]) {

    val player = new Player with Delegate[Thrower[Player]]
    player.delegate = new Thrower[Player](player)
    player.runAway()

    println(
      i("id").is(124)
        .or(
          d("rating").greaterThen(7.2)
            .or(pc("productionCountry").is(new ProductionCountry("US", "America"))))
        .and(
          s("people.name").contain("Salman Khan")
            .or(ppl("people").contain(new People(1, "Shahrukh", 52)))
        ).string()

    )
  }
}
