package game.world

import game.objects.BlocMaker
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by julien on 08/08/15.
 */
class GridTest extends FlatSpec with Matchers {

  it should "know if a bloc fit" in {
    val grid = new Grid
    grid canFit(BlocMaker.newBloc(1), 0, 0) should be true
    grid canFit(BlocMaker.newBloc(1), 0, 0) should be false
  }

}
