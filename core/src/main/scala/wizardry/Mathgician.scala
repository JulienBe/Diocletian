package wizardry

import scala.util.Random

/**
 * Created by julien on 06/08/15.
 */
object Mathgician {

  val rand = new Random

  def invokeNumber(min: Float, max: Float, average: Float) : Float =  {
    min + getDeviantRand(getPivot(min, max, average)) * (max-min)
  }

  def getPivot(min: Float, max: Float, average: Float): Float = {
    1 / ((max - min) / (average - min))
  }

  def getDeviantRand(pivot: Float): Float = {
    rand.nextFloat() + rand.nextFloat() * ((pivot - .5f) * 2)
  }

}
