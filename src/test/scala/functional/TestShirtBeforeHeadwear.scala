package functional

import org.scalatest.{FunSpec, Matchers}
import language.postfixOps

class TestShirtBeforeHeadwear extends FunSpec with Matchers {

  val withShirt = DressState.nude withShirt
  val noShirt = DressState.nude
  val withHeadwear = DressState.nude withHeadWear

  describe("ShirtBeforeHeadwear") {

    it("should pass if you have on a shirt and you try to put on headwear") {

      ShirtBeforeHeadwear(withShirt, PutOnHeadwear, COLD) should be (Pass)

    }

    it("should pass if you have on no shirt and you try to put on headwear") {

      ShirtBeforeHeadwear(noShirt, PutOnHeadwear, COLD) should be (Pass)

    }

    it("should fail if you have on headwear and you try to put on a shirt") {

      ShirtBeforeHeadwear(withHeadwear, PutOnShirt, COLD) should be (Fail)

    }

    it("should pass if you're not trying to put on headwear") {

      ShirtBeforeHeadwear(withShirt, PutOnSocks, COLD) should be (Pass)

    }

    it("should pass if you're not trying to put on anything") {

      ShirtBeforeHeadwear(withShirt, LeaveHouse, COLD) should be (Pass)

    }
  }

}
