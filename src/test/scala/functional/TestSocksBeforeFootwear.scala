package functional

import org.scalatest.{FunSpec, Matchers}

class TestSocksBeforeFootwear extends FunSpec with Matchers {

  val withSocks = DressState.nude + PutOnSocks
  val nude = DressState.nude
  val withFootwear = DressState.nude + PutOnFootwear

  describe("SocksBeforeFootwear") {

    it("should pass if you have socks on and you try to put on footwear") {

      SocksBeforeFootwear(withSocks, PutOnFootwear, HOT) should be (Pass)

    }

    it("should pass if you have no socks on and you try to put on footwear") {

      SocksBeforeFootwear(nude, PutOnFootwear, COLD) should be (Pass)

    }

    it("should fail if you have footwear on and you try to put on socks") {

      SocksBeforeFootwear(withFootwear, PutOnSocks, COLD) should be (Fail)

    }

    it("should pass if you have no footwear on and you try to put on socks") {

      SocksBeforeFootwear(nude, PutOnSocks, HOT) should be (Pass)
    }

    it("should pass if you're not trying to put on footwear") {

      SocksBeforeFootwear(withSocks, PutOnHeadwear, COLD) should be (Pass)

    }

    it("should pass if you're not trying to put on anything") {

      SocksBeforeFootwear(withSocks, LeaveHouse, HOT) should be (Pass)

    }
  }

}
