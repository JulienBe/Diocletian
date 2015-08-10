package game.objects

import com.badlogic.gdx.math.Vector2
import game.world.GridValue

/**
 * Created by julien on 06/08/15.
 */
class Blocs extends Thing {

  var lvl = 1
  val pos = new Vector2()
  val bricks: List[Bricks] = Nil
  var colSpan = 3
  var rowSpan = 1
  width = GridValue.cellWidth
  height = GridValue.cellHeight

  def setLvl(i: Int) = {
    lvl = i
  }

}

object BlocMaker {

  def newBloc(lvl: Int): Blocs = {
    val b = new Blocs()
    b.lvl = lvl
    b.width = GridValue.cellWidth * 3
    b
  }

}
