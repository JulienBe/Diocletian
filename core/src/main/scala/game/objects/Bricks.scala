package game.objects

import game.world.GridValue

/**
 * Created by julien on 06/08/15.
 */
class Bricks extends Thing {

  width = GridValue.cellWidth * 3
  height = GridValue.cellHeight

  def pos(x: Float, y: Float): Bricks = { this.x = x; this.y = y; this; }

}
