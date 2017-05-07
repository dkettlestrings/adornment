package functional

import org.scalatest.{FunSpec, Matchers}

class TestLegwearBeforeFootwear extends FunSpec with Matchers {

  val withPants = DressState.nude + PutOnPants
  val noPants = DressState.nude
  val withFootwear = DressState.nude + PutOnFootwear

  describe("LegwearBeforeFootwear") {

    it("should pass if you have legwear on and you try to put on footwear") {

      LegwearBeforeFootwear(withPants, PutOnFootwear, COLD) should be (Pass)

    }

    it("should pass if have on no legwear and you try to put on footwear") {

      LegwearBeforeFootwear(noPants, PutOnFootwear, COLD) should be (Pass)

    }

    it("should fail if you have on footwear and you try to put on legwear") {

      LegwearBeforeFootwear(withFootwear, PutOnPants, HOT) should be (Fail)

    }

    it("should pass if you're not trying to put on legwear") {

      LegwearBeforeFootwear(withFootwear, PutOnHeadwear, HOT) should be (Pass)

    }

    it("should pass if you're not trying to put on anything") {

      LegwearBeforeFootwear(withFootwear, LeaveHouse, HOT) should be (Pass)

    }
  }

}
