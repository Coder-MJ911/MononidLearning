name := "MonidLearning"

version := "0.1"

val CirceVersion = "0.13.0"
val Http4sVersion = "0.21.8"
val paradiseVersion = "2.12.12"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-core" % Http4sVersion,
  "org.http4s" %% "http4s-dsl" % Http4sVersion,
  "org.http4s" %% "http4s-blaze-client" % Http4sVersion,
  "org.http4s" %% "http4s-circe" % Http4sVersion,
  "io.circe" %% "circe-core" % CirceVersion,
  "io.circe" %% "circe-generic" % CirceVersion,
  "io.circe" %% "circe-parser" % CirceVersion,
  "io.circe" %% "circe-optics" % CirceVersion,
  "org.http4s" %% "http4s-blaze-server" % Http4sVersion,
  "org.http4s" %% "http4s-argonaut" % Http4sVersion,
  //  "org.scalamacros" %% "paradise" % paradiseVersion,
  "org.scalamacros" %% "paradise" % "2.1.1" cross CrossVersion.full,
  "org.scalatest" %% "scalatest" % "3.0.8" % Test,
  "org.scalatestplus" %% "mockito-3-2" % "3.1.1.0" % Test,
)