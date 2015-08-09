package game.world

import com.badlogic.gdx.Gdx
import game.objects.{Cell, Blocs}

/**
 * Created by julien on 08/08/15.
 */
class Grid {
  // probably want to move to a flat array later
  // TRUE : Taken
  val grid = Array.fill[Boolean](GridValue.maxColumns, GridValue.maxRows)(false)

  def canFit(bloc: Blocs, cell: Cell): Boolean = {
    for (c <- cell.col until cell.col + bloc.colSpan; if (c >= GridValue.maxColumns))
      for (r <- cell.row until cell.row + bloc.rowSpan; if (r >= GridValue.maxRows))
        if (grid(c)(r))
          return false
    true
  }

  def forcePlace(bloc: Blocs, cell: Cell) = {
    for (c <- cell.col until cell.col + bloc.colSpan; if (c >= GridValue.maxColumns))
      for (r <- cell.row until cell.row + bloc.rowSpan; if (r >= GridValue.maxRows))
        grid(c)(r) = true
  }

  def place(bloc: Blocs, cell: Cell) = {
    if (canFit(bloc, cell)) {
      forcePlace(bloc, cell)
      bloc.x = GridValue.getColX(cell)
      bloc.y = GridValue.getRowY(cell)
    }
  }

}

object GridValue {

  val maxColumns = 25
  val maxRows = 18
  val uW = Gdx.graphics.getWidth / maxColumns
  val uH = Gdx.graphics.getHeight / 40f
  val cellWidth = uW
  val cellHeight = uH
  val sideOffset = 0//(Gdx.graphics.getWidth - (cellWidth * (maxColumns + 1))) / 2

  def getColX(cell: Cell): Float = {
    GridValue.sideOffset + (cell.col * GridValue.cellWidth)
  }

  def getRowY(cell: Cell): Float = {
    (cell.row) * cellHeight
  }
}