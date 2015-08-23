package game.world

import game.objects.{Blocs, Thing}

/**
 * Created by julien on 13/08/15.
 */
object Physic {

  def isDisplayedCompletely(t: Thing) = t.x >= 0 && t.x + t.width <= GridValue.width && t.y >= 0 && t.y + t.height <= GridValue.height
  def isWithinGrid(b: Blocs) = b.toLeftCell.row >= 0 && b.toLeftCell.col >= 0 && b.toLeftCell.row + b.rowSpan <= GridValue.maxRows && b.toLeftCell.col + b.colSpan <= GridValue.maxColumns

}
