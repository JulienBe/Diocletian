package game.objects

import com.badlogic.gdx.math.Vector2

/**
 * Created by julien on 06/08/15.
 */
class Blocs extends Thing {

  val pos = new Vector2()
  val bricks: List[Bricks] = Nil

}

object BlocMaker {

  def newBloc(): Blocs = { new Blocs() }

}
