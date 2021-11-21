package uk.co.slightlymore.raytracer

class TuplesFeature extends Feature {
  Feature("Tuples") {
    Scenario("A tuple with w=1.0 is a point") {
      Given("t ← RTTuple(4.3, -4.2, 3.1, 1.0)")
      val x = 4.3
      val y = -4.2
      val z = 3.1
      val w = 1.0
      val t = RTTuple(x, y, z, w)

      Then("The values of x, y, z, w are set as expected")
      assert(t.x == x)
      assert(t.y == y)
      assert(t.z == z)
      assert(t.w == w)

      And("t should be a Point")
      And("t should not be a Vector")
      t match {
        case RTPoint(_, _, _)  => assert(true)
        case RTVector(_, _, _) => assert(false)
      }
    }

    Scenario("A tuple with w=0.0 is a Vector") {
      Given("t ← RTTuple(4.3, -4.2, 3.1, 0.0)")
      val x = 4.3
      val y = -4.2
      val z = 3.1
      val w = 0.0
      val t = RTTuple(x, y, z, w)

      Then("The values of x, y, z, w are set as expected")
      assert(t.x == x)
      assert(t.y == y)
      assert(t.z == z)
      assert(t.w == w)

      And("t should not be a Point")
      And("t should be a Vector")
      t match {
        case RTPoint(_, _, _)  => assert(false)
        case RTVector(_, _, _) => assert(true)
      }
    }

    Scenario("RTPoint() creates tuples with w=1") {
      Given("p <- RTPoint(4, -4, 3")
      val p = RTPoint(4, -4, 3)

      Then("p = RTTuple(4, -4, 3, 1)")
      assert(p == RTTuple(4, -4, 3, 1))
    }

    Scenario("RTVector() creates tuples with w=0") {
      Given("v <- RTVector(4, -4, 3")
      val v = RTVector(4, -4, 3)

      Then("v = RTTuple(4, -4, 3, 1)")
      assert(v == RTTuple(4, -4, 3, 0))
    }

    Scenario("Adding two tuples") {
      Given("a1 <- RTTuple(3, -2, 5, 1)")
      val a1 = RTTuple(3, -2, 5, 1)

      And("a2 <- RTTuple(-2, 3, 1, 0)")
      val a2 = RTTuple(-2, 3, 1, 0)

      When("a3 <- a1 + a2")
      val a3 = a1 + a2

      Then("a3 = RTTuple(1, 1, 6, 1)")
      assert(a3 == RTTuple(1, 1, 6, 1))
    }
  }

  Scenario("Subtracting two points") {
    Given("p1 <- RTPoint(3, 2, 1")
    val p1 = RTPoint(3, 2, 1)

    And("p2 <- RTPoint(5, 6, 7)")
    val p2 = RTPoint(5, 6, 7)

    When("p3 <- p1 - p2")
    val p3 = p1 - p2

    Then("p3 = RTVector(-2, -4, -6)")
    assert(p3 == RTVector(-2, -4, -6))
  }

  Scenario("Subtracting a vector from a point") {
    Given("p <- RTPoint(3, 2, 1)")
    val p = RTPoint(3, 2, 1)

    And("v <- RTVector(5, 6, 7)")
    val v = RTVector(5, 6, 7)

    When("p2 <- p - v")
    val p2 = p - v

    Then("p2 = RTPoint(-2, -4, -6)")
    assert(p2 == RTPoint(-2, -4, -6))
  }

  Scenario("Subtracting two vectors") {
    Given("v1 <- RTVector(3, 2, 1)")
    val v1 = RTVector(3, 2, 1)

    And("v2 <- RTVector(5, 6, 7)")
    val v2 = RTVector(5, 6, 7)

    When("v3 <- v1 - v2")
    val v3 = v1 - v2

    Then("v3 = RTVector(-2, -4, -6)")
    assert(v3 == RTVector(-2, -4, -6))
  }

  Scenario("Subtracting a vector from the zero vector") {
    Given("zero <- RTVector(0, 0, 0)")
    val zero = RTVector(0, 0, 0)

    And("v <- RTVector(1, -2, 3)")
    val v = RTVector(1, -2, 3)

    When("v2 <- zero - v")
    val v2 = zero - v

    Then("v2 = RTVector(-1, 2, -3)")
    assert(v2 == RTVector(-1, 2, -3))
  }

  Scenario("Negating a tuple") {
    Given("a <- RTTuple(1, -2, 3, 4)")
    val a = RTTuple(1, -2, 3, -4)

    When("b <- -a")
    val b = -a

    Then("b = RTTuple(-1, 2, -3, 4)")
    assert(b == RTTuple(-1, 2, -3, 4))
  }
}
