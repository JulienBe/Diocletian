package game.world

import game.objects.{Cell, Blocs}

/**
 * Created by julien on 08/08/15.
 */
class Grid {

  val maxColumns = 21
  val maxRows = 18
  // probably want to move to a flat array later
  // TRUE : Taken
  val grid = Array.fill[Boolean](maxColumns, maxRows)(false)

  def canFit(bloc: Blocs, cell: Cell): Boolean = {
    for (c <- cell.col until cell.col + bloc.width)
      for (r <- cell.row until cell.row + bloc.height)
        if (grid(c)(r))
          return false
    true
  }

  def forcePlace(bloc: Blocs, cell: Cell) = {
    for (c <- cell.col until cell.col + bloc.width)
      for (r <- cell.row until cell.row + bloc.height)
        grid(c)(r) = true
  }

  def place(bloc: Blocs, cell: Cell) = {
    if (canFit(bloc, cell)) {
    }
  }

}
