package functional

import org.scalatest.{FunSpec, Matchers}

class TestOnlyOneOfEachKind extends FunSpec with Matchers {

  describe("OnlyOneOfEachKind") {

    val withFootwear = DressState(Some(Sandals), None, None, None, None, None, None)
    val withHeadwear = DressState(None, Some(Hat), None, None, None, None, None)
    val withSocks = DressState(None, None, Some(Socks), None, None, None, None)
    val withShirt = DressState(None, None, None, Some(Shirt), None, None, None)
    val withJacket = DressState(None, None, None, None, Some(Jacket), None, None)
    val withLegwear = DressState(None, None, None, None, None, Some(Pants), None)
    val withPajamas = DressState.initialState


    it("should pass if you're putting on clothes you don't already have on") {

      OnlyOneOfEachKind(withHeadwear, PutOn(Sandals), HOT) should be (Pass)
      OnlyOneOfEachKind(withFootwear, PutOn(Hat), HOT) should be (Pass)
      OnlyOneOfEachKind(withFootwear, PutOn(Socks), HOT) should be (Pass)
      OnlyOneOfEachKind(withFootwear, PutOn(Shirt), HOT) should be (Pass)
      OnlyOneOfEachKind(withFootwear, PutOn(Jacket), HOT) should be (Pass)
      OnlyOneOfEachKind(withFootwear, PutOn(Pants), HOT) should be (Pass)
      OnlyOneOfEachKind(withFootwear, PutOn(Pajamas), HOT) should be (Pass) // PutOn(Pajamas) *should* never happen*

    }

    it("should fail if you're trying to put on clothes you already have on") {

      OnlyOneOfEachKind(withFootwear, PutOn(Sandals), HOT) should be (Fail)
      OnlyOneOfEachKind(withHeadwear, PutOn(Sunglasses), HOT) should be (Fail)
      OnlyOneOfEachKind(withSocks, PutOn(Socks), HOT) should be (Fail)
      OnlyOneOfEachKind(withShirt, PutOn(Shirt), HOT) should be (Fail)
      OnlyOneOfEachKind(withJacket, PutOn(Jacket), HOT) should be (Fail)
      OnlyOneOfEachKind(withLegwear, PutOn(Shorts), HOT) should be (Fail)
      OnlyOneOfEachKind(withPajamas, PutOn(Pajamas), HOT) should be (Fail) // PutOn(Pajamas) *should* never happen*

    }

    it("should pass if the command is something other than to put on clothes") {

      OnlyOneOfEachKind(withFootwear, LeaveHouse, HOT) should be (Pass)

    }
  }

}
