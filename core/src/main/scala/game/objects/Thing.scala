package game.objects

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import game.world.{Physic, GridValue}

/**
 * Created by julien on 05/08/15.
 */
class Thing(var x: Float, var y: Float, var width: Float, var height: Float) {

  def this() { this(0,0,0,0) }
  def isInBoundary(): Boolean = Physic.isDisplayedCompletely(this)
  def display(batch: SpriteBatch) = {
    batch.setColor(1, 1, 1, 0.5f)
    batch.draw(BasicThing.texture, x, y, width - 1, height - 1)
  }
  def overlap(other: Thing): Boolean = other != this && x < other.x + other.width && x + width > other.x && y < other.y + other.height && y + height > other.y
}

object BasicThing {

  val texture = new Texture("square.png")

}
