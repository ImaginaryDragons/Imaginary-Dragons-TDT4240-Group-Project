package com.dragons.game.view.modelViews;

import com.dragons.game.model.IModel;
import com.dragons.game.model.blocks.DestructibleBlock;
import com.dragons.game.model.blocks.IBlock;
import com.dragons.game.model.blocks.WallBlock;
import com.dragons.game.model.bombs.IBomb;
import com.dragons.game.model.bombs.NormalBomb;
import com.dragons.game.model.bombs.fires.IFire;
import com.dragons.game.model.bombs.fires.NormalFire;
import com.dragons.game.model.players.IPlayer;
import com.dragons.game.model.players.NormalPlayer;
import com.dragons.game.view.modelViews.blocks.DestructibleBlockView;
import com.dragons.game.view.modelViews.bombs.NormalBombView;
import com.dragons.game.view.modelViews.bombs.NormalFireView;
import com.dragons.game.view.modelViews.players.NormalPlayerView;


import net.dermetfan.gdx.assets.AnnotationAssetManager;


public class ModelViewFactory {

    private static final ModelViewFactory INSTANCE = new ModelViewFactory();

    private ModelViewFactory() {
    }

    public static ModelViewFactory getInstance() {
        return INSTANCE;
    }

    public IModelView createModelView(IModel model, AnnotationAssetManager assetManager){
        if      (model instanceof IBlock)   return createBlockView(model, assetManager);
        //else if (model instanceof IPowerUp)    return createPowerUpView(model, assetManager);
        else if (model instanceof IPlayer)  return createPlayerView(model, assetManager);
        else if (model instanceof IBomb)    return createBombView(model, assetManager);
        else if (model instanceof IFire)    return createFireView(model, assetManager);

        else throw new IllegalArgumentException("Wrong ModelInstance");
    }

    private IModelView createBlockView(IModel model, AnnotationAssetManager assetManager){
        if      (model instanceof DestructibleBlock)    return new DestructibleBlockView(model, assetManager);
        else if (model instanceof WallBlock)            return null;

        else throw new IllegalArgumentException("Wrong BlockInstance");

    }


    private IModelView createPlayerView(IModel model, AnnotationAssetManager assetManager){
        if (model instanceof NormalPlayer) return new NormalPlayerView(model, assetManager);

        else throw new IllegalArgumentException("Wrong PlayerInstance");

    }

    private IModelView createBombView(IModel model, AnnotationAssetManager assetManager){
        if (model instanceof NormalBomb) return new NormalBombView(model, assetManager);

        else throw new IllegalArgumentException("Wrong BombInstance");

    }

    private IModelView createFireView(IModel model, AnnotationAssetManager assetManager){
        if (model instanceof NormalFire) return new NormalFireView(model, assetManager);

        else throw new IllegalArgumentException("Wrong FireInstance");

    }
}
