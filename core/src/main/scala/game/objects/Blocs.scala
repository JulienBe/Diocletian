package game.objects

import com.badlogic.gdx.math.Rectangle
import game.world.GridValue

/**
 * Created by julien on 06/08/15.
 */
class Blocs extends Thing {

  val bricks: List[Bricks] = Nil
  var cell: Cell = Cell(0, 0)
  var colSpan = 3
  var rowSpan = 1
  var lvl = 0

  def place(cell: Cell) = {
    this.x = GridValue.getColXLeft(cell)
    this.y = GridValue.getRowYBottom(cell)
    this.cell = cell
  }

  def setRectangleToGridSpan(r: Rectangle) = r.set(cell.row, cell.col, rowSpan, colSpan)
  def setLvl(i: Int) = {
    lvl = i
    colSpan = LevelDimension.lvls(lvl).colSpan
    rowSpan = LevelDimension.lvls(lvl).rowSpan
    width = GridValue.cellWidth * colSpan
    height = GridValue.cellHeight * rowSpan
  }

}

object BlocMaker {
  def newBloc(lvl: Int): Blocs = {
    val b = new Blocs
    b.setLvl(lvl)
    b
  }
}

case class Dimension(rowSpan: Int, colSpan: Int)

object LevelDimension  {
  val lvl0 = Dimension(1, 3)
  val lvl1 = Dimension(2, 3)
  val lvl2 = Dimension(3, 3)
  val lvl3 = Dimension(3, 4)
  val lvl4 = Dimension(3, 5)
  val lvl5 = Dimension(3, 6)
  val lvl6 = Dimension(3, 7)

  val lvls = Array(lvl0, lvl1, lvl2, lvl3, lvl4, lvl5, lvl6)
}