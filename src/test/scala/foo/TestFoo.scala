package foo

import org.scalatest.{FlatSpec, Matchers}

class TestFoo extends FlatSpec with Matchers {

  "Foo" should "bar" in {

    Foo.bar() should be (1)
  }

}
