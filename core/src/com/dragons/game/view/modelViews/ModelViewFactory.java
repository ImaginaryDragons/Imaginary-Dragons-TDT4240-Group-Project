package com.dragons.game.view.modelViews;

import com.dragons.game.model.IModel;
import com.dragons.game.model.blocks.BlockType;
import com.dragons.game.model.blocks.IBlock;
import com.dragons.game.model.bomb.BombType;
import com.dragons.game.model.bomb.FireType;
import com.dragons.game.model.bomb.IBomb;
import com.dragons.game.model.bomb.IFire;
import com.dragons.game.model.player.IPlayer;
import com.dragons.game.model.player.Player;
import com.dragons.game.model.player.PlayerType;
import com.dragons.game.view.modelViews.blocks.DestructibleBlockView;
import com.dragons.game.view.modelViews.bombs.BombView;
import com.dragons.game.view.modelViews.bombs.FireView;
import com.dragons.game.view.modelViews.players.PlayerView;


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
                return new DestructibleBlockView(model.getPosition(), model.getWidth(), model.getHeight(), assetManager);

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
                return new PlayerView(model.getPosition(), model.getWidth(), model.getHeight(),
                                        player.getColor(), assetManager);
            default:
                throw new IllegalArgumentException("Wrong PlayerType");
        }
    }

    private IModelView createBombView(IModel model, AnnotationAssetManager assetManager){
        BombType type = (BombType) model.getType();
        switch (type){
            case NORMALBOMB:
                return new BombView(model.getPosition(), model.getWidth(), model.getHeight(), assetManager);
            default:
                throw new IllegalArgumentException("Wrong PlayerType");
        }
    }

    private IModelView createFireView(IModel model, AnnotationAssetManager assetManager){
        FireType type = (FireType) model.getType();
        switch (type){
            case NORMALFIRE:
                return new FireView(model.getPosition(), model.getWidth(), model.getHeight(), assetManager);
            default:
                throw new IllegalArgumentException("Wrong PlayerType");
        }
    }
}
