package game.objects

import game.objects.{Cell, Blocs}
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by julien on 14/08/15.
 */
class BlocsTest extends FlatSpec with Matchers {

  it should "be able to tell if two blocs overlap" in {
    val b1 = new Blocs
    val b2 = new Blocs
    b1.rowSpan = 3
    b2.rowSpan = 3
    b1.colSpan = 2
    b2.colSpan = 2

    b1.cell = new Cell(2, 2) // from 2.2 to 4.3
    b2.cell = new Cell(5, 2)

    b1.overlap(b2) should be(false)
    b2.cell = new Cell(2, 4)
    b2.overlap(b1) should be(false)

    b1.cell = new Cell(2, 4)
    b1.overlap(b2) should be(true)

    b1.cell = new Cell(0, 0)
    b2.overlap(b1) should be(true)

    b1.cell = new Cell(4, 3)
    b1.overlap(b2) should be(true)
  }

}
