package gbastkowski.tapir

import cats.effect.IO
import io.circe.Json

class HelloBackend {

  def sayHello(user: UserInfo, greeting: String): IO[Either[String, Json]] = IO {
    Right {
      Json.obj(
        "greeting"  ->  Json.fromString(greeting),
        "name"      ->  Json.fromString(user.displayName))
    }
  }

}
