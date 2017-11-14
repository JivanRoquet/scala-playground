scalaVersion := "2.11.8"

name := "AkkaHTTP HelloWorld"
organization := "JivanRoquet"
version := "1.0"

fork := true
showSuccess := false
logLevel in run := Level.Warn

outputStrategy := Some(StdoutOutput)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.0.10"
)

assemblyMergeStrategy in assembly := {
 case PathList("META-INF", xs @ _*) => MergeStrategy.discard
 case x => MergeStrategy.first
}

assemblyJarName in assembly := "akka.jar"

