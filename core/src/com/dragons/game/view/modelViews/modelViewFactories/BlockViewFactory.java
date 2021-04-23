package com.dragons.game.view.modelViews.modelViewFactories;

import com.dragons.game.model.IModel;
import com.dragons.game.model.blocks.DestructibleBlock;
import com.dragons.game.model.blocks.IBlock;
import com.dragons.game.model.blocks.WallBlock;
import com.dragons.game.view.modelViews.IModelView;
import com.dragons.game.view.modelViews.blocks.BlockView;

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
        // Add different views if needed here
        if      (model instanceof WallBlock) return null; // Wallblock doesnt have a view!
        else if (model instanceof IBlock)    return new BlockView(model, assetManager);

        else throw new IllegalArgumentException("Wrong BlockInstance");

    }
}
