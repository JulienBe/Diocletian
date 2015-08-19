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
    createWorld.forall(t => t.isInBoundary()) should be(true)
  }

  it should "not make blocs overlap" in {
    val blocs = createWorld
    blocs.forall(
        b => blocs.forall(other => other.overlap(b))
    ) should be(false)
  }

  def createWorld = {
    GdxMock.graphics
    new MagicPot() create(new mutable.MutableList[Thing])
  }

}
