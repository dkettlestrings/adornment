package functional

import org.scalatest.{FunSpec, Matchers}

class TestNoSocksWhenHot extends FunSpec with Matchers {

  val withSocks = DressState(None, None, Some(Socks), None, None, None, None)
  val noSocks = DressState(None, None, None, None, None, None, None)

  describe("NoSocksWhenHot") {

    it("should pass if it is cold and you have socks on") {

      NoSocksWhenHot(withSocks, LeaveHouse, COLD) should be (Pass)

    }

    it("should pass if it is cold and you have no socks on") {

      NoSocksWhenHot(noSocks, LeaveHouse, COLD) should be (Pass)

    }

    it("should fail if it is hot and you have socks on") {

      NoSocksWhenHot(withSocks, LeaveHouse, HOT) should be (Fail)

    }

    it("should pass if it is hot and you have no socks on") {

      NoSocksWhenHot(noSocks, LeaveHouse, HOT) should be (Pass)

    }
  }

}
