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
    for (r <- (cell.row + 1) - bloc.rowSpan to cell.row)
      for (c <- cell.col until cell.col + bloc.colSpan)
        if (r < 0 || c < 0 || c + bloc.colSpan > GridValue.maxColumns || grid(r)(c))
          return false
    true
  }

  def place(bloc: Blocs, cell: Cell) = {
    for (r <- (cell.row + 1) - bloc.rowSpan to cell.row)
      for (c <- cell.col until cell.col + bloc.colSpan)
        grid(r)(c) = true
    bloc.place(cell)
  }
}

object GridValue {

  val maxColumns = 24
  val maxRows = 24
  val height = Gdx.graphics.getHeight
  val width = Gdx.graphics.getWidth

  val uW = width / 48
  val uH = height / 80
  val cellWidth = width / maxColumns
  val cellHeight = height / maxRows

  def getColX(cell: Cell) = cell.col * GridValue.cellWidth
  def getRowY(cell: Cell) = height - ((cell.row + 1) * cellHeight)
}