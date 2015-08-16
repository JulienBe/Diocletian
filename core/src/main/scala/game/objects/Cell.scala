package game.objects

import game.world.GridValue

/**
 * Created by julien on 08/08/15.
 */
case class Cell(val row: Int, val col: Int) {
  def isInBoundary: Boolean = row >= 0 && row <= GridValue.maxRows && col >= 0 && col <= GridValue.maxColumns
}
