package main

import akka.actor.Actor
import akka.actor.Props
import com.typesafe.config.ConfigFactory
import com.typesafe.akka.extension.quartz.QuartzSchedulerExtension


object Main {
  val config = { ConfigFactory.parseString(
    """
    akka {
      quartz {
        defaultTimezone = "UTC"
        schedules {
          atTheTopOfTheHour {
            description = "A cron job that runs at the top of each hour"
            expression = "30 59 * ? * *"
          }
        }
      }
    }
    """.stripMargin)
  }


  def main(args: Array[String]) {
    val system = akka.actor.ActorSystem("system", config)

    import dbActor._;
    val receiver = system.actorOf(Props(DBFuncExecutioner))

    val jobDt = QuartzSchedulerExtension(system).schedule("atTheTopOfTheHour", receiver, Tick)
    println("will run job at: " + jobDt)
  }
}

