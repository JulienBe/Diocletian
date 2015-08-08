package game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import game.objects.Thing
import game.show.Show
import game.world.MagicPot

/**
 * Created by julien on 05/08/15.
 */
class Engine {

  val time = 0f
  val show = new Show
  val magicPot = new MagicPot
  val blocs: List[Thing] = Nil
  val balls: List[Thing] = Nil

  def init() = {
    magicPot create blocs
  }

  def draw(batch: SpriteBatch) = {
    Gdx.gl.glClearColor(1, 0, 0, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    batch.begin()

    show.enemies(blocs, batch)
    show.balls(balls, batch)

    batch.end()
  }

}
