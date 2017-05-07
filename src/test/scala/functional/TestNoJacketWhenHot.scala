package functional

import org.scalatest.{FunSpec, Matchers}

class TestNoJacketWhenHot extends FunSpec with Matchers {

  val state = DressState.initialState

  describe("NoJacketWhenHot") {

    it("should pass if it is cold and you try to put a jacket on") {

      NoJacketWhenHot(state, PutOnJacket, COLD) should be (Pass)

    }

    it("should fail if it is hot and you try to put a  jacket on") {

      NoJacketWhenHot(state, PutOnJacket, HOT) should be (Fail)

    }

    it("should pass if you are not trying to put a jacket on") {

      NoJacketWhenHot(state, LeaveHouse, HOT) should be (Pass)

    }
  }

}
