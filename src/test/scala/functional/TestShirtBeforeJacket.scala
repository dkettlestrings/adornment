package functional

import org.scalatest.{FunSpec, Matchers}

class TestShirtBeforeJacket extends FunSpec with Matchers {

  val withShirt = DressState(None, None, None, Some(Shirt), None, None, None)
  val noShirt = DressState(None, None, None, None, None, None, None)
  val withJacket = DressState(None, None, None, None, Some(Jacket), None, None)

  describe("ShirtBeforeJacket") {

    it("should pass if you have on a shirt and try to put on a jacket") {

      ShirtBeforeJacket(withShirt, PutOn(Jacket), HOT) should be (Pass)

    }

    it("should pass if you have on no shirt and try to put on a jacket") {

      ShirtBeforeJacket(noShirt, PutOn(Jacket), HOT) should be (Pass)

    }

    it("should fail if you have on a jacket and try to put on a shirt") {

      ShirtBeforeJacket(withJacket, PutOn(Shirt), HOT) should be (Fail)

    }

    it("should pass if you're not trying to put on a jacket") {

      ShirtBeforeJacket(withShirt, PutOn(Pants), HOT) should be (Pass)

    }

    it("should pass if you're not trying to put on anything") {

      ShirtBeforeJacket(withShirt, LeaveHouse, HOT) should be (Pass)
    }
  }

}
