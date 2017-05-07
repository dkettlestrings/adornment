package functional

import org.scalatest.{FunSpec, Matchers}

class TestShirtBeforeJacket extends FunSpec with Matchers {

  val withShirt = DressState.nude + PutOnShirt
  val noShirt = DressState.nude
  val withJacket = DressState.nude + PutOnJacket

  describe("ShirtBeforeJacket") {

    it("should pass if you have on a shirt and try to put on a jacket") {

      ShirtBeforeJacket(withShirt, PutOnJacket, HOT) should be (Pass)

    }

    it("should pass if you have on no shirt and try to put on a jacket") {

      ShirtBeforeJacket(noShirt, PutOnJacket, HOT) should be (Pass)

    }

    it("should fail if you have on a jacket and try to put on a shirt") {

      ShirtBeforeJacket(withJacket, PutOnShirt, HOT) should be (Fail)

    }

    it("should pass if you're not trying to put on a jacket") {

      ShirtBeforeJacket(withShirt, PutOnPants, HOT) should be (Pass)

    }

    it("should pass if you're not trying to put on anything") {

      ShirtBeforeJacket(withShirt, LeaveHouse, HOT) should be (Pass)
    }
  }

}
