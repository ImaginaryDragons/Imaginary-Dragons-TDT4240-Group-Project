package com.dragons.game.view.modelViews.bombs;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.bomb.Bomb;
import com.dragons.game.utilities.Constants;
import com.dragons.game.view.modelViews.IModelView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

//import static com.dragons.game.utilities.AssetLoader.BOMB;
import static com.dragons.game.utilities.AssetLoader.BOMB1;
import static com.dragons.game.utilities.AssetLoader.BOMB2;
import static com.dragons.game.utilities.AssetLoader.BOMB3;
import static com.dragons.game.utilities.AssetLoader.BOMB4;

//import static com.dragons.game.utilities.AssetLoader.FIREBALL;


public class BombView implements IModelView {

    private float x, y;
    private final float width, height;
    private float loadingTime;
    private AnnotationAssetManager manager;
    public boolean bombExploded;
    private Texture[] BombTextures;
    private Texture current_frame;
    private static final float FRAME_DURATION = 0.1f;
    private Animation<Texture> bombAnimation;
    private static float state_time;


    public BombView(Vector2 position, float width, float height, AnnotationAssetManager manager) {

        x = position.x;
        y = position.y;
        this.width = width;
        this.height = height;
        this.manager = manager;
        loadingTime = Constants.BombExplodeTime;

        BombTextures = new Texture[]{
                manager.get(BOMB1, Texture.class),
                manager.get(BOMB2, Texture.class),
                manager.get(BOMB3, Texture.class),
                manager.get(BOMB4, Texture.class)
        };
        bombAnimation = new Animation<Texture>(FRAME_DURATION, BombTextures);
        bombAnimation.setPlayMode(Animation.PlayMode.LOOP);
        state_time = 0;
        bombExploded = false;
    }

    @Override
    public void update(float delta, Vector2 position) {
        state_time += delta;
    }

    @Override
    public void render(SpriteBatch batch) {
        current_frame = bombAnimation.getKeyFrame(state_time, true);
        //sb.draw(texture, bomb.getPosition().x - bomb.getWidth() / 2f, bomb.getPosition().y - bomb.getHeight() / 2f , bomb.getWidth(), bomb.getHeight());
        batch.draw(current_frame, x - height / 2f, y - height / 2f , width, height);
    }
}