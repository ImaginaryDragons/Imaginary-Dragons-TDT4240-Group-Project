package com.dragons.game.view.modelViews.blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.blocks.DestructibleBlock;
import com.dragons.game.model.blocks.IBlock;
import com.dragons.game.view.modelViews.IModelView;
import com.dragons.game.view.modelViews.ModelView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.DESTRUCTIBLE_BLOCK;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION1;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION2;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION3;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION4;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION5;

public class DestructibleBlockView extends ModelView {


    public DestructibleBlockView(IModel model, AnnotationAssetManager manager) {
        super(model);
        Texture[] textures = new Texture[]{
                manager.get(DESTRUCTIBLE_BLOCK, Texture.class),
        };
        Animation<Texture> animation = new Animation<>(FRAME_DURATION, textures);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        super.setAnimation(animation);
    }


}
