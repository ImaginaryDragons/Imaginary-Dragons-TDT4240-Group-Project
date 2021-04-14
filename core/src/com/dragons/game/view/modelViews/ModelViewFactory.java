package com.dragons.game.view.modelViews;

import com.dragons.game.model.IModel;
import com.dragons.game.model.blocks.BlockType;
import com.dragons.game.model.blocks.IBlock;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.model.bombs.IBomb;
import com.dragons.game.model.bombs.fires.IFire;
import com.dragons.game.model.players.IPlayer;
import com.dragons.game.model.players.PlayerType;
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

        else throw new IllegalArgumentException("Wrong ModelType");
    }

    private IModelView createBlockView(IModel model, AnnotationAssetManager assetManager){
        BlockType type = (BlockType) model.getType();
        switch (type){
            case DESTRUCTIBLEBlOCK:
                return new DestructibleBlockView(model, assetManager);

            case WALLBLOCK:
                return null;
            default:
                throw new IllegalArgumentException("Wrong Blocktype");
        }
    }


    private IModelView createPlayerView(IModel model, AnnotationAssetManager assetManager){
        PlayerType type = (PlayerType) model.getType();
        IPlayer player = (IPlayer) model;
        switch (type){
            case NORMALPLAYER:
                return new NormalPlayerView(model, assetManager);
            default:
                throw new IllegalArgumentException("Wrong PlayerType");
        }
    }

    private IModelView createBombView(IModel model, AnnotationAssetManager assetManager){
        BombType type = (BombType) model.getType();
        switch (type){
            case NORMALBOMB:
                return new NormalBombView(model, assetManager);
            default:
                throw new IllegalArgumentException("Wrong PlayerType");
        }
    }

    private IModelView createFireView(IModel model, AnnotationAssetManager assetManager){
        BombType type = (BombType) model.getType();
        switch (type){
            case NORMALBOMB:
                return new NormalFireView(model, assetManager);
            default:
                throw new IllegalArgumentException("Wrong PlayerType");
        }
    }
}
