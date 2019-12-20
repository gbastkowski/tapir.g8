import sbt._
import Keys._

object Dependencies {

  val CatsVersion         = "2.0.0"
  val CirceVersion        = "0.12.3"
  val DisruptorVersion    = "3.4.2"
  val Fs2KafkaVersion     = "0.20.2"
  val Http4sVersion       = "0.21.0-M6"
  val Log4jVersion        = "2.12.1"
  val ScalaTestVersion    = "3.1.0"
  val TapirVersion        = "0.12.8"

  val cats = Seq(
    "org.typelevel"                 %% "cats-core"                 % CatsVersion)

  val circe = Seq(
    "io.circe"                      %% "circe-generic"             % CirceVersion,
    "io.circe"                      %% "circe-literal"             % CirceVersion,
    "io.circe"                      %% "circe-parser"              % CirceVersion
  )

  val http4sClient = Seq(
    "org.http4s"                    %% "http4s-blaze-client"       % Http4sVersion,
    "org.http4s"                    %% "http4s-circe"              % Http4sVersion)

  val http4sServer = Seq(
    "org.http4s"                    %% "http4s-dsl"                % Http4sVersion,
    "org.http4s"                    %% "http4s-blaze-server"       % Http4sVersion)

  val logging = Seq(
    "com.lmax"                       % "disruptor"                 % DisruptorVersion,
    "org.apache.logging.log4j"       % "log4j-api"                 % Log4jVersion,
    "org.apache.logging.log4j"       % "log4j-core"                % Log4jVersion,
    "org.apache.logging.log4j"       % "log4j-slf4j-impl"          % Log4jVersion,
    )

  val openapi = Seq(
    "com.softwaremill.sttp.tapir"   %% "tapir-core"                % TapirVersion,
    "com.softwaremill.sttp.tapir"   %% "tapir-http4s-server"       % TapirVersion,
    "com.softwaremill.sttp.tapir"   %% "tapir-json-circe"          % TapirVersion,
    "com.softwaremill.sttp.tapir"   %% "tapir-openapi-circe-yaml"  % TapirVersion,
    "com.softwaremill.sttp.tapir"   %% "tapir-openapi-docs"        % TapirVersion,
    "com.softwaremill.sttp.tapir"   %% "tapir-redoc-http4s"        % TapirVersion)

  val scalatest = Seq(
    "org.scalatest"                 %% "scalatest"                 % ScalaTestVersion)

}
