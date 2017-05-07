package functional

object DefaultRules {

  def apply(): List[Rule] = List(
    AllClothesOnBeforeLeaving,
    LegwearBeforeFootwear,
    NoJacketWhenHot,
    NoSocksWhenHot,
    OnlyOneOfEachKind,
    PJsComeOffBeforeOtherStuffGoesOn,
    ShirtBeforeHeadwear,
    ShirtBeforeJacket
  )

}
