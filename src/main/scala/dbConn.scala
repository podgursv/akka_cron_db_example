package dbConn

import com.typesafe.config.ConfigFactory
import java.sql._

object Db {
  val config = ConfigFactory.load()
  val driver = config.getString("db.driver")
  val url = config.getString("db.url")
  val user = config.getString("db.user")
  val password = config.getString("db.password")

  Class.forName(driver).newInstance

  def getConnection = DriverManager.getConnection(url, user, password)

  def withConnection[A](block: Connection => A): A = {
    val connection = getConnection 
    try {
      block(connection)
    } finally {
      connection.close()
    }
  }

  def withTransaction[A](block: Connection => A): A = {
    withConnection { connection =>
      try {
        connection.setAutoCommit(false)
        val r = block(connection)
        connection.commit()
        r
      } catch {
        case e : Throwable => connection.rollback(); throw e
      }
    }
  }
}


