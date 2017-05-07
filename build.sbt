name := "adornment"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies +="org.scalatest" %% "scalatest" % "3.0.1" % "test"

mainClass in assembly := Some("main.Adornment")

assemblyJarName in assembly := "adornment.jar"