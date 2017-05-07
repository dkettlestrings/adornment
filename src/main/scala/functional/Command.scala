package functional

sealed trait Command {

  def message(temperature: Temperature): String

}

case object LeaveHouse extends Command {

  override def message(temperature: Temperature): String = "leaving house"

}
case object TakeOffPajamas extends Command {

  override def message(temperature: Temperature): String = "Removing PJs"

}

sealed trait PutOn extends Command

case object PutOnFootwear extends Command with PutOn {

  override def message(temperature: Temperature): String = temperature match {

    case HOT => "sandals"
    case COLD => "boots"
  }

}
case object PutOnHeadwear extends Command with PutOn {

  override def message(temperature: Temperature): String = temperature match {

    case HOT => "sunglasses"
    case COLD => "hat"
  }

}
case object PutOnSocks extends Command with PutOn {

  override def message(temperature: Temperature): String = temperature match {

    case HOT => throw new IllegalStateException("you're putting on socks when it's hot!")
    case COLD => "socks"
  }

}
case object PutOnShirt extends Command with PutOn {

  override def message(temperature: Temperature): String = "shirt"

}
case object PutOnJacket extends Command with PutOn {

  override def message(temperature: Temperature): String = temperature match {

    case HOT => throw new IllegalStateException("you're putting on a jacket when it's hot!")
    case COLD => "jacket"
  }

}
case object PutOnPants extends Command with PutOn {

  override def message(temperature: Temperature): String = temperature match {

    case HOT => "shorts"
    case COLD => "pants"
  }

}


