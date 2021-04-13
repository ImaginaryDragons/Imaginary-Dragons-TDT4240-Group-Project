package com.dragons.game.view.modelViews;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.bomb.Bomb;
import com.dragons.game.utilities.Constants;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

//import static com.dragons.game.utilities.AssetLoader.BOMB;
import static com.dragons.game.utilities.AssetLoader.BOMB1;
import static com.dragons.game.utilities.AssetLoader.BOMB2;
import static com.dragons.game.utilities.AssetLoader.BOMB3;
import static com.dragons.game.utilities.AssetLoader.BOMB4;

//import static com.dragons.game.utilities.AssetLoader.FIREBALL;


public class BombView implements IModelView {

    private Bomb bomb;
    private float loadingTime;
    private AnnotationAssetManager manager;
    public boolean bombExploded;
    private Texture[] BombTextures;
    private Texture current_frame;
    private static float FRAME_DURATION = 0.1f;
    private Animation<Texture> bombAnimation;
    private static float state_time;
    private Texture texture;


    public BombView(Bomb bomb, AnnotationAssetManager manager, Vector2 pos) {
        this.bomb = bomb;
        this.manager = manager;
        loadingTime = Constants.BombExplodeTime;
        Texture texture1;
        Texture texture2;
        Texture texture3;
        Texture texture4;
        BombTextures = new Texture[]{
                texture1 = manager.get(BOMB1, Texture.class),
                texture2 = manager.get(BOMB2, Texture.class),
                texture3 = manager.get(BOMB3, Texture.class),
                texture4 = manager.get(BOMB4, Texture.class)
        };
        bombAnimation = new Animation<Texture>(FRAME_DURATION, BombTextures);
        bombAnimation.setPlayMode(Animation.PlayMode.LOOP);
        state_time = 0;
        bombExploded = false;
    }

    @Override
    public void update(float delta) {
        state_time += delta;
    }

    @Override
    public void render(SpriteBatch sb) {
        current_frame = bombAnimation.getKeyFrame(state_time, true);
        //sb.draw(texture, bomb.getPosition().x - bomb.getWidth() / 2f, bomb.getPosition().y - bomb.getHeight() / 2f , bomb.getWidth(), bomb.getHeight());
        sb.draw(current_frame, bomb.getPosition().x - bomb.getWidth() / 2f, bomb.getPosition().y - bomb.getHeight() / 2f , bomb.getWidth(), bomb.getHeight());
    }
}