package com.dragons.game.view.modelViews.modelViewFactories;

import com.dragons.game.model.IModel;
import com.dragons.game.view.modelViews.IModelView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

public interface IModelViewFactory {
    IModelView createModelView(IModel model, AnnotationAssetManager assetManager);

}
