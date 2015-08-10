package be.julien.diocletian

import com.badlogic.gdx.backends.lwjgl._

object Main extends App {
    val cfg = new LwjglApplicationConfiguration
    cfg.title = "Diocletian"
    cfg.height = 800
    cfg.width = 480
    cfg.forceExit = false
    new LwjglApplication(new Diocletian, cfg)
}
