package game;

import com.threesidedsquare.engine2D.core.CoreEngine;
import com.threesidedsquare.engine2D.administrative.ConsoleWindow;
import com.threesidedsquare.engine2D.administrative.Logging;
import com.threesidedsquare.engine2D.core.Game;

public class Main extends Game{

    public static void main(String[] args){
        System.setProperty("org.lwjgl.librarypath", System.getProperty("user.dir") + "/lib/natives-win");
        Logging.printLog("Successfully Linked Natives");

        ConsoleWindow.getInstance().setVisible(true);
        CoreEngine engine = new CoreEngine(800, 600, "2D Game Engine", 60, new Main());
        engine.start();
    }

    @Override
    public void init(CoreEngine engine) {
        super.init(engine);
        addScene(new RenderTestScene());
        setActiveScene(RenderTestScene.NAME);

        addScene(new TextureTestScene());
        setActiveScene(TextureTestScene.NAME);
    }

    @Override
    public void input(float delta) {
        super.input(delta);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
    }

    @Override
    public void render() {
        super.render();
    }
}
