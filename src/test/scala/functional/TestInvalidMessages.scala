package functional

import org.scalatest.{FunSpec, Matchers}

class TestInvalidMessages extends FunSpec with Matchers {

  describe("PutOnJacket and PutOnSocks") {

    it("should throw exceptions if you try to find their printable message when it is hot") {

      intercept[IllegalStateException](PutOnJacket.message(HOT))

      intercept[IllegalStateException](PutOnSocks.message(HOT))
    }
  }

}
