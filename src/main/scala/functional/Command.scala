package functional

sealed trait Command

case class PutOn(clothing: Clothing) extends Command
case object LeaveHouse extends Command
case object TakeOffPajamas extends Command
