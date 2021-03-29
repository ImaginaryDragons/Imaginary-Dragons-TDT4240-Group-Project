package com.dragons.game.model.blockFactory;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.blockFactory.blocks.Block;
import com.dragons.game.model.blockFactory.blocks.DestructibleBlock;
import com.dragons.game.model.blockFactory.blocks.WallBlock;
import com.dragons.game.view.modelViews.IModelObserver;

import java.util.Vector;


public abstract class BlockFactory {

    /**
     * Returns a block object
     * @param type Block enum, Vector 2 position, width and height of block.
     * @return Block if the type is correct
     * @throws IllegalArgumentException if type doesnt exist
     *
     * @author Jakob Eikeland and Elise Bø
     */
    public static Block createBlock(BlockType type, Vector2 pos, float width, float height){
        switch (type){
            case DESTRUCTIBLE:
                return new DestructibleBlock(pos, width, height);
            case WALL:
                return new WallBlock(pos, width, height);
            default:
                throw new IllegalArgumentException();
        }
    }
}
