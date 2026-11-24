ThisBuild / scalaVersion := "2.13.16"

lazy val commonSettings = Seq(
  Compile / scalaSource := baseDirectory.value / "src"
)

lazy val root = (project in file("."))
  .aggregate(beginners, advanced, fpBook)

lazy val beginners = (project in file("scala-beginners")).settings(commonSettings)
lazy val advanced  = (project in file("scala-advanced")).settings(commonSettings)
lazy val fpBook    = (project in file("scala-fp-book")).settings(commonSettings)
