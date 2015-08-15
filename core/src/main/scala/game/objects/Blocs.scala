package game.objects

import com.badlogic.gdx.math.Rectangle
import game.world.GridValue

/**
 * Created by julien on 06/08/15.
 */
class Blocs(var lvl: Int) extends Thing {

  val bricks: List[Bricks] = Nil
  var cell: Cell = Cell(0, 0)
  var colSpan = 3
  var rowSpan = 1

  def this() {    this(1)  }
  def place(cell: Cell) = {
    this.x = GridValue.getColX(cell)
    this.y = GridValue.getRowY(cell)
    this.cell = cell
  }

  def setRectangleToGridSpan(r: Rectangle) = r.set(cell.row, cell.col, rowSpan, colSpan)
  def setLvl(i: Int) = lvl = i

}

object BlocMaker {

  def newBloc(lvl: Int): Blocs = {
    val b = new Blocs(lvl)
    lvl match {
      case 1 => b.colSpan = 3; b.rowSpan = 1
      case 2 => b.colSpan = 3; b.rowSpan = 2
      case 3 => b.colSpan = 3; b.rowSpan = 3
      case 4 => b.colSpan = 4; b.rowSpan = 3
      case 5 => b.colSpan = 5; b.rowSpan = 3
      case 6 => b.colSpan = 6; b.rowSpan = 3
      case 7 => b.colSpan = 7; b.rowSpan = 3
      case _ =>
    }
    b.width = GridValue.cellWidth * b.colSpan
    b.height = GridValue.cellHeight * b.rowSpan
    b
  }

}
