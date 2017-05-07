package functional

import org.scalatest.{FunSpec, Matchers}

class TestRuleRunner extends FunSpec with Matchers {

  describe("RuleRunner") {

    object PassingRule1 extends Rule {

      override def apply(v1: DressState, v2: Command, v3: Temperature): RuleOutcome = Pass
    }

    object PassingRule2 extends Rule {

      override def apply(v1: DressState, v2: Command, v3: Temperature): RuleOutcome = Pass
    }

    object FailingRule extends Rule {

      override def apply(v1: DressState, v2: Command, v3: Temperature): RuleOutcome = Fail
    }

    it("should pass if all rules pass") {

      RuleRunner.run(DressState.initialState, PutOnFootwear, COLD, List(PassingRule1, PassingRule2)) should be (Pass)

    }

    it("should pass if there are no rules") {

      RuleRunner.run(DressState.initialState, PutOnFootwear, COLD, List.empty) should be (Pass)

    }

    it("should fail if one of the rules fails") {

      RuleRunner.run(DressState.initialState, PutOnFootwear, COLD, List(PassingRule1, PassingRule2, FailingRule)) should be (Fail)

    }
  }

}
