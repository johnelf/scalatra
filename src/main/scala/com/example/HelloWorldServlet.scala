package com.example

import org.scalatra._
import org.json4s.{DefaultFormats, Formats}
import scala.Predef.String
import org.scalatra.json._

case class Person(name: String, age: Int)

class HelloWorldServlet extends ScalatraServlet with JacksonJsonSupport with DatabaseSessionSupport{
  protected implicit val jsonFormats: Formats = DefaultFormats

  before() {
    contentType = formats("json")
  }

  get("/hello") {
    Person("robot", 1)
  }

  post("/signup") {
    val body = parsedBody.extract[Person]
    Ok(body.name)
  }

  object People{
    val all = List(Person("alex", 20), Person("Bob", 30))
  }

}





