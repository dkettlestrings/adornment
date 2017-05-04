package functional

import org.scalatest.{FunSpec, Matchers}

class TestShirtBeforeHeadwear extends FunSpec with Matchers {

  val withShirt = DressState(None, None, None, Some(Shirt), None, None, None)
  val noShirt = DressState(None, None, None, None, None, None, None)
  val withSunglasses = DressState(None, Some(Sunglasses), None, None, None, None, None)

  describe("ShirtBeforeHeadwear") {

    it("should pass if you have on a shirt and you try to put on headwear") {

      ShirtBeforeHeadwear(withShirt, PutOn(Sunglasses), COLD) should be (Pass)

    }

    it("should pass if you have on no shirt and you try to put on headwear") {

      ShirtBeforeHeadwear(noShirt, PutOn(Sunglasses), COLD) should be (Pass)

    }

    it("should fail if you have on headwear and you try to put on a shirt") {

      ShirtBeforeHeadwear(withSunglasses, PutOn(Shirt), COLD) should be (Fail)

    }

    it("should pass if you're not trying to put on headwear") {

      ShirtBeforeHeadwear(withShirt, PutOn(Socks), COLD) should be (Pass)

    }

    it("should pass if you're not trying to put on anything") {

      ShirtBeforeHeadwear(withShirt, LeaveHouse, COLD) should be (Pass)

    }
  }

}
