package functional

import org.scalatest.{FunSpec, Matchers}
import language.postfixOps

class TestOnlyOneOfEachKind extends FunSpec with Matchers {

  describe("OnlyOneOfEachKind") {

    val withFootwear = DressState.initialState withFootwear
    val withHeadwear = DressState.initialState withHeadWear
    val withSocks = DressState.initialState withSocks
    val withShirt = DressState.initialState withShirt
    val withJacket = DressState.initialState withJacket
    val withLegwear = DressState.initialState withPants
    val withPajamas = DressState.initialState


    it("should pass if you're putting on clothes you don't already have on") {

      OnlyOneOfEachKind(withHeadwear, PutOnFootwear, HOT) should be (Pass)
      OnlyOneOfEachKind(withFootwear, PutOnHeadwear, HOT) should be (Pass)
      OnlyOneOfEachKind(withFootwear, PutOnSocks, HOT) should be (Pass)
      OnlyOneOfEachKind(withFootwear, PutOnShirt, HOT) should be (Pass)
      OnlyOneOfEachKind(withFootwear, PutOnJacket, HOT) should be (Pass)
      OnlyOneOfEachKind(withFootwear, PutOnPants, HOT) should be (Pass)

    }

    it("should fail if you're trying to put on clothes you already have on") {

      OnlyOneOfEachKind(withFootwear, PutOnFootwear, HOT) should be (Fail)
      OnlyOneOfEachKind(withHeadwear, PutOnHeadwear, HOT) should be (Fail)
      OnlyOneOfEachKind(withSocks, PutOnSocks, HOT) should be (Fail)
      OnlyOneOfEachKind(withShirt, PutOnShirt, HOT) should be (Fail)
      OnlyOneOfEachKind(withJacket, PutOnJacket, HOT) should be (Fail)
      OnlyOneOfEachKind(withLegwear, PutOnPants, HOT) should be (Fail)

    }

    it("should pass if the command is something other than to put on clothes") {

      OnlyOneOfEachKind(withFootwear, LeaveHouse, HOT) should be (Pass)

    }
  }

}
