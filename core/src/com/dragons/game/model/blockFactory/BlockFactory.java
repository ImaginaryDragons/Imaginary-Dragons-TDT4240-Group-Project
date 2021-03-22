package com.dragons.game.model.blockFactory;

import com.dragons.game.model.blockFactory.blocks.Block;
import com.dragons.game.model.blockFactory.blocks.DestructibleBlock;
import com.dragons.game.model.blockFactory.blocks.WallBlock;
import com.dragons.game.view.modelViews.IModelObserver;


public abstract class BlockFactory {

    /**
     * Returns a block object
     * @param type Block enum
     * @return Block if the type is correct
     * @throws IllegalArgumentException if type doesnt exist
     */
    public static Block createBlock(BlockType type, IModelObserver observer){
        switch (type){
            case DESTRUCTIBLE:
                return new DestructibleBlock(observer);
            case WALL:
                return new WallBlock(observer);
            default:
                throw new IllegalArgumentException();
        }

    }
}
