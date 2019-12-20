package gbastkowski.tapir

import io.circe.Json

import sttp.tapir._
import sttp.tapir.json.circe._
import sttp.tapir.model._

object HelloEndpoint extends TapirJsonCirce {

  private[this] def baseEndpoint = endpoint.in(auth.basic)

  val get: Endpoint[(UsernamePassword, String), String, Json, Nothing] = baseEndpoint
    .get
    .in("hello")
    .in(helloPath)
    .out(jsonBody[Json])
    .errorOut(stringBody)

  private[this] def helloPath =
      path[String].description(
        """
          |get information
          |"""
          .stripMargin)

}
