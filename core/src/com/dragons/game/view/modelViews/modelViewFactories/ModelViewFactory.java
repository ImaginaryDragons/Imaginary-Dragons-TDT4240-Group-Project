package com.dragons.game.view.modelViews.modelViewFactories;

import com.dragons.game.model.IModel;
import com.dragons.game.model.blocks.IBlock;
import com.dragons.game.model.bombs.IBomb;
import com.dragons.game.model.bombs.fires.IFire;
import com.dragons.game.model.players.IPlayer;
import com.dragons.game.model.powerUps.IPowerUp;
import com.dragons.game.view.modelViews.IModelView;


import net.dermetfan.gdx.assets.AnnotationAssetManager;


public class ModelViewFactory {

    private static final IModelViewFactory blockViewFactory = BlockViewFactory.getInstance();
    private static final IModelViewFactory powerUpViewFactory = PowerUpViewFactory.getInstance();
    private static final IModelViewFactory bombViewFactory = BombViewFactory.getInstance();
    private static final IModelViewFactory fireViewFactory = FireViewFactory.getInstance();
    private static final IModelViewFactory playerViewFactory = PlayerViewFactory.getInstance();

    private static final ModelViewFactory INSTANCE = new ModelViewFactory();


    private ModelViewFactory() {
    }

    public static ModelViewFactory getInstance() {
        return INSTANCE;
    }

    public IModelView createModelView(IModel model, AnnotationAssetManager assetManager){
        if      (model instanceof IBlock)   return blockViewFactory.createModelView(    model, assetManager);
        else if (model instanceof IPowerUp) return powerUpViewFactory.createModelView(  model, assetManager);
        else if (model instanceof IPlayer)  return playerViewFactory.createModelView(   model, assetManager);
        else if (model instanceof IBomb)    return bombViewFactory.createModelView(     model, assetManager);
        else if (model instanceof IFire)    return fireViewFactory.createModelView(     model, assetManager);

        else throw new IllegalArgumentException("Model instance doesn't exist");
    }






}
