package wizardry

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by julien on 07/08/15.
 */
class MathgicianTest extends FlatSpec with Matchers {

  def loopNumber = 1000000

  it should "produce appropriate deviant float" in {
    testAverageLoop(Mathgician.getDeviantRand, 0.5f)
    testAverageLoop(Mathgician.getDeviantRand, 0.25f)
    testAverageLoop(Mathgician.getDeviantRand, 0.6678f)
    testAverageLoop(Mathgician.getDeviantRand, 1.75f)
    testAverageLoop(Mathgician.getDeviantRand, -1.75f)
  }

  def testAverageLoop(method: (Float) => Float, target: Float) = {
    var average = 0f
    for (i <- 1 to loopNumber)
      average += method(target)
    verifyAverage(target, average / loopNumber)
  }

  def testAverageLoop(method: (Float, Float, Float) => Float, min: Float, max: Float, target: Float, verify: (Float, Float) => Unit) = {
    var average = 0f
    for (i <- 1 to loopNumber)
      average += method(min, max, target)
    verify(target, average / loopNumber)
  }

  def verifyAverage(target: Float, average: Float) = average should be(target +- 0.03f)

  it should "be smart enough to calculate the pivot(al)" in {
    Mathgician.getPivot(0, 1, 0.5f)   should be(0.5f)
    Mathgician.getPivot(0, 1, 0.75f)  should be(0.75f)
    Mathgician.getPivot(1, 6, 2)      should be(0.2f)
    Mathgician.getPivot(-2, 6, 2)     should be(0.5f)
  }
}
