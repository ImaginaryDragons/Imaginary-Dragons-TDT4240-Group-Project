package com.dragons.game.model.modelFactories;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.blocks.*;

import org.jetbrains.annotations.NotNull;


public final class BlockFactory{

    private static final BlockFactory INSTANCE = new BlockFactory();

    public static BlockFactory getInstance() {
        return INSTANCE;
    }

    private BlockFactory() {
    }

    /**
     * Returns a block object
     * @param type Block enum, Vector 2 position, width and height of block.
     * @return Block if the type is correct
     * @throws IllegalArgumentException if type doesn't exist
     *
     */
    public IModel createBlock(Vector2 position, @NotNull BlockType type, float width, float height){
        switch (type){
            case DESTRUCTIBLEBlOCK:
                return new DestructibleBlock(position, width, height);
            case WALLBLOCK:
                return new WallBlock(position, type, width, height);
            default:
                throw new IllegalArgumentException();
        }
    }



}
