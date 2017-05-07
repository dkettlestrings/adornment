package functional

import org.scalatest.{FunSpec, Matchers}

class TestNoSocksWhenHot extends FunSpec with Matchers {

  val state = DressState.initialState

  describe("NoSocksWhenHot") {

    it("should pass if it is cold and you try to put socks on") {

      NoSocksWhenHot(state, PutOnSocks, COLD) should be (Pass)

    }

    it("should fail if it is hot and you try to put socks on") {

      NoSocksWhenHot(state, PutOnSocks, HOT) should be (Fail)

    }

    it("should pass if you are not trying to put socks on") {

      NoSocksWhenHot(state, LeaveHouse, HOT) should be (Pass)

    }
  }

}
