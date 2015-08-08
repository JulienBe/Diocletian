package game.world

import game.objects.{BlocMaker, Blocs, Thing}
import wizardry.Mathgician

import scala.util.Random

/**
 * Created by julien on 06/08/15.
 */
class MagicPot {

  val rand = new Random
  val initRows = 6
  val initColumns = 21
  val grid = new Grid

  def create(blocs: List[Thing]) = {
    for (row <- 0 until initRows) {
      var col = 0
      while (col < initColumns) {
        val bloc: Blocs = createBloc(1, 2, 1.2f)
        col += bloc.lvl
        grid.place(bloc, row, col)
      }
    }

  }

  def createBloc(minLvl: Int, maxLvl: Int, averageLvl: Float): Blocs = {
    BlocMaker.newBloc(
      Math.round(Mathgician.invokeNumber(1, 2, 1.2f))
    )
  }

}