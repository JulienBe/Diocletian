package game.objects

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Rectangle
import game.world.GridValue

import scala.collection.mutable.ListBuffer

/**
 * Created by julien on 06/08/15.
 *
 * -----------------------
 * |  |  |    0    |  |  |
 * |  |  |---------|  |  |
 * | 6| 4|    1    | 3| 5|
 * |  |  |---------|  |  |
 * |  |  |    2    |  |  |
 * -----------------------
 */
class Blocs extends Thing {

  val bricksOffset = Array(
    Array((0, 0)),
    Array((0, 0), (0, 0)),
    Array((0, 0), (0, 1), (0, 2)),
    Array((0, 0), (0, 1), (0, 2), (3, 2)),
    Array((0, 0), (1, 0), (1, 1), (1, 2), (4, 2)),
    Array((0, 0), (1, 0), (1, 1), (1, 2), (4, 0), (5, 0)),
    Array((0, 0), (1, 0), (2, 0), (2, 1), (2, 2), (5, 0), (6, 0))
  )
  val bricks: ListBuffer[Bricks] = ListBuffer()
  var toLeftCell: Cell = Cell(0, 1)
  var colSpan = 3
  var rowSpan = 1
  var lvl = 0

  def place(topLeftCell: Cell) = {
    x = GridValue.getColXLeft(topLeftCell)
    y = GridValue.getRowYTop(topLeftCell) - (rowSpan * GridValue.cellHeight)
    this.toLeftCell = topLeftCell
    initBricks()
  }

  override def display(batch: SpriteBatch) = {
    bricks.foreach(b => b.display(batch))
    batch.draw(BasicThing.texture, x, y, width - 1, height - 1)
  }

  def initBricks() = {
    for (o <- bricksOffset(lvl))
      addBrick(o._1, o._2)
  }

  def addBrick(xOffset: Int, yOffset: Int) : bricks.type = {
    bricks += new Bricks().pos(x + GridValue.cellWidth * xOffset, y + GridValue.cellHeight * yOffset)
  }

  def setRectangleToGridSpan(r: Rectangle) = r.set(toLeftCell.row, toLeftCell.col, rowSpan, colSpan)
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