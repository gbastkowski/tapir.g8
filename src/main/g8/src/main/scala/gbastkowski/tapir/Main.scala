package gbastkowski.tapir

import cats.effect._
import cats.implicits._

import io.circe.Json

import org.http4s.implicits._
import org.http4s.server.Router
import org.http4s.server.blaze.BlazeServerBuilder

import sttp.tapir._
import sttp.tapir.docs.openapi._
import sttp.tapir.model._
import sttp.tapir.openapi.circe.yaml._
import sttp.tapir.redoc.http4s.RedocHttp4s
import sttp.tapir.server.http4s._

import org.apache.logging.log4j.LogManager.getLogger


import scala.concurrent.ExecutionContext.Implicits.global

object Main extends IOApp {
  private[this] implicit val cs: ContextShift[IO] = IO.contextShift(global)

  private[this] val port = 8081
  private[this] val host = "0.0.0.0"

  private[this] val logger = getLogger(getClass)

  def run(args: List[String]): IO[ExitCode] = {
    BlazeServerBuilder[IO]
      .bindHttp(port, host)
      .withHttpApp(Router("/"-> routes).orNotFound)
      .serve
      .compile.drain.as(ExitCode.Success)
  }

  private[this] def routes =
    HelloEndpoint.get.toRoutes(sayHello) <+>
    Router(
      "/docs" -> docs(
        HelloEndpoint.get))

  private[this] val sayHello: ((UsernamePassword, String)) => IO[Either[String, Json]] = {
    case (userPass, s) => IO {
      Right {
        Json.obj(
          "greeting"  ->  Json.fromString("Hello"),
          "name"      ->  Json.fromString(s))
      }
    }
  }

  private[this] def docs(endpoints: Endpoint[_, _, _, _]*) =
    new RedocHttp4s(
      "HTTP Gateway",
      endpoints.toOpenAPI("HTTP Gateway", "0.0.1").toYaml)
    .routes[IO]
}
