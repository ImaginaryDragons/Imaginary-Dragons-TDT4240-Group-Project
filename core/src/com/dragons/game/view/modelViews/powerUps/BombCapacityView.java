package com.dragons.game.view.modelViews.powerUps;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.IModel;
import com.dragons.game.view.modelViews.ModelView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.BOMB_CAP_POWERUP;

public class BombCapacityView extends ModelView {
    private final Animation<Texture> animation;

    public BombCapacityView(IModel model, AnnotationAssetManager manager) {
        super(model);
        Texture[] textures = new Texture[]{
                manager.get(BOMB_CAP_POWERUP, Texture.class),
        };

        animation = new Animation<>(FRAME_DURATION, textures);
        animation.setPlayMode(Animation.PlayMode.LOOP);



    }

    protected void draw(SpriteBatch batch, float x, float y, float width, float height, float state_time){
        final Texture current_frame = animation.getKeyFrame(state_time, true);
        batch.draw(current_frame, x - width / 2f, y - width / 2f, width, height);
    }


}
