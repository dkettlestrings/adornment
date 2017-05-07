# adornment
An interview-style problem and solution


## Tests and Coverage

Run `sbt clean coverage test coverageReport`.  You can find the coverage report in

`target/scala-2.12/scoverage-report/index.html`.

## Building

To build an executable jar, run `sbt assembly`.  This will create the executable `adornment.jar` in your `target/scala-2.12` directory.

## Running

Simply run `java -jar <commands>`.  For example:

`java -jar HOT 8, 6, 4, 2, 1, 7`

or without commas if you prefer:

`java -jar HOT 8 6 4 2 1 7`

## Explanation

In my mind, the real complexity of the problem lies not in the state of dress at any point in time, but rather in the application of rules.  Therefore, I thought it was a good idea to separate the rules from the data/state.  This leads to a more functional programming approach.

## Possible Questions

Let me just address a few possible questions and concerns.

### How would I add new rules?

You would simply need to create a new `object` that extends `Rule`.  In addition, if you wanted it to be picked up automatically, you would have to add it to the `DefaultRules` object.  Of course, we could always use reflection or macros to grab all of them at runtime or compile time respectively.

### How would I add new clothing?

To add a new type of clothing, you just need to create a new `Command` for that type of clothing.  Make sure it extends `PutOn`.

### Why is enforcing only one type of each clothing item encoded twice?

The enforcement of this rule is encoded both in the `+` method of `DressState` as well as in the formal rule `OnlyOneOfEachKind`.  I admit this is a bit of a wart, but I didn't want to rely solely on the behavior of a `Set` and I thought that encoding *all* rules as `Rule`s was easier to reason about.

### You keep saying you're using a FP approach, but `DressState` is rather OO.  Why?

The `DressState` piece is essentially a FSM.  I have found OO approaches are slightly cleaner than FP approaches for FSMs.  Therefore, I used a State Pattern-like approach for this part.  Note that it is not a fully faithful usage of the classic GoF State Pattern since that would have required putting the logic for the transitions of state (the rules) into this class.

### Your code coverage is not 100%.  What gives?

You'll notice that the code coverage is 100% for everything except the main class (`Adornment`).  There are three reasons for the lack of tests in this class (object):

1. All of its components are fully tested
2. The risk is low since it has essentially no logic in it, but delegates everything to tested pieces
3. It's harder to test with unit tests because by it's very nature it extends beyond the JVM

Now you *could* test it, but I honestly don't see a great deal of use in this particular case.