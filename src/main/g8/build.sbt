import Dependencies._

ThisBuild / organization :=  "gbastkowski.tapir"
ThisBuild / scalaVersion :=  "2.13.1"

lazy val root = (project in file(".")).
  settings(
    name                 :=  "tapir sample project",
    Compile / mainClass  :=  Some("gbastkowski.tapir.Main"),
    libraryDependencies ++=  circe                              ++
                             logging                            ++
                             openapi                            ++
                             scalatest.map( _ % "test"))
