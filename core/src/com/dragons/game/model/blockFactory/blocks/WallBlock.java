package com.dragons.game.model.blockFactory.blocks;

import com.dragons.game.view.modelViews.IModelObserver;

public class WallBlock extends Block{

    public WallBlock(IModelObserver observer) {
        super(observer);
    }

    @Override
    void whenHitByBomb() {

    }
}
