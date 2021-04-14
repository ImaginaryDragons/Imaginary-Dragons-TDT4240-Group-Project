package com.dragons.game.view.modelViews.bombs;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Shape;
import com.dragons.game.model.bomb.Fire;
import com.dragons.game.view.modelViews.IModelView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.BOMB1;
import static com.dragons.game.utilities.AssetLoader.BOMB2;
import static com.dragons.game.utilities.AssetLoader.BOMB3;
import static com.dragons.game.utilities.AssetLoader.BOMB4;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION1;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION2;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION3;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION4;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION5;

public class FireView implements IModelView {

    private float x, y;
    private final float height, width;
    private final Texture[] ExplosionTextures;
    private Texture current_frame;
    private static final float FRAME_DURATION = 0.1f;
    private final Animation<Texture> explosion;
    private static float state_time;


    public FireView(Vector2 position, float width, float height, AnnotationAssetManager manager) {
        x = position.x;
        y = position.y;
        this.width = width;
        this.height = height;

        ExplosionTextures = new Texture[]{
                manager.get(EXPLOSION1, Texture.class),
                manager.get(EXPLOSION2, Texture.class),
                manager.get(EXPLOSION3, Texture.class),
                manager.get(EXPLOSION4, Texture.class),
                manager.get(EXPLOSION5, Texture.class)

        };
        explosion = new Animation<Texture>(FRAME_DURATION, ExplosionTextures);
        explosion.setPlayMode(Animation.PlayMode.LOOP);
        state_time = 0;

    }

    @Override
    public void update(float delta, Vector2 position) {
        state_time += delta;

    }

    @Override
    public void render(SpriteBatch batch) {
        current_frame = explosion.getKeyFrame(state_time, true);
        //sb.draw(texture, fire.getPosition().x - width / 2f, fire.getPosition().y - width / 2f, width, height);
        batch.draw(current_frame, x - width / 2f, y - width / 2f, width, height);
    }
}
