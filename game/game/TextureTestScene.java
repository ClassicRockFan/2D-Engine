package game;

import com.threesidedsquare.engine2D.core.Game;
import com.threesidedsquare.engine2D.core.GameScene;
import com.threesidedsquare.engine2D.core.math.Vector3f;
import com.threesidedsquare.engine2D.object.Sprite;
import com.threesidedsquare.engine2D.object.GameObject;
import com.threesidedsquare.engine2D.object.component.rendering.QuadRender;
import com.threesidedsquare.engine2D.object.component.rendering.QuadRenderTexture;
import com.threesidedsquare.engine2D.rendering.Texture;
import com.threesidedsquare.engine2D.rendering.Window;

public class TextureTestScene extends GameScene{

    public static final String NAME = "TextureTestScene";

    public TextureTestScene() {
        super(NAME);
    }

    @Override
    public void init(Game game) {
        super.init(game);

        GameObject object2 = new GameObject();
        object2.addComponent(new QuadRender(200, 200, 400, 400, 1, 1, 1));
        object2.getTransform().setPosition(new Vector3f(0, 0, 1));

        GameObject object = new GameObject();
        object.getTransform().setPosition(new Vector3f((float)Window.getWidth()/2, (float)Window.getHeight() / 2, 0));
        object.addComponent(new QuadRenderTexture(-100, -100, 100, 100, new Texture("stoneBricks.jpg")));

        Sprite sprite = new Sprite("stoneBricks.jpg");
        sprite.getTransform().setPosition(new Vector3f(200, 200, 200));
        sprite.getTransform().setScale(new Vector3f(0.1f, 0.1f, 0.1f));

        addObject(object2);//second
        addObject(object);//closest
        addObject(sprite);//farthest
    }

    @Override
    public void input(float delta) {
        super.input(delta);
    }
}
