package com.dragons.game.view.modelViews.modelViewFactories;

import com.dragons.game.model.IModel;
import com.dragons.game.model.blocks.DestructibleBlock;
import com.dragons.game.model.blocks.WallBlock;
import com.dragons.game.view.modelViews.IModelView;
import com.dragons.game.view.modelViews.blocks.DestructibleBlockView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

public final class BlockViewFactory implements IModelViewFactory {

    private static final IModelViewFactory INSTANCE = new BlockViewFactory();

    private BlockViewFactory() {
    }

    protected static IModelViewFactory getInstance(){
        return INSTANCE;
    }

    @Override
    public IModelView createModelView(IModel model, AnnotationAssetManager assetManager){
        if      (model instanceof DestructibleBlock)    return new DestructibleBlockView(model, assetManager);
        else if (model instanceof WallBlock)            return null;

        else throw new IllegalArgumentException("Wrong BlockInstance");

    }
}
