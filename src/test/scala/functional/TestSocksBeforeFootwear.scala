package functional

import org.scalatest.{FunSpec, Matchers}

class TestSocksBeforeFootwear extends FunSpec with Matchers {

  val withSocks = DressState(None, None, Some(Socks), None, None, None, None)
  val noSocks = DressState(None, None, None, None, None, None, None)
  val withBoots = DressState(Some(Boots), None, None, None, None, None, None)

  describe("SocksBeforeFootwear") {

    it("should pass if you have socks on and you try to put on footwear") {

      SocksBeforeFootwear(withSocks, PutOn(Boots), HOT) should be (Pass)

    }

    it("should pass if you have no socks on and you try to put on footwear") {

      SocksBeforeFootwear(noSocks, PutOn(Sandals), COLD) should be (Pass)

    }

    it("should fail if you have footwear on and you try to put on socks") {

      SocksBeforeFootwear(withBoots, PutOn(Socks), COLD) should be (Fail)

    }

    it("should pass if you're not trying to put on footwear") {

      SocksBeforeFootwear(withSocks, PutOn(Hat), COLD) should be (Pass)

    }

    it("should pass if you're not trying to put on anything") {

      SocksBeforeFootwear(withSocks, LeaveHouse, HOT) should be (Pass)

    }
  }

}
