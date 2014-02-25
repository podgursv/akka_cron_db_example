package dbActor

import akka.actor.Actor

case object Tick

object DBFuncExecutioner extends Actor {
  import dbExec._
  def receive = {
    case Tick => DbExec.execDBFunc()
  }
}

