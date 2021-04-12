package com.dragons.game.view.modelViews;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Shape;
import com.dragons.game.model.bomb.Fire;

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

    private Fire fire;
    private Shape shape;
    private Texture texture;
    private float height, width;
    private Texture[] ExplosionTextures;
    private Texture current_frame;
    private static float FRAME_DURATION = 0.1f;
    private Animation<Texture> explosion;
    private static float state_time;


    public FireView(Fire fire, AnnotationAssetManager manager) {
        this.fire = fire;
        this.height = fire.getHeight();
        this.width = fire.getWidth();
        Texture texture1;
        Texture texture2;
        Texture texture3;
        Texture texture4;
        Texture texture5;
        ExplosionTextures = new Texture[]{
                texture1 = manager.get(EXPLOSION1, Texture.class),
                texture2 = manager.get(EXPLOSION2, Texture.class),
                texture3 = manager.get(EXPLOSION3, Texture.class),
                texture4 = manager.get(EXPLOSION4, Texture.class),
                texture5 = manager.get(EXPLOSION5, Texture.class)

        };
        explosion = new Animation<Texture>(FRAME_DURATION, ExplosionTextures);
        explosion.setPlayMode(Animation.PlayMode.LOOP);
        state_time = 0;

    }

    @Override
    public void update(float delta) {
        state_time += delta;

    }

    @Override
    public void render(SpriteBatch sb) {
        current_frame = explosion.getKeyFrame(state_time, true);
        //sb.draw(texture, fire.getPosition().x - width / 2f, fire.getPosition().y - width / 2f, width, height);
        sb.draw(current_frame, fire.getPosition().x - width / 2f, fire.getPosition().y - width / 2f, width, height);
    }
}
