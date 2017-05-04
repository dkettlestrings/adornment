package functional

import org.scalatest.{FunSpec, Matchers}

class TestNoJacketWhenHot extends FunSpec with Matchers {

  val withJacket = DressState(None, None, None, None, Some(Jacket), None, None)
  val noJacket = DressState(None, None, None, None, None, None, None)

  describe("NoJacketWhenHot") {

    it("should pass if it is cold and you have a jacket on") {

      NoJacketWhenHot(withJacket, LeaveHouse, COLD) should be (Pass)

    }

    it("should pass if it is cold and you have no jacket on") {

      NoJacketWhenHot(noJacket, LeaveHouse, COLD) should be (Pass)

    }

    it("should fail if it is hot and you have a jacket on") {

      NoJacketWhenHot(withJacket, LeaveHouse, HOT) should be (Fail)

    }

    it("should pass if it is hot and you have no jacket on") {

      NoJacketWhenHot(noJacket, LeaveHouse, HOT) should be (Pass)

    }
  }

}
