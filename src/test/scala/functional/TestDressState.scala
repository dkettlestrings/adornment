package functional

import org.scalatest.{FunSpec, Matchers}

class TestDressState extends FunSpec with Matchers {

  describe("DressState") {

    describe("PJsOnly") {

      it("should transition to nude if you take off the pajamas") {

        PJsOnly + TakeOffPajamas should be (DressState.nude)
      }

      it("should do nothing if you give it a different command") {

        PJsOnly + PutOnShirt should be (PJsOnly)
      }

      it("should stay in the same state if you try to take off a command") {

        PJsOnly - TakeOffPajamas should be (PJsOnly)
      }

      it("should not have any commands") {

        PJsOnly has PutOnSocks should be (false)
        PJsOnly has PutOnSocks should be (false)
      }

    }

    describe("NoPJsState") {

      it("should transition state for new commands") {

        NoPJsState(Set(PutOnSocks)) + PutOnShirt should be (DressState.nude + PutOnSocks + PutOnShirt)

      }

      it("should stay in the same state for repeated commands") {

        NoPJsState(Set(PutOnSocks)) + PutOnSocks should be (DressState.nude + PutOnSocks)

      }

      it("should remove actions if it has seen them before") {

        NoPJsState(Set(PutOnSocks)) - PutOnSocks should be (DressState.nude)

      }

      it("should stay in the same state if you remove a command it hasn't seen") {

        NoPJsState(Set(PutOnSocks)) - PutOnJacket should be (NoPJsState(Set(PutOnSocks)))

      }

      it("should have commands it has seen") {

        NoPJsState(Set(PutOnSocks)) has PutOnSocks should be (true)

      }

      it("should not have commands it hasn't seen") {

        NoPJsState(Set(PutOnSocks)) has PutOnJacket should be (false)
      }
    }
  }

}
