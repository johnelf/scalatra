package com.example

import org.scalatra.test.specs2._

class HelloWorldServletSpec extends ScalatraSpec { def is =
  "GET / on HelloWorldServlet"                     ^
    "should return status 200"                  ! root200^
                                                end

  addServlet(classOf[HelloWorldServlet], "/*")

  def root200 = get("/") {
    status must_== 200
  }
}
