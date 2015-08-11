package utilities

import com.badlogic.gdx.{Gdx, Graphics}
import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec

/**
 * Created by julien on 11/08/15.
 */
object GdxMock extends FlatSpec with MockFactory {

  def graphics = {
    Gdx.graphics = mock[Graphics]
    (Gdx.graphics.getWidth _) expects() returning 480
    (Gdx.graphics.getHeight _) expects() returning 800
  }

}
