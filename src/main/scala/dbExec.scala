package dbExec

object DbExec {

  def execDBFunc() = {
    val sql = """SELECT id, message
                   FROM test_func()"""

    import dbConn.Db
    Db.withTransaction {
      implicit connection =>
        import anorm.SQL
        import anorm.SqlParser._
        val result: List[(Int,String,Int)] =
          SQL(sql).as((int("id") ~ str("message"))).map(flatten).*)
        println("result id " + result.head._1 + ": " + result.head._2)
    }
  }

}

