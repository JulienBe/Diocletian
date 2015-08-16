package game.world

import game.objects.{Cell, BlocMaker, Thing}
import org.scalatest.{Matchers, FlatSpec}
import utilities.GdxMock

/**
 * Created by julien on 13/08/15.
 */
class PhysicTest extends FlatSpec with Matchers {

  it should "be able to test a thing is displayed completely" in {
    GdxMock.graphics

    Physic.isDisplayedCompletely(new Thing(0,                   0,                    1,  1 )) should be (true)
    Physic.isDisplayedCompletely(new Thing(-1,                  0,                    1,  1 )) should be (false)
    Physic.isDisplayedCompletely(new Thing(0,                   -1,                   1,  1 )) should be (false)
    Physic.isDisplayedCompletely(new Thing(GridValue.width,     0,                    1,  1 )) should be (false)
    Physic.isDisplayedCompletely(new Thing(0,                   GridValue.height,     1,  1 )) should be (false)
    Physic.isDisplayedCompletely(new Thing(0,                   GridValue.height -1,  1,  1 )) should be (true)
    Physic.isDisplayedCompletely(new Thing(GridValue.width -1,  0,                    1,  1 )) should be (true)
    Physic.isDisplayedCompletely(new Thing(GridValue.width -5,  0,                    10, 1 )) should be (false)
    Physic.isDisplayedCompletely(new Thing(0,                   GridValue.height -5,  1,  10)) should be (false)
  }

  it should "determine if a bloc is within the grid" in {
    GdxMock.graphics

    val bloc = BlocMaker.newBloc(1)
    bloc.cell = new Cell(0, 0)
    Physic.isWithinGrid(bloc) should be(true)
    bloc.cell = new Cell(-1, 0)
    Physic.isWithinGrid(bloc) should be(false)
    bloc.cell = new Cell(0, -1)
    Physic.isWithinGrid(bloc) should be(false)
    bloc.cell = new Cell(GridValue.maxRows - bloc.rowSpan, 0)
    Physic.isWithinGrid(bloc) should be(true)
    bloc.cell = new Cell(1 + GridValue.maxRows - bloc.rowSpan, 0)
    Physic.isWithinGrid(bloc) should be(false)
    bloc.cell = new Cell(0, GridValue.maxColumns - bloc.colSpan)
    Physic.isWithinGrid(bloc) should be(true)
    bloc.cell = new Cell(0, 1 + GridValue.maxColumns - bloc.colSpan)
    Physic.isWithinGrid(bloc) should be(false)
  }

}
