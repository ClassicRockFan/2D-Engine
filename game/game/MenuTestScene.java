package game;

import com.threesidedsquare.engine2D.administrative.Logging;
import com.threesidedsquare.engine2D.core.Game;
import com.threesidedsquare.engine2D.core.GameScene;
import com.threesidedsquare.engine2D.object.MenuButton;
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

        addObject(new MenuButton(new AABB(-100, -100, 100, 100), new Texture("stoneBricks.jpg")) {
            @Override
            public void handle(float delta) {
                Logging.printLog("Pressed Button");

            }
        });

        addObject(getCamera());
    }

    @Override
    public void update(float delta) {
        super.update(delta);
    }
}
