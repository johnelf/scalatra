package com.example

import org.scalatra._
import scalate.ScalateSupport

class HelloWorldServlet extends HelloworldStack {

  get("/hello") {
    <html>
      <body>
        <h1>Hello, world!</h1>
      </body>
    </html>
  }
  
}





