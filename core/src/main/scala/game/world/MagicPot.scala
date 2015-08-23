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
  val grid = new Grid

  def create(blocs: mutable.MutableList[Thing]) = {
    for (row <- 0 until initRows) {
      var col = 0
      while (col < GridValue.maxColumns)
        col += addBloc(blocs, createBloc(0), row, col)
    }
    blocs
  }

  def addBloc(blocs: mutable.MutableList[Thing], bloc: Blocs, row: Int, col: Int): Int = {
    val cell = Cell(row, col)
    while (!grid.canFit(bloc, cell) && bloc.lvl > 0)
      bloc.setLvl(bloc.lvl - 1)

    if (bloc.lvl >= 0 && grid.canFit(bloc, cell)) {
      grid.place(bloc, cell)
      blocs += bloc
      return bloc.colSpan
    }
    1
  }

  def createBloc(minLvl: Int) = BlocMaker.newBloc(Mathgician.getLevel(minLvl))
}