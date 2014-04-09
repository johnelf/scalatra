package com.example

import com.mchange.v2.c3p0.ComboPooledDataSource
import org.squeryl.{Session, SessionFactory}
import org.squeryl.adapters.H2Adapter

trait DB {
  val databaseUsername = "root"
  val databasePassword = ""
  val databaseConnection = "jdbc:h2:mem:squeryltryout"

  var cpds = new ComboPooledDataSource

  def configureDb() {
    cpds.setDriverClass("org.h2.Driver")
    cpds.setJdbcUrl(databaseConnection)
    cpds.setUser(databaseUsername)
    cpds.setPassword(databasePassword)

    cpds.setMinPoolSize(1)
    cpds.setAcquireIncrement(1)
    cpds.setMaxPoolSize(50)

    SessionFactory.concreteFactory = Some(() => connection)

    def connection = {
      Session.create(cpds.getConnection, new H2Adapter)
    }
  }

  def closeDbConnection() {
    cpds.close()
  }

}
