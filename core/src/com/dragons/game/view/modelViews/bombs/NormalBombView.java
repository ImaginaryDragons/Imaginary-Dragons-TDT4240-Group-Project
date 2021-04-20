package com.dragons.game.view.modelViews.bombs;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.IModel;
import com.dragons.game.model.blocks.IBlock;
import com.dragons.game.model.bombs.IBomb;
import com.dragons.game.model.bombs.NormalBomb;
import com.dragons.game.view.modelViews.IModelView;
import com.dragons.game.view.modelViews.ModelView;
import com.dragons.game.view.modelViews.modelViewFactories.BombViewFactory;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.BOMB1;
import static com.dragons.game.utilities.AssetLoader.BOMB2;
import static com.dragons.game.utilities.AssetLoader.BOMB3;
import static com.dragons.game.utilities.AssetLoader.BOMB4;



public class NormalBombView extends ModelView {

    public NormalBombView(IModel model, AnnotationAssetManager manager) {
        super(model);
        Texture[] bombTextures = new Texture[]{
                manager.get(BOMB1, Texture.class),
                manager.get(BOMB2, Texture.class),
                manager.get(BOMB3, Texture.class),
                manager.get(BOMB4, Texture.class),
        };

        Animation<Texture> animation = new Animation<>(FRAME_DURATION, bombTextures);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        super.setAnimation(animation);



    }


}