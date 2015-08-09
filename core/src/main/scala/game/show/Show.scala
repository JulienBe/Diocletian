package game.show

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import game.objects.Thing

import scala.collection.mutable

/**
 * Created by julien on 05/08/15.
 */
class Show {

  def balls(balls: mutable.MutableList[Thing], batch: SpriteBatch)= {
    balls.foreach(b => b.display(batch))
  }

  def enemies(enemies: mutable.MutableList[Thing], batch: SpriteBatch) = {
    enemies.foreach(e => e.display(batch))
  }

}
