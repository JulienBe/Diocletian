package wizardry

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by julien on 07/08/15.
 */
class MathgicianTest extends FlatSpec with Matchers {

  it should "produce appropriate deviant float" in {
    testAverage(Mathgician.getDeviantRand, 0.5f)
    testAverage(Mathgician.getDeviantRand, 0.25f)
    testAverage(Mathgician.getDeviantRand, 0.6678f)
    testAverage(Mathgician.getDeviantRand, 1.75f)
    testAverage(Mathgician.getDeviantRand, -1.75f)
  }

  def testAverage(method: (Float) => Float, target: Float) = {
    var average = 0f
    for (i <- 1 to 10000000)
      average += method(target)
    (average / 10000000) should be (target +- 0.03f)
  }

  it should "be smart enough to calculate the pivot(al)" in {
    Mathgician.getPivot(0, 1, 0.5f)   should be(0.5f)
    Mathgician.getPivot(0, 1, 0.75f)  should be(0.75f)
    Mathgician.getPivot(1, 6, 2)      should be(0.2f)
    Mathgician.getPivot(-2, 6, 2)     should be(0.5f)
  }
}
