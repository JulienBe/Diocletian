package game.show

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import game.objects.Thing

/**
 * Created by julien on 05/08/15.
 */
class Show {

  def balls(balls: List[Thing], batch: SpriteBatch)= {
    balls.foreach(b => b.display())
  }

  def enemies(enemies: List[Thing], batch: SpriteBatch) = {
    enemies.foreach(e => e.display())
  }

}
