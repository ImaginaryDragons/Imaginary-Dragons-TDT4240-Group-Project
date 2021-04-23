package com.dragons.game.view.modelViews.modelViewFactories;

import com.dragons.game.model.IModel;
import com.dragons.game.view.IView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

public interface IModelViewFactory {
    IView createModelView(IModel model, AnnotationAssetManager assetManager);

}
