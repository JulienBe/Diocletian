package game.world

import com.badlogic.gdx.{Graphics, Gdx}
import game.objects.{Blocs, Cell, BlocMaker}
import org.scalamock.scalatest.MockFactory
import org.scalatest.{Matchers, FlatSpec}
import utilities.GdxMock

/**
 * Created by julien on 08/08/15.
 */
class GridTest extends FlatSpec with Matchers with MockFactory{

  it should "know if a bloc fit" in {
    GdxMock.graphics

    val grid = new Grid
    val lvl1: Blocs = BlocMaker.newBloc(1)
    grid canFit(lvl1, Cell(0, 0)) should be(true)
    grid.place(lvl1, Cell(0, 0))

    testGrid(grid, 0, 0, 0, 2, true)
    grid.grid(0)(3) should be(false)
    testGrid(grid, 1, 1, 0, 2, false)

    val lvl2 = BlocMaker.newBloc(2)
    grid.canFit(lvl2, Cell(2, 6)) should be(true)
    grid.place(lvl2, Cell(2, 6))
    grid.canFit(lvl2, Cell(4, 6)) should be(true)
    grid.canFit(lvl2, Cell(0, 6)) should be(true)
    grid.canFit(lvl2, Cell(2, 3)) should be(true)
    grid.canFit(lvl2, Cell(2, 9)) should be(true)
    grid.canFit(lvl2, Cell(3, 4)) should be(false)
    grid.canFit(lvl2, Cell(1, 4)) should be(false)
    grid.canFit(lvl2, Cell(1, 8)) should be(false)
    grid.canFit(lvl2, Cell(3, 8)) should be(false)

    grid.canFit(lvl1, Cell(4, 6)) should be(true)
    grid.place(lvl1, Cell(4, 6))
    grid.canFit(lvl1, Cell(3, 9)) should be(true)
    grid.place(lvl1, Cell(3, 9))
    grid.canFit(lvl1, Cell(4, 9)) should be(true)
    grid.place(lvl1, Cell(4, 9))
  }

  def testGrid(grid: Grid, startRow: Int, endRow: Int, startCol: Int, endCol: Int, result: Boolean) = {
    for (row <- startRow to endRow)
      for (col <- startCol to endCol)
        grid.grid(row)(col) should be(result)
  }

  it should "predict a bloc X and Y based on his cell" in {
    GdxMock graphics

    GridValue.getColXLeft(new Cell(0, 0)) should be(0)
    GridValue.getRowYBottom(new Cell(0, 0)) should be(GridValue.height - GridValue.cellHeight)

    GridValue.getColXLeft(new Cell(3, 1)) should be(GridValue.cellWidth)
    GridValue.getRowYBottom(new Cell(1, 3)) should be(GridValue.height - GridValue.cellHeight * 2)

    GridValue.getColXLeft(new Cell(3, 7)) should be(GridValue.cellWidth * 7)
    GridValue.getRowYBottom(new Cell(7, 3)) should be(GridValue.height - GridValue.cellHeight * 8)
  }

}