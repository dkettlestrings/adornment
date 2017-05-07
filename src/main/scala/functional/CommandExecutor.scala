package functional

import scala.annotation.tailrec

object CommandExecutor {

  def apply(commandSequence: CommandSequence, rules: List[Rule] = DefaultRules()): List[String] = {

    val temp = commandSequence.temperature

    @tailrec
    def loop(stack: CommandSequence, currentState: DressState, accumulator: List[String]): List[String] = stack.commands match {

      case Nil => accumulator
      case c :: tail => RuleRunner.run(currentState, c, temp, rules) match {

        case Pass => loop(CommandSequence(temp, tail), currentState.apply(c, temp), accumulator :+ c.message(temp))
        case Fail => accumulator :+ "fail"
      }
    }

    loop(commandSequence, DressState.initialState, List.empty)

  }

}
