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
      grid.grid(3)(col) should be(false)
      grid.grid(4)(col) should be(true)
      grid.grid(5)(col) should be(true)
      grid.grid(6)(col) should be(false)
    }

  }

}