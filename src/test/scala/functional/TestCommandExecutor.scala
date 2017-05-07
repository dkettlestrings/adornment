package functional

import org.scalatest.{FunSpec, Matchers}

class TestCommandExecutor extends FunSpec with Matchers {


  describe("CommandExecutor") {

    it("should pass test case 1") {

      val commands = List(TakeOffPajamas, PutOnPants, PutOnShirt, PutOnHeadwear, PutOnFootwear, LeaveHouse)

      val actual = CommandExecutor(CommandSequence(HOT, commands))
      val expected = List("Removing PJs", "shorts", "shirt", "sunglasses", "sandals", "leaving house")

      actual should be (expected)
    }

    it("should pass test case 2") {

      val commands = List(TakeOffPajamas, PutOnPants, PutOnSocks, PutOnShirt, PutOnHeadwear, PutOnJacket, PutOnFootwear, LeaveHouse)

      val actual = CommandExecutor(CommandSequence(COLD, commands))
      val expected = List("Removing PJs", "pants", "socks", "shirt", "hat", "jacket", "boots", "leaving house")

      actual should be (expected)
    }

    it("should pass test case 3") {

      val commands = List(TakeOffPajamas, PutOnPants, PutOnPants)

      val actual = CommandExecutor(CommandSequence(HOT, commands))
      val expected = List("Removing PJs", "shorts", "fail")

      actual should be (expected)
    }

    it("should pass test case 4") {

      val commands = List(TakeOffPajamas, PutOnPants, PutOnSocks)

      val actual = CommandExecutor(CommandSequence(HOT, commands))
      val expected = List("Removing PJs", "shorts", "fail")

      actual should be (expected)
    }

    it("should pass test case 5") {

      val commands = List(TakeOffPajamas, PutOnPants, PutOnSocks, PutOnShirt, PutOnHeadwear, PutOnJacket, LeaveHouse)

      val actual = CommandExecutor(CommandSequence(COLD, commands))
      val expected = List("Removing PJs", "pants", "socks", "shirt", "hat", "jacket", "fail")

      actual should be (expected)
    }

    it("should pass test case 6") {

      val commands = List(PutOnPants)

      val actual = CommandExecutor(CommandSequence(COLD, commands))
      val expected = List("fail")

      actual should be (expected)
    }
  }

}
