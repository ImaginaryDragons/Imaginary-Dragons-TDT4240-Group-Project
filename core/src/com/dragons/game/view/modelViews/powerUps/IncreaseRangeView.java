package com.dragons.game.view.modelViews.powerUps;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.IModel;
import com.dragons.game.model.powerUps.IncreaseRange;
import com.dragons.game.utilities.Constants;
import com.dragons.game.view.modelViews.IModelView;
import com.dragons.game.view.modelViews.ModelView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.BOMB_CAP_POWERUP;
import static com.dragons.game.utilities.AssetLoader.RANGE_POWERUP;

public class IncreaseRangeView extends ModelView {

    public IncreaseRangeView(IModel model, AnnotationAssetManager manager) {
        super(model);
        Texture[] textures = new Texture[]{
                manager.get(RANGE_POWERUP, Texture.class),
        };
        Animation<Texture> animation = new Animation<>(FRAME_DURATION, textures);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        super.setAnimation(animation);

    }


}
