package com.dragons.game.model.modelFactories;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.model.bombs.fires.NormalFire;

import org.jetbrains.annotations.NotNull;


/**
 * To extend the factory with a new fire, create the new fire class, add the correct BombType
 * To the Fire class, and put it in the case statement below
 */

public final class FireFactory {
    private static final FireFactory INSTANCE = new FireFactory();

    public static FireFactory getInstance() {
        return INSTANCE;
    }

    private FireFactory() {
    }

    /**
     * Returns a Fire object of IModel type
     * @param position  Position where the model should be created
     * @param type Type of Fire that should be created
     * @param width Width of the object
     * @param height Height of the object
     * @return Fire if the type is correct
     * @throws IllegalArgumentException if type doesn't exist
     *
     */
    // The factory method
    public IModel createFire(Vector2 position, @NotNull BombType type, float width, float height){
        switch (type){
            case NORMALBOMB:
            case NEW_TEST_BOMB:
                return new NormalFire(position, width, height);
            default:
                throw new IllegalArgumentException("The model enum has not been put in its factory");
        }
    }
}
