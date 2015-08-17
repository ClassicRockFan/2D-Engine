package game;

import com.threesidedsquare.engine2D.core.Game;
import com.threesidedsquare.engine2D.core.GameScene;
import com.threesidedsquare.engine2D.core.math.Vector3f;
import com.threesidedsquare.engine2D.object.component.GameObject;
import com.threesidedsquare.engine2D.object.component.rendering.QuadRender;
import com.threesidedsquare.engine2D.object.component.rendering.QuadRenderTexture;
import com.threesidedsquare.engine2D.rendering.Texture;
import com.threesidedsquare.engine2D.rendering.Window;
import org.newdawn.slick.opengl.TextureLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TextureTestScene extends GameScene{

    public static final String NAME = "TextureTestScene";

    public TextureTestScene() {
        super(NAME);
    }

    @Override
    public void init(Game game) {
        super.init(game);

        GameObject object = new GameObject();

        object.getTransform().setPosition(new Vector3f((float)Window.getWidth()/2, (float)Window.getHeight() / 2, 0));
            object.addComponent(new QuadRenderTexture(-100, -100, 100, 100, new Texture("stoneBricks.jpg")));

        addObject(object);
    }
}
