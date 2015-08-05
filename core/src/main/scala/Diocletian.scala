package be.julien.diocletian

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import game.Engine

class Diocletian extends Game {

    var batch: SpriteBatch = null
    var img: Texture = null
    var game: Engine = null

    override def create() {
        batch = new SpriteBatch
        img = new Texture("badlogic.jpg")
        game = new Engine
        game.init()
    }

    override def render() {
        // inputs
        // collision
        // mvt
        game.draw(batch)
    }
}
