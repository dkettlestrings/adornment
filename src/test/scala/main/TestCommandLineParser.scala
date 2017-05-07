package main

import functional._
import org.scalatest.{FunSpec, Matchers}

class TestCommandLineParser extends FunSpec with Matchers {

  describe("CommandLineParser") {

    it("should fail if empty arguments are passed") {

      intercept[IllegalArgumentException](CommandLineParser.parse(Array[String]()))
    }

    it("should fail if the first entry is not a temperature") {

      intercept[IllegalArgumentException](CommandLineParser.parse(Array("bar")))
    }

    it("should fail if one of the commands is not an int") {

      intercept[IllegalArgumentException](CommandLineParser.parse(Array("HOT", "1", "g")))
    }

    it("should fail if a command is not an int between 1 and 8") {

      intercept[NoSuchElementException](CommandLineParser.parse(Array("HOT", "1", "10")))
    }

    it("should parse if the commands are separated by commas") {

      val expected = CommandSequence(HOT, List(TakeOffPajamas, PutOnPants))
      val actual = CommandLineParser.parse(Array("HOT", "8,", "6"))

      actual should be (expected)
    }

    it("should parse if the commands are not separated by commas") {

      val expected = CommandSequence(COLD, List(TakeOffPajamas, PutOnPants))
      val actual = CommandLineParser.parse(Array("COLD", "8", "6"))

      actual should be (expected)

    }
  }

}
