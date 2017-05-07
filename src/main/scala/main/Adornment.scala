package main

import functional.CommandExecutor

object Adornment extends App {

  val commandSequence = CommandLineParser.parse(args)

  val results = CommandExecutor(commandSequence)

  println(results.mkString(", "))


}
