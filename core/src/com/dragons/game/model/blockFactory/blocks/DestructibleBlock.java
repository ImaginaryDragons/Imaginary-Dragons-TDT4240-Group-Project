package com.dragons.game.model.blockFactory.blocks;

import com.dragons.game.view.modelViews.IModelObserver;

public class DestructibleBlock extends Block{

    public DestructibleBlock(IModelObserver observer) {
        super(observer);
        // texture = new Texture(source)
    }


    @Override
    public void handleHitByBomb() {
        // TODO: Implement method
    }
}
