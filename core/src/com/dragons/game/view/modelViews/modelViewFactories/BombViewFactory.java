package com.dragons.game.view.modelViews.modelViewFactories;

import com.dragons.game.model.IModel;
import com.dragons.game.model.bombs.NewBombTemplate;
import com.dragons.game.model.bombs.NormalBomb;
import com.dragons.game.view.modelViews.IModelView;
import com.dragons.game.view.modelViews.bombs.NewBombTemplateView;
import com.dragons.game.view.modelViews.bombs.NormalBombView;

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
        // Add different views if needed here
        if      (model instanceof NormalBomb)       return new NormalBombView(model, assetManager);
        else if (model instanceof NewBombTemplate)  return new NewBombTemplateView(model, assetManager);

        else throw new IllegalArgumentException("The view for this model has not been put in its factory");

    }
}
