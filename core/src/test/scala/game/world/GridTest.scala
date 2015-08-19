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
    grid.grid(0)(0) should be(true)
    grid.grid(0)(1) should be(true)
    grid.grid(0)(2) should be(true)
    grid.grid(0)(3) should be(false)
    grid.grid(1)(0) should be(false)
    grid.grid(1)(1) should be(false)
    grid.grid(1)(2) should be(false)

    val lvl2 = BlocMaker.newBloc(2)
    grid place(lvl2, Cell(4, 6))
    for (col <- 6 until 9) {
      grid.grid(2)(col) should be(false)
      grid.grid(3)(col) should be(true)
      grid.grid(4)(col) should be(true)
      grid.grid(5)(col) should be(false)
    }

    grid.canFit(lvl2, Cell(2, 3)) should be(true)
    grid.canFit(lvl2, Cell(3, 3)) should be(true)
    grid.canFit(lvl2, Cell(4, 3)) should be(true)

    grid.canFit(lvl2, Cell(2, 4)) should be(true)
    grid.canFit(lvl2, Cell(3, 4)) should be(false)
    grid.canFit(lvl2, Cell(4, 4)) should be(false)

    grid.canFit(lvl2, Cell(2, 8)) should be(true)
    grid.canFit(lvl2, Cell(3, 8)) should be(false)
    grid.canFit(lvl2, Cell(4, 8)) should be(false)

    grid.canFit(lvl2, Cell(2, 9)) should be(true)
    grid.canFit(lvl2, Cell(3, 9)) should be(true)
    grid.canFit(lvl2, Cell(4, 9)) should be(true)

  }

  it should "predict a bloc X and Y based on his cell" in {
    GdxMock graphics

    GridValue.getColX(new Cell(0, 0)) should be(0)
    GridValue.getRowY(new Cell(0, 0)) should be(GridValue.height - GridValue.cellHeight)

    GridValue.getColX(new Cell(3, 1)) should be(GridValue.cellWidth)
    GridValue.getRowY(new Cell(1, 3)) should be(GridValue.height - GridValue.cellHeight * 2)

    GridValue.getColX(new Cell(3, 7)) should be(GridValue.cellWidth * 7)
    GridValue.getRowY(new Cell(7, 3)) should be(GridValue.height - GridValue.cellHeight * 8)
  }

}