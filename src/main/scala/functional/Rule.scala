package functional

trait Rule extends ((DressState, Command, Temperature) => RuleOutcome)

object PJsComeOffBeforeOtherStuffGoesOn extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = command match {

    case _: PutOn => if(state.pajamas) Fail else Pass
    case _ => Pass
  }

}

object OnlyOneOfEachKind extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = command match {

    case PutOnFootwear => if(state.footwear) Fail else Pass
    case PutOnHeadwear => if(state.headwear) Fail else Pass
    case PutOnSocks => if(state.socks) Fail else Pass
    case PutOnShirt => if(state.shirt) Fail else Pass
    case PutOnJacket => if(state.jacket) Fail else Pass
    case PutOnPants => if(state.legwear) Fail else Pass
    case _ => Pass
  }
}

object NoSocksWhenHot extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = command match {

    case PutOnSocks => temperature match {

      case HOT => Fail
      case _ => Pass
    }

    case _ => Pass

  }
}

object NoJacketWhenHot extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = command match {

    case PutOnJacket => temperature match {

      case HOT => Fail
      case _ => Pass
    }
    case _ => Pass
  }
}

object SocksBeforeFootwear extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = command match {

    case PutOnSocks => if(state.footwear) Fail else Pass
    case _ => Pass
  }
}

object LegwearBeforeFootwear extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = command match {

    case PutOnPants => if(state.footwear) Fail else Pass
    case _ => Pass
  }
}

object ShirtBeforeHeadwear extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = command match {

    case PutOnShirt => if(state.headwear) Fail else Pass
    case _ => Pass
  }
}

object ShirtBeforeJacket extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = command match {

    case PutOnShirt => if(state.jacket) Fail else Pass
    case _ => Pass
  }
}

object AllClothesOnBeforeLeaving extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = {

    val hotWeatherClothes = DressState.nude.withFootwear.withHeadWear.withShirt.withPants

    val coldWeatherClothes = DressState.nude.withFootwear.withHeadWear.withSocks.withShirt.withJacket.withPants

    command match {

      case LeaveHouse => temperature match {

        case HOT =>
          if(state == hotWeatherClothes) Pass else Fail

        case COLD =>
          if(state == coldWeatherClothes) Pass else Fail
      }

      case _ => Pass
    }
  }
}



sealed trait RuleOutcome

case object Pass extends RuleOutcome
case object Fail extends RuleOutcome