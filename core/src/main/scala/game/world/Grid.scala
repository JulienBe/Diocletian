package game.world

import game.objects.Blocs

/**
 * Created by julien on 08/08/15.
 */
class Grid {

  val maxColumns = 21
  val maxRows = 18
  // probably want to move to a flat array later
  val grid = Array.ofDim[Blocs](18, 21)


  def canFit(bloc: Blocs, row: Int, col: Int) = {
    true
  }

  def place(bloc: Blocs, row: Int, col: Int) = {
    if (canFit(bloc, row, col)) {

    }
  }

}
