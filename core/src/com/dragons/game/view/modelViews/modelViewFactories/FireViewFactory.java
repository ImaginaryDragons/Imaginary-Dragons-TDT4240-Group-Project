package com.dragons.game.view.modelViews.modelViewFactories;

import com.dragons.game.model.IModel;
import com.dragons.game.model.bombs.fires.IFire;
import com.dragons.game.model.bombs.fires.NormalFire;
import com.dragons.game.view.modelViews.IModelView;
import com.dragons.game.view.modelViews.bombs.FireView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

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
        return new FireView(model, assetManager);
    }
}
