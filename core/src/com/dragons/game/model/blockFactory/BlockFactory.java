package com.dragons.game.model.blockFactory;

import com.dragons.game.model.blockFactory.blocks.Block;
import com.dragons.game.model.blockFactory.blocks.DestructibleBlock;
import com.dragons.game.model.blockFactory.blocks.WallBlock;


public abstract class BlockFactory {

    /**
     * Returns a block object
     * @param type Block enum
     * @return Block if the type is correct
     * @throws IllegalArgumentException if type doesnt exist
     */
    public static Block createBlock(BlockType type){
        switch (type){
            case DESTRUCTIBLE:
                return new DestructibleBlock();
            case WALL:
                return new WallBlock();
            default:
                throw new IllegalArgumentException();
        }

    }
}
