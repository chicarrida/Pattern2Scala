name := "Pattern2Scala"

version := "0.0.1"

scalaVersion := "2.11.5"

scalacOptions ++= Seq("-feature", "-deprecation")

mainClass in assembly := Some("Main")
resolvers += Resolver.sonatypeRepo("public")

scalaSource in Compile := file("/home/carolinux/Projects/Pattern2Scala/src/") // the default is something like src/main/scala

libraryDependencies ++= Seq(
  "org.processing" % "core" % "2.2.1"
)
