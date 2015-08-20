package game;

import com.threesidedsquare.engine2D.administrative.Logging;
import com.threesidedsquare.engine2D.core.Game;
import com.threesidedsquare.engine2D.core.GameScene;
import com.threesidedsquare.engine2D.core.math.Vector3f;
import com.threesidedsquare.engine2D.object.GameObject;
import com.threesidedsquare.engine2D.object.MenuButton;
import com.threesidedsquare.engine2D.object.Sprite;
import com.threesidedsquare.engine2D.object.TextRender;
import com.threesidedsquare.engine2D.physics.AABB;
import com.threesidedsquare.engine2D.rendering.Texture;

public class MenuTestScene extends GameScene{

    public static final String NAME = "MenuTestScene";

    public MenuTestScene() {
        super(NAME);
    }

    @Override
    public void init(Game game) {
        super.init(game);


        GameObject sprite = new TextRender("abcdefghijklm nopqrstuvwxyz", 0, 0.1f);

//        GameObject sprite = new TextRender("z");

        sprite.getTransform().setPosition(new Vector3f(-400, 200, -0.2f));

        addObject(sprite);

        MenuButton button = new MenuButton(new AABB(-100, -100, 100, 100), new Texture("simpleFont.png")) {
            @Override
            public void handle(float delta) {
                Logging.printLog("Pressed Button");

            }
        };

        button.getTransform().getPosition().setZ(-0.1f);

        addObject(button);

        MenuButton button2 = new MenuButton(new AABB(100, 100, 200, 200), new Texture("stoneBricks.jpg")) {
            @Override
            public void handle(float delta) {
                Logging.printLog("Pressed Button");

            }
        };

        //button2.getTransform().getPosition().setZ(-0.1f);

        addObject(button2);

    }

    @Override
    public void update(float delta) {
        super.update(delta);
    }
}
