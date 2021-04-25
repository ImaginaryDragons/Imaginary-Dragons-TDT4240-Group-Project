package com.dragons.game.model.modelFactories;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.blocks.*;

import org.jetbrains.annotations.NotNull;

/**
 * To extend the factory with a new block, create the new block class, add its corresponding
 * Enum to BlockType and put it in the case statement below
 */
public final class BlockFactory{

    // Singleton pattern
    private static final BlockFactory INSTANCE = new BlockFactory();

    public static BlockFactory getInstance() {
        return INSTANCE;
    }

    private BlockFactory() {
    }

    /**
     * Returns a  Block object of IModel type
     * @param position  Position where the model should be created
     * @param type Type of Block that should be created
     * @param width Width of the object
     * @param height Height of the object
     * @return Block if the type is correct
     * @throws IllegalArgumentException if type doesn't exist
     *
     */
    // The factory method
    public IModel createBlock(Vector2 position, @NotNull BlockType type, float width, float height){
        switch (type){
            case DESTRUCTIBLEBlOCK:
                return new DestructibleBlock(position, width, height);
            case WALLBLOCK:
                return new WallBlock(position, width, height);
            default:
                throw new IllegalArgumentException("The model enum has not been put in its factory");
        }
    }



}
