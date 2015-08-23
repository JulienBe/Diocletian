package game.world

import game.objects.{Blocs, Thing}
import org.scalatest.{Matchers, FlatSpec}
import utilities.GdxMock

import scala.collection.mutable

/**
 * Created by julien on 13/08/15.
 */
class MagicPotTest extends FlatSpec with Matchers {

  it should "not place blocs outside boundries" in {
    for (i <- 0 to 1000)
      createWorld.forall(t => t.isInBoundary()) should be(true)
  }

  it should "not make blocs overlap" in {
    for (i <- 0 to 1000) {
      val blocs = createWorld
      blocs.foreach(
        b => blocs.foreach(
          other => other.overlap(b) should be(false)
        )
      )
    }
  }

  def createWorld = {
    GdxMock.graphics
    new MagicPot() create(new mutable.MutableList[Thing])
  }

}
