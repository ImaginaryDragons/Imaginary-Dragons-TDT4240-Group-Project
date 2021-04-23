package com.dragons.game.model.modelFactories;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.bombs.NewBombTemplate;
import com.dragons.game.model.bombs.NormalBomb;
import com.dragons.game.model.bombs.BombType;

import org.jetbrains.annotations.NotNull;

public final class BombFactory {

    private static final BombFactory INSTANCE = new BombFactory();

    public static BombFactory getInstance() {
        return INSTANCE;
    }

    private BombFactory() {
    }

    /**
     * Returns a Bomb object
     * @param type Bomb enum, Vector 2 position, width and height of Bomb.
     * @return NormalBomb if the type is correct
     * @throws IllegalArgumentException if type doesn't exist
     *
     */
    public IModel createBomb(Vector2 position, @NotNull BombType type, float width, float height, int extraRange){
        switch (type){
            case NORMALBOMB:
                return new NormalBomb(position, width, height, extraRange, type);
            case NEW_TEST_BOMB:
                return new NewBombTemplate(position, width, height, extraRange, type);
            default:
                throw new IllegalArgumentException("Wrong BombType");
        }
    }
    
}
