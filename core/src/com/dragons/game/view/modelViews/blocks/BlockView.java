package com.dragons.game.view.modelViews.blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.blocks.DestructibleBlock;
import com.dragons.game.model.blocks.IBlock;
import com.dragons.game.model.blocks.WallBlock;
import com.dragons.game.model.bombs.NewBombTemplate;
import com.dragons.game.model.bombs.NormalBomb;
import com.dragons.game.view.modelViews.IModelView;
import com.dragons.game.view.modelViews.ModelView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.BOMB1;
import static com.dragons.game.utilities.AssetLoader.BOMB2;
import static com.dragons.game.utilities.AssetLoader.BOMB3;
import static com.dragons.game.utilities.AssetLoader.BOMB4;
import static com.dragons.game.utilities.AssetLoader.DESTRUCTIBLE_BLOCK;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION1;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION2;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION3;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION4;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION5;
import static com.dragons.game.utilities.AssetLoader.TESTBOMB;

public class BlockView extends ModelView {


    public BlockView(IModel model, AnnotationAssetManager manager) {
        super(model);
        Animation<Texture> animation = new Animation<>(FRAME_DURATION, getTextures(model, manager));
        animation.setPlayMode(Animation.PlayMode.LOOP);
        super.setAnimation(animation);


    }

    private Texture[] getTextures(IModel model, AnnotationAssetManager manager){
        /*
         * Add the textures for the animation
         * Only one texture => static image
         * The textures is the only thing differentiating the BombViews
         */
        if (model instanceof DestructibleBlock) { // Just give the testbomb the same fire textures
            return new Texture[]{
                    manager.get(DESTRUCTIBLE_BLOCK, Texture.class),
            };
        }

        else{
            throw new IllegalArgumentException("Textures havent been initialized for this Block");
        }

    }


}
