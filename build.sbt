name := "Pattern2Scala"

version := "0.0.1"

scalaVersion := "2.11.5"

scalacOptions ++= Seq("-feature", "-deprecation") 

mainClass in assembly := Some("Main") 
//resolvers += Resolver.sonatypeRepo("public") 

resolvers +="Repository" at "https://oss.sonatype.org/content/repositories/public"

scalaSource in Compile := file("/home/linux/Code/Scala/Pattern2Scala/src/") // the default is something like src/main/scala

libraryDependencies += 
  "org.processing" % "core" % "2.2.1"

