package com.dragons.game.view.modelViews.modelViewFactories;

import com.dragons.game.model.IModel;
import com.dragons.game.model.players.NormalPlayer;
import com.dragons.game.view.IView;
import com.dragons.game.view.modelViews.players.NormalPlayerView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

public final class PlayerViewFactory implements IModelViewFactory{

    private static final IModelViewFactory INSTANCE = new PlayerViewFactory();

    private PlayerViewFactory() {
    }

    protected static IModelViewFactory getInstance(){
        return INSTANCE;
    }
    @Override
    public IView createModelView(IModel model, AnnotationAssetManager assetManager) {
        // Add different views if needed here
        if (model instanceof NormalPlayer) return new NormalPlayerView(model, assetManager);

        else throw new IllegalArgumentException("The view for this model has not been put in its factory");

    }
}
