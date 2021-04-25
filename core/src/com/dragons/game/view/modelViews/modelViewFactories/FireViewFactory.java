package com.dragons.game.view.modelViews.modelViewFactories;

import com.dragons.game.model.IModel;
import com.dragons.game.model.bombs.fires.NormalFire;
import com.dragons.game.view.modelViews.IModelView;
import com.dragons.game.view.modelViews.bombs.fires.NormalFireView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

/**
 * To extend the factory with a new fire, create the new View class
 * And put it in the case statement below
 */
public final class FireViewFactory implements IModelViewFactory{

    private static final IModelViewFactory INSTANCE = new FireViewFactory();

    private FireViewFactory() {
    }

    protected static IModelViewFactory getInstance(){
        return INSTANCE;
    }

    @Override
    public IModelView createModelView(IModel model, AnnotationAssetManager assetManager){
        // Add different views if needed here
        if (model instanceof NormalFire) return new NormalFireView(model, assetManager);

        else throw new IllegalArgumentException("The view for this model has not been put in its factory");
    }
}
