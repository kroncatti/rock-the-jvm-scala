ThisBuild / scalaVersion := "2.13.16"

lazy val commonSettings = Seq(
  Compile / scalaSource := baseDirectory.value / "src"
)

lazy val root = (project in file("."))
  .aggregate(beginners, advanced, fpBook)

lazy val beginners = Project("scala-beginners", file("scala-beginners")).settings(commonSettings)
lazy val advanced  = Project("scala-advanced", file("scala-advanced")).settings(commonSettings)
lazy val fpBook    = Project("scala-fp-book", file("scala-fp-book")).settings(commonSettings)
