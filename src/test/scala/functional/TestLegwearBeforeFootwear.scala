package functional

import org.scalatest.{FunSpec, Matchers}

class TestLegwearBeforeFootwear extends FunSpec with Matchers {

  val withPants = DressState(None, None, None, None, None, Some(Pants), None)
  val noPants = DressState(None, None, None, None, None, None, None)
  val withSandals = DressState(Some(Sandals), None, None, None, None, None, None)

  describe("LegwearBeforeFootwear") {

    it("should pass if you have legwear on and you try to put on footwear") {

      LegwearBeforeFootwear(withPants, PutOn(Sandals), COLD) should be (Pass)

    }

    it("should pass if have on no legwear and you try to put on footwear") {

      LegwearBeforeFootwear(noPants, PutOn(Sandals), COLD) should be (Pass)

    }

    it("should fail if you have on footwear and you try to put on legwear") {

      LegwearBeforeFootwear(withSandals, PutOn(Pants), HOT) should be (Fail)

    }

    it("should pass if you're not trying to put on legwear") {

      LegwearBeforeFootwear(withSandals, PutOn(Hat), HOT) should be (Pass)

    }

    it("should pass if you're not trying to put on anything") {

      LegwearBeforeFootwear(withSandals, LeaveHouse, HOT) should be (Pass)

    }
  }

}
