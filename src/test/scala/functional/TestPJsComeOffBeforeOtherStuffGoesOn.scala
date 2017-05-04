package functional

import org.scalatest.{FunSpec, Matchers}

class TestPJsComeOffBeforeOtherStuffGoesOn extends FunSpec with Matchers {

  val pjsOff = DressState(None, None, None, None, None, None, None)

  describe("PJsComeOffBeforeOtherStuffGoesOn") {

    it("should fail if pjs are on and you try to put on clothes") {

      PJsComeOffBeforeOtherStuffGoesOn(DressState.initialState, PutOn(Socks), HOT) should be (Fail)

    }

    it("should pass if pjs are on and you try to go outside") {

      PJsComeOffBeforeOtherStuffGoesOn(DressState.initialState, LeaveHouse, HOT) should be (Pass)

    }

    it("should pass if pjs are on and you try to take off pjs") {

      PJsComeOffBeforeOtherStuffGoesOn(DressState.initialState, TakeOffPajamas, HOT) should be (Pass)

    }

    it("should pass if pjs are off and you try to put on clothes") {

      PJsComeOffBeforeOtherStuffGoesOn(pjsOff, PutOn(Socks), HOT) should be (Pass)

    }

    it("should pass if pjs are off and you try to go outside") {

      PJsComeOffBeforeOtherStuffGoesOn(pjsOff, LeaveHouse, HOT) should be (Pass)

    }

    it("should pass if pjs are off and you try to take off pjs") {

      PJsComeOffBeforeOtherStuffGoesOn(pjsOff, TakeOffPajamas, HOT) should be (Pass)

    }


  }

}
