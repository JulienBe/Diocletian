package game.objects

import com.badlogic.gdx.math.Vector2

/**
 * Created by julien on 06/08/15.
 */
class Blocs extends Thing {

  var width = 3
  var height = 1
  var lvl = 1
  val pos = new Vector2()
  val bricks: List[Bricks] = Nil


  def setLvl(i: Int) = {
    lvl = i
  }

}

object BlocMaker {

  def newBloc(lvl: Int): Blocs = {
    val b = new Blocs()
    b.lvl = lvl
    b
  }

}
