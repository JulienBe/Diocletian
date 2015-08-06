package game.objects

import scala.util.Random

/**
 * Created by julien on 06/08/15.
 */
class MagicPot {

  val rand = new Random
  val rows = 6
  val columns = 21

  def create(blocs: List[Thing]) = {
    for (row <- 0 until rows) {
      for (col <- 0 until columns) {
        val bloc: Blocs = createBloc(1, 2, 1.2f)
      }
    }

  }

  def createBloc(minLvl: Int, maxLvl: Int, averageLvl: Float): Blocs = {
    val bloc = BlocMaker.newBloc()
    rand.nextFloat * (maxLvl - minLvl)
    return bloc
  }

}
