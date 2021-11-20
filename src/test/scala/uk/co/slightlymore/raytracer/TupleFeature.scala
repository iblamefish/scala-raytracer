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
      assert(p equals RTTuple(4, -4, 3, 1))
    }

    Scenario("RTVector() creates tuples with w=0") {
      Given("v <- RTVector(4, -4, 3")
      val v = RTVector(4, -4, 3)

      Then("v = RTTuple(4, -4, 3, 1)")
      assert(v equals RTTuple(4, -4, 3, 0))
    }
  }
}
