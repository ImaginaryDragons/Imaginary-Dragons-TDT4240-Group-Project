package com.dragons.game.model.blockFactory;

import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.blockFactory.blocks.Block;
import com.dragons.game.model.blockFactory.blocks.DestructibleBlock;
import com.dragons.game.model.blockFactory.blocks.WallBlock;
import com.dragons.game.view.modelViews.IModelObserver;

/**
 * To extend the factory with a new block, create the new block class, add its corresponding
 * Enum to BlockType and put it in the case statement below
 */
public abstract class BlockFactory {

    /**
     * Returns a block object
     * @param type Block enum
     * @return Block if the type is correct
     * @throws IllegalArgumentException if type doesnt exist
     */
    public static Block createBlock(BlockType type, IModelObserver observer, World world){
        switch (type){
            // TODO: ADD TILE AS ARGUMENT IN ALL BLOCKS
            case DESTRUCTIBLE:
                return new DestructibleBlock(observer, world, type);
            case WALL:
                return new WallBlock(observer, world, type);
            default:
                throw new IllegalArgumentException();
        }

    }
}
