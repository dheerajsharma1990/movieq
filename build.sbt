name := "movieq"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.12.4"
libraryDependencies += "com.h2database" % "h2" % "1.4.197"
libraryDependencies += "org.apache.httpcomponents" % "httpasyncclient" % "4.1.3"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.5"
libraryDependencies += "org.scalatra" %% "scalatra" % "2.5.4"
libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"