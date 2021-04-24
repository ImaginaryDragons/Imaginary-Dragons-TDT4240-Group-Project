package com.dragons.game.model.modelFactories;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.bombs.NewBombTemplate;
import com.dragons.game.model.bombs.NormalBomb;
import com.dragons.game.model.bombs.BombType;

import org.jetbrains.annotations.NotNull;

public final class BombFactory {

    // Singleton pattern
    private static final BombFactory INSTANCE = new BombFactory();

    public static BombFactory getInstance() {
        return INSTANCE;
    }

    private BombFactory() {
    }

    /**
     * Returns a  Bomb object of IModel type
     * @param position  Position where the bomb should be created
     * @param type Type of bomb of which should be created
     * @param width Width of the object
     * @param height Height of the object
     * @param extraRange The extra range given to the bomb from i.e. the player putting it in the world
     * @return Bomb if the type is correct
     * @throws IllegalArgumentException if type doesn't exist
     *
     */
    // The factory method
    public IModel createBomb(Vector2 position, @NotNull BombType type, float width, float height, int extraRange){
        switch (type){
            case NORMALBOMB:
                return new NormalBomb(position, width, height, extraRange, type);
            case NEW_TEST_BOMB:
                return new NewBombTemplate(position, width, height, extraRange, type);
            default:
                throw new IllegalArgumentException("The model enum has not been put in its factory");
        }
    }
    
}
