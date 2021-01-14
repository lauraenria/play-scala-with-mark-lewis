
organization := "com.example"
version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).settings(commonSettings).settings(
  name := """play-scala-with-Mark-Lewis""",

  libraryDependencies ++= Seq(
    "com.vmunier" %% "scalajs-scripts" % "1.1.4",
    guice,
    "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
    "com.typesafe.play" %% "play-slick" % "5.0.0",
    "com.typesafe.slick" %% "slick-codegen" % "3.3.2",
    "com.typesafe.play" %% "play-json" % "2.8.1",
    "org.postgresql" % "postgresql" % "42.2.11",
    "com.typesafe.slick" %% "slick-hikaricp" % "3.3.2",
    "org.mindrot" % "jbcrypt" % "0.4",
    specs2 % Test
  ),
).enablePlugins(PlayScala)

lazy val commonSettings = Seq(
  scalaVersion := "2.13.3",
  organization := "edu.trinity"
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
