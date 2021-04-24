package com.dragons.game.model.modelFactories;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.model.bombs.fires.NormalFire;

import org.jetbrains.annotations.NotNull;

public final class FireFactory {
    private static final FireFactory INSTANCE = new FireFactory();

    public static FireFactory getInstance() {
        return INSTANCE;
    }

    private FireFactory() {
    }

    /**
     * Returns IView NormalFire object
     * @param type NormalFire enum, Vector 2 position, width and height of NormalFire.
     * @return NormalFire object if the type is correct
     * @throws IllegalArgumentException if type doesn't exist
     *
     */
    public IModel createFire(Vector2 position, @NotNull BombType type, float width, float height){
        switch (type){
            case NORMALBOMB:
            case NEW_TEST_BOMB:
                return new NormalFire(position, width, height);
            default:
                throw new IllegalArgumentException("Wrong BombType");
        }
    }
}
