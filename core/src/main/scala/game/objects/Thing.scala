package game.objects

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

/**
 * Created by julien on 05/08/15.
 */
class Thing {

  var x = 0f
  var y = 0f
  var width = 3f
  var height = 1f

  def display(batch: SpriteBatch) = {
    batch.draw(BasicThing.texture, x, y, width - 1, height - 1)
  }

}

object BasicThing {

  val texture = new Texture("square.png")

}
