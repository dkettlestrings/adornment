package functional


object RuleRunner {

  def run(dressState: DressState, command: Command, temperature: Temperature, rules: List[Rule]): RuleOutcome = {

    val outcomes: List[RuleOutcome] = rules.map(rule => rule.apply(dressState, command, temperature))

    if(outcomes.forall(_ == Pass)) Pass else Fail

    }

}
