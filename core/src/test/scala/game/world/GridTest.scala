package game.world

import game.objects.{Blocs, Cell, BlocMaker}
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by julien on 08/08/15.
 */
class GridTest extends FlatSpec with Matchers {

  it should "know if a bloc fit" in {
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
  }

}
