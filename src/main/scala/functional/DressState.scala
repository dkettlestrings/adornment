package functional

trait DressState {

  def +(command: Command): DressState

  def -(command: Command): DressState

  def has(command: PutOn): Boolean

}

case object PJsOnly extends DressState {

  override def +(command: Command): DressState = command match {

    case TakeOffPajamas => DressState.nude
    case _ => this
  }

  override def -(command: Command): DressState = this

  override def has(command: PutOn): Boolean = false

}

case class NoPJsState(appliedCommands: Set[Command]) extends DressState {

  override def +(command: Command): DressState = {

    NoPJsState(this.appliedCommands + command)
  }

  override def -(command: Command): DressState = {

    NoPJsState(appliedCommands - command)
  }

  override def has(command: PutOn): Boolean = appliedCommands.contains(command)

}

object DressState {

  val nude = NoPJsState(Set.empty)

}
