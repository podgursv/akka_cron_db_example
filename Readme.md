Akka Cron DB Test
------------------

A simple `akka`-based example of running a DB function on regular bases. Using the package `akka-quartz-scheduler` because `akka`'s scheduler doesn't offer `cron`-like functionality.  The database used is `Postgresql`, and for the interaction with the DB it uses standalone `Anorm` (part of the `play` framework).

Sources of documentation:

* http://www.jaredarmstrong.name/2012/02/play-2-0-anorm-standalone for standalone `Anorm` (i.e. w/o `play`)
* http://www.playframework.com/documentation/2.2.x/ScalaAnorm for `Anorm` usage
* https://github.com/typesafehub/akka-quartz-scheduler/blob/master/src/test/scala/QuartzSchedulerFunctionalSpec.scala for `akka-quartz-scheduler` usage

TODO:

* error handling (akka style)
* unit tests
* logging
