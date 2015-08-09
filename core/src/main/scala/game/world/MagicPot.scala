package game.world

import game.objects.{Cell, BlocMaker, Blocs, Thing}
import wizardry.Mathgician

import scala.collection.mutable
import scala.util.Random

/**
 * Created by julien on 06/08/15.
 */
class MagicPot {

  val rand = new Random
  val initRows = 6
  val initColumns = 21
  val grid = new Grid

  def create(blocs: mutable.MutableList[Thing]) = {
    for (row <- 0 until initRows) {
      var col = 0
      while (col < initColumns) {
        val bloc: Blocs = createBloc(1, 2, 1.2f)
        col += bloc.lvl
        grid.place(bloc, Cell(row, col))
        blocs += bloc
      }
    }
  }

  def createBloc(minLvl: Int, maxLvl: Int, averageLvl: Float): Blocs = {
    BlocMaker.newBloc(
      Math.round(Mathgician.invokeNumber(1, 2, 1.2f))
    )
  }

}