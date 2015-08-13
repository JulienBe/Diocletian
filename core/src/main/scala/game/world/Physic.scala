package game.world

import game.objects.{Blocs, Thing}

/**
 * Created by julien on 13/08/15.
 */
object Physic {

  def isDisplayedCompletely(t: Thing) = t.x >= 0 && t.x + t.width <= GridValue.width && t.y >= 0 && t.y + t.height <= GridValue.height
  def isWithinGrid(b: Blocs) = b.cell.row >= 0 && b.cell.col >= 0 && b.cell.row + b.rowSpan <= GridValue.maxRows && b.cell.col + b.colSpan <= GridValue.maxColumns

}
