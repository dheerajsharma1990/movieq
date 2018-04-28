import sbt.Keys.libraryDependencies

lazy val defaults = Seq(
  version := "0.1-SNAPSHOT",
  scalaVersion := "2.12.4",
)

lazy val movieqClient = (project in file("movieq-client"))
  .settings(defaults: _*)
  .settings(
    name := "movieq-client"
  )


lazy val movieqServer = (project in file("movieq-server"))
  .settings(defaults: _*)
  .settings(
    name := "movieq-server",
    libraryDependencies ++= Seq(
      "org.slf4j" % "slf4j-api" % "1.7.5",
      "org.slf4j" % "slf4j-simple" % "1.7.5",
      "org.scala-lang" % "scala-reflect" % "2.12.4",
      "com.h2database" % "h2" % "1.4.197",
      "org.apache.httpcomponents" % "httpasyncclient" % "4.1.3",
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.5",
      "org.scalatra" %% "scalatra" % "2.5.4",
      "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
      "org.eclipse.jetty" % "jetty-webapp" % "9.4.9.v20180320"
    ),
    mainClass in(Compile, run) := Some("com.javacodegeeks.multi.App")
  )
  .dependsOn(movieqClient)