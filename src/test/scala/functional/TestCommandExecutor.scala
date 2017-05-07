package functional

import org.scalatest.{FunSpec, Matchers}

class TestCommandExecutor extends FunSpec with Matchers {


  describe("CommandExecutor") {

    it("should pass test case 1") {

      val actual = CommandExecutor(HOT, List(8, 6, 4, 2, 1, 7))
      val expected = List("Removing PJs", "shorts", "shirt", "sunglasses", "sandals", "leaving house")

      actual should be (expected)
    }

    it("should pass test case 2") {

      val actual = CommandExecutor(COLD, List(8, 6, 3, 4, 2, 5, 1, 7))
      val expected = List("Removing PJs", "pants", "socks", "shirt", "hat", "jacket", "boots", "leaving house")

      actual should be (expected)
    }

    it("should pass test case 3") {

      val actual = CommandExecutor(HOT, List(8, 6, 6))
      val expected = List("Removing PJs", "shorts", "fail")

      actual should be (expected)
    }

    it("should pass test case 4") {

      val actual = CommandExecutor(HOT, List(8, 6, 3))
      val expected = List("Removing PJs", "shorts", "fail")

      actual should be (expected)
    }

    it("should pass test case 5") {

      val actual = CommandExecutor(COLD,  List(8, 6, 3, 4, 2, 5, 7))
      val expected = List("Removing PJs", "pants", "socks", "shirt", "hat", "jacket", "fail")

      actual should be (expected)
    }

    it("should pass test case 6") {

      val actual = CommandExecutor(COLD, List(6))
      val expected = List("fail")

      actual should be (expected)
    }
  }

}
