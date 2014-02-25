name := "Akka Cron DB Test"

version := "0.1"

scalacOptions ++= Seq("-feature")

resolvers += "typesafe" at "http://repo.typesafe.com/typesafe/releases"

libraryDependencies ++= Seq(
  "play" %% "anorm" % "2.1.5",
  "postgresql" % "postgresql" % "9.1-901.jdbc4",
  "com.typesafe.akka" %% "akka-actor" % "2.2.3",
  "com.typesafe.akka" %% "akka-quartz-scheduler" % "1.2.0-akka-2.2.x"
)

