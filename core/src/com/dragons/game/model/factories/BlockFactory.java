package com.dragons.game.model.factories;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.blocks.*;


public abstract class BlockFactory {

    /**
     * Returns a block object
     * @param type Block enum, Vector 2 position, width and height of block.
     * @return Block if the type is correct
     * @throws IllegalArgumentException if type doesnt exist
     *
     * @author Jakob Eikeland and Elise Bø
     */
    public static Block createBlock(Vector2 position, BlockType type, float width, float height){
        switch (type){
            case DESTRUCTIBLE:
                return new DestructibleBlock(position, type, width, height);
            case WALL:
                return new WallBlock(position, type, width, height);
            default:
                throw new IllegalArgumentException();
        }
    }
}
