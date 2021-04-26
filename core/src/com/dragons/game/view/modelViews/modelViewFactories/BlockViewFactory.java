package com.dragons.game.view.modelViews.modelViewFactories;

import com.dragons.game.model.IModel;
import com.dragons.game.model.blocks.IBlock;
import com.dragons.game.model.blocks.WallBlock;
import com.dragons.game.view.modelViews.IModelView;
import com.dragons.game.view.modelViews.blocks.DestructibleBlockView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

/**
 * To extend the factory with a new block, create the new View class
 * And put it in the case statement below
 */
public final class BlockViewFactory implements IModelViewFactory {

    private static final IModelViewFactory INSTANCE = new BlockViewFactory();

    private BlockViewFactory() {
    }

    protected static IModelViewFactory getInstance(){
        return INSTANCE;
    }

    @Override
    public IModelView createModelView(IModel model, AnnotationAssetManager assetManager){
        // Add different views if needed here
        if      (model instanceof WallBlock) return null; // Wallblock doesnt have a view!
        else if (model instanceof IBlock)    return new DestructibleBlockView(model, assetManager);

        else throw new IllegalArgumentException("The view for this Model has not been put in its factory");

    }
}
