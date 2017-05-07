package main

import functional._

object CommandLineParser {

  def parse(args: Array[String]): CommandSequence = {

    require(args.nonEmpty)

    val cleanedArgs = args.map(arg => arg.filterNot(c => c == ','))

    val temperate: Temperature = cleanedArgs.head match {

      case "HOT" => HOT
      case "COLD" => COLD
      case _ => throw new IllegalArgumentException("The first argument must be either HOT or COLD")

    }

    val commands: List[Command] = cleanedArgs.tail.map(arg => IntToCommand(arg.toInt)).toList

    CommandSequence(temperate, commands)
  }

}
