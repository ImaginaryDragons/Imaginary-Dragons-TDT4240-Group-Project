package com.dragons.game.view.modelViews.modelViewFactories;

import com.dragons.game.model.IModel;
import com.dragons.game.view.modelViews.IModelView;
import com.dragons.game.view.modelViews.bombs.BombView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

public final class BombViewFactory implements IModelViewFactory {

    private static final IModelViewFactory INSTANCE = new BombViewFactory();

    private BombViewFactory() {
    }

    protected static IModelViewFactory getInstance(){
        return INSTANCE;
    }

    @Override
    public IModelView createModelView(IModel model, AnnotationAssetManager assetManager){
        return new BombView(model, assetManager);

    }
}
