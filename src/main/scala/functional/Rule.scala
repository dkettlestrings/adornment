package functional

trait Rule extends ((DressState, Command, Temperature) => RuleOutcome)

object PJsComeOffBeforeOtherStuffGoesOn extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = command match {

    case _: PutOn => if(state == PJsOnly) Fail else Pass
    case _ => Pass
  }

}

object OnlyOneOfEachKind extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = command match {

    case clothing: PutOn => if(state has clothing) Fail else Pass
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

    case PutOnSocks => if(state has PutOnFootwear) Fail else Pass
    case _ => Pass
  }
}

object LegwearBeforeFootwear extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = command match {

    case PutOnPants => if(state has PutOnFootwear) Fail else Pass
    case _ => Pass
  }
}

object ShirtBeforeHeadwear extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = command match {

    case PutOnShirt => if(state has PutOnHeadwear) Fail else Pass
    case _ => Pass
  }
}

object ShirtBeforeJacket extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = command match {

    case PutOnShirt => if(state has PutOnJacket) Fail else Pass
    case _ => Pass
  }
}

object AllClothesOnBeforeLeaving extends Rule {

  override def apply(state: DressState, command: Command, temperature: Temperature): RuleOutcome = {

    val hotWeatherClothes = DressState.nude + PutOnFootwear + PutOnHeadwear + PutOnShirt + PutOnPants

    val coldWeatherClothes = hotWeatherClothes + PutOnSocks + PutOnJacket

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