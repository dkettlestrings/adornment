package functional

import org.scalatest.{FunSpec, Matchers}
import language.postfixOps

class TestLegwearBeforeFootwear extends FunSpec with Matchers {

  val withPants = DressState.nude withPants
  val noPants = DressState.nude
  val witwithFootwearSandals = DressState.nude withFootwear

  describe("LegwearBeforeFootwear") {

    it("should pass if you have legwear on and you try to put on footwear") {

      LegwearBeforeFootwear(withPants, PutOnFootwear, COLD) should be (Pass)

    }

    it("should pass if have on no legwear and you try to put on footwear") {

      LegwearBeforeFootwear(noPants, PutOnFootwear, COLD) should be (Pass)

    }

    it("should fail if you have on footwear and you try to put on legwear") {

      LegwearBeforeFootwear(witwithFootwearSandals, PutOnPants, HOT) should be (Fail)

    }

    it("should pass if you're not trying to put on legwear") {

      LegwearBeforeFootwear(witwithFootwearSandals, PutOnHeadwear, HOT) should be (Pass)

    }

    it("should pass if you're not trying to put on anything") {

      LegwearBeforeFootwear(witwithFootwearSandals, LeaveHouse, HOT) should be (Pass)

    }
  }

}
