package com.dragons.game.view.modelViews.modelViewFactories;

import com.dragons.game.model.IModel;
import com.dragons.game.view.modelViews.IModelView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

public final class PowerUpViewFactory implements IModelViewFactory {

    private static final PowerUpViewFactory INSTANCE = new PowerUpViewFactory();

    private PowerUpViewFactory() {
    }

    protected static IModelViewFactory getInstance(){
        return INSTANCE;
    }


    @Override
    public IModelView createModelView(IModel model, AnnotationAssetManager assetManager) {
        return null;
        // TODO: Create PowerUpViewClasses
    }
}
