package game.world

import com.badlogic.gdx.Gdx
import game.objects.{Cell, Blocs}

/**
 * Created by julien on 08/08/15.
 */
class Grid {
  // probably want to move to a flat array later
  // TRUE : Taken
  val grid = Array.fill[Boolean](GridValue.maxRows, GridValue.maxColumns)(false)

  def canFit(bloc: Blocs, cell: Cell): Boolean = {
    for (r <- cell.row until cell.row + bloc.rowSpan)
      for (c <- cell.col until cell.col + bloc.colSpan)
        if (grid(r)(c))
          return false
    true
  }

  def forcePlace(bloc: Blocs, cell: Cell) = {
    for (r <- cell.row until cell.row + bloc.rowSpan)
      for (c <- cell.col until cell.col + bloc.colSpan)
        grid(r)(c) = true
  }

  def place(bloc: Blocs, cell: Cell) = {
    if (canFit(bloc, cell)) {
      forcePlace(bloc, cell)
      bloc.place(cell)
    }
  }

}

object GridValue {

  val maxColumns = 24
  val maxRows = 18
  val height = Gdx.graphics.getHeight
  val width = Gdx.graphics.getWidth

  val uW = height / maxColumns
  val uH = width / 40f
  val cellWidth = uW
  val cellHeight = uH

  def getColX(cell: Cell) = cell.col * GridValue.cellWidth
  def getRowY(cell: Cell) = height - (cell.row * cellHeight)
}