package com.dragons.game.view.modelViews.bombs;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.bomb.Bomb;
import com.dragons.game.model.bomb.IBomb;
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

    private Texture[] BombTextures;
    private Texture current_frame;
    private static final float FRAME_DURATION = 0.1f;
    private Animation<Texture> bombAnimation;
    private static float state_time;
    private Bomb bomb;


    public BombView(IModel model, AnnotationAssetManager manager) {

        bomb = (Bomb) model;
        BombTextures = new Texture[]{
                manager.get(BOMB1, Texture.class),
                manager.get(BOMB2, Texture.class),
                manager.get(BOMB3, Texture.class),
                manager.get(BOMB4, Texture.class)
        };
        bombAnimation = new Animation<Texture>(FRAME_DURATION, BombTextures);
        bombAnimation.setPlayMode(Animation.PlayMode.LOOP);
        state_time = 0;

    }

    @Override
    public void update(float delta) {
        state_time += delta;
    }

    @Override
    public void render(SpriteBatch batch) {
        current_frame = bombAnimation.getKeyFrame(state_time, true);
        float x = bomb.getPosition().x;
        float y = bomb.getPosition().y;
        float width = bomb.getWidth();
        float height = bomb.getHeight();

        batch.draw(current_frame, x - height / 2f, y - height / 2f , width, height);
    }
}