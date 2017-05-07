package functional

import org.scalatest.{FunSpec, Matchers}

class TestPJsComeOffBeforeOtherStuffGoesOn extends FunSpec with Matchers {

  describe("PJsComeOffBeforeOtherStuffGoesOn") {

    val pjsOff = DressState.nude

    it("should fail if pjs are on and you try to put on clothes") {

      PJsComeOffBeforeOtherStuffGoesOn(PJsOnly, PutOnFootwear, HOT) should be (Fail)

    }

    it("should pass if pjs are on and you try to go outside") {

      PJsComeOffBeforeOtherStuffGoesOn(PJsOnly, LeaveHouse, HOT) should be (Pass)

    }

    it("should pass if pjs are on and you try to take off pjs") {

      PJsComeOffBeforeOtherStuffGoesOn(PJsOnly, TakeOffPajamas, HOT) should be (Pass)

    }

    it("should pass if pjs are off and you try to put on clothes") {


      PJsComeOffBeforeOtherStuffGoesOn(pjsOff, PutOnSocks, HOT) should be (Pass)

    }

    it("should pass if pjs are off and you try to go outside") {

      PJsComeOffBeforeOtherStuffGoesOn(pjsOff, LeaveHouse, HOT) should be (Pass)

    }

    it("should pass if pjs are off and you try to take off pjs") {

      PJsComeOffBeforeOtherStuffGoesOn(pjsOff, TakeOffPajamas, HOT) should be (Pass)

    }


  }

}
