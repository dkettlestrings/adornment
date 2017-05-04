package functional

sealed trait Rule extends ((DressState, Command, Temperature) => RuleOutcome)

object PJsComeOffBeforeOtherStuffGoesOn extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = command match {

    case PutOn(_) => if(state.pajamas.isDefined) Fail else Pass
    case _ => Pass
  }

}

object OnlyOneOfEachKind extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = command match {

    case PutOn(clothing) => clothing match {

      case _: Footwear => if(state.footwear.isDefined) Fail else Pass
      case _: Headwear => if(state.headwear.isDefined) Fail else Pass
      case Socks => if(state.socks.isDefined) Fail else Pass
      case Shirt => if(state.shirt.isDefined) Fail else Pass
      case Jacket => if(state.jacket.isDefined) Fail else Pass
      case _: Legwear => if(state.legwear.isDefined) Fail else Pass
      case Pajamas => if(state.pajamas.isDefined) Fail else Pass
    }

    case _ => Pass
  }
}

object NoSocksWhenHot extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = temperature match {

    case HOT => if(state.socks.isDefined) Fail else Pass
    case COLD => Pass
  }
}

object NoJacketWhenHot extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = temperature match {

    case HOT => if(state.jacket.isDefined) Fail else Pass
    case COLD => Pass
  }
}

object SocksBeforeFootwear extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = command match {

    case PutOn(Socks) => if(state.footwear.isDefined) Fail else Pass
    case _ => Pass
  }
}

object LegwearBeforeFootwear extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = command match {

    case PutOn(_: Legwear) => if(state.footwear.isDefined) Fail else Pass
    case _ => Pass
  }
}

object ShirtBeforeHeadwear extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = command match {

    case PutOn(Shirt) => if(state.headwear.isDefined) Fail else Pass
    case _ => Pass
  }
}

object ShirtBeforeJacket extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = command match {

    case PutOn(Shirt) => if(state.jacket.isDefined) Fail else Pass
    case _ => Pass
  }
}

object AllClothesOnBeforeLeaving extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = command match {

    case LeaveHouse => temperature match {

      case HOT =>
        if(state == DressState(Some(Sandals), Some(Sunglasses), None, Some(Shirt), None, Some(Shorts), None)) Pass else Fail

      case COLD =>
        if(state == DressState(Some(Boots), Some(Hat), Some(Socks), Some(Shirt), Some(Jacket), Some(Pants), None)) Pass else Fail
    }

    case _ => Pass
  }
}



sealed trait RuleOutcome

case object Pass extends RuleOutcome
case object Fail extends RuleOutcome
