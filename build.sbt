name := "Basic SBT ScalaTest Test"

version := "1.1"

scalaVersion := "2.11.8"

//lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws
)
