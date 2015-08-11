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
    val bloc: Blocs = BlocMaker.newBloc(1)
    grid canFit(bloc, Cell(0, 0)) should be(true)
    grid.forcePlace(bloc, Cell(0, 0))
    grid canFit(bloc, Cell(0, 0)) should be(false)
    grid canFit(bloc, Cell(0, 1)) should be(false)

    grid canFit(bloc, Cell(1, 2)) should be(true)
    grid.forcePlace(bloc, Cell(1,2))
    grid canFit(bloc, Cell(1, 2)) should be(false)
    grid canFit(bloc, Cell(1, 3)) should be(false)
    grid canFit(bloc, Cell(1, 4)) should be(false)
    grid canFit(bloc, Cell(1, 1)) should be(false)
    grid canFit(bloc, Cell(1, 5)) should be(true)
    grid canFit(bloc, Cell(2, 2)) should be(true)

    val lvl2 = BlocMaker.newBloc(2)
    grid.forcePlace(bloc, Cell(4, 4))
  }


}
