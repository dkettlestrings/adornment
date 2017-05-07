# adornment
An interview-style problem and solution


## Tests and Coverage

Run `sbt clean coverage test coverageReport`.  You can find the coverage report in `target/scala-2.12/scoverage-report/index.html`.

## Building

To build an executable jar, run `sbt assembly`.  This will create the executable `adornment.jar` in your `target/scala-2.12` directory.

## Running

Simply run `java -jar <commands>`.  For example:

> `java -jar HOT 8, 6, 4, 2, 1, 7`

or without commas if you prefer:

> `java -jar HOT 8 6 4 2 1 7`

## Explanations

This section briefly describes *why* I made the implementation decisions you see here.  

In my mind, the real complexity of the problem lies not in the state of dress at any point in time, but rather in the application of 
rules.  Therefore, I thought it was a good ide to separate the rules from the data/state.  This leads to a more functional programming 
approach.

In terms of maintainability, I had to make an assumption between whether it was more likely that new data types (articles of clothing)
or new rules (behaviors) would be added.  It has been my experience that new business rules and behaviors are more common than new data 
types.  This again leads to a more functional rather than object-oriented approach.  This is not the correct place to go into the tradeoffs
between OO and FP and their relationship with the Open-Closed Principle, but in general it is easier to add new data types in an OO 
codebase and easier to add new behavior in a FP codebase.  Again, since the *rules* were the more central part of the problem, I 
focused on those leading to a more functional approach.

## Possible Questions

Let me just address a few more possible questions and concerns.

### How would I add new rules?

You would simply need to create a new `object` that extends `Rule`.  In addition, if you wanted it to be picked up automatically, you 
would have to add it to the `DefaultRules` object.  Of course, we could always use reflection or macros to grab all of them at 
runtime or compile time respectively.

### How would I add new clothing?

Given the functional approach, this is harder.  You would need to add another entry to `DressState`.  In addition, you would probably 
want to add another `Command` (the `Commands` and the state of dress are essentially 1 to 1).  For the compiler to keep helping you with
exhaustion checking, you'd have to crack open some code and add it to some `match` statements.  It's not as easy as adding a `Rule`.

### If `Command`s and `DressState` are so tightly coupled, why did you do it that way?

Yes, I *could* have made `DressState` simply an aggregation of applied `Commands`, removing the need to modify it if we wanted to add 
more clothing types.






Todo:
say why I built it this way
Rename package?
