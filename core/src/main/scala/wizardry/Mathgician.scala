package wizardry

import scala.util.Random

/**
 * Created by julien on 06/08/15.
 */
object Mathgician {

  val rand = new Random

  def getLevel(minLvl: Int): Int = Math.round(minLvl + Math.abs(rand.nextGaussian())).toInt
  def getPivot(min: Float, max: Float, average: Float): Float = 1 / ((max - min) / (average - min))
  def getDeviantRand(pivot: Float): Float = rand.nextFloat() + rand.nextFloat() * ((pivot - .5f) * 2)

}
