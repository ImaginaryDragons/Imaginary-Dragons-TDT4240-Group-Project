package com.dragons.game.model.factories;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.PowerUps.PowerUpType;
import com.dragons.game.model.PowerUps.BombCapacity;
import com.dragons.game.model.PowerUps.IncreaseRange;
import com.dragons.game.model.PowerUps.IncreaseSpeed;

import org.jetbrains.annotations.NotNull;


/**
 * To extend the factory with a new powerup, create the new powerup class, add its corresponding
 * Enum to PowerUpType and put it in the case statement below
 */

public final class PowerUpFactory {

    private static PowerUpFactory INSTANCE = new PowerUpFactory();

    public static PowerUpFactory getInstance() {
        return INSTANCE;
    }

    private PowerUpFactory() {
    }

    /**
     * Returns a powerup object
     * @param type PowerUp enum
     * @return PowerUp if the type is correct
     * @throws IllegalArgumentException if type doesn't exist
     */

        @NotNull
        public IModel createPowerUp(Vector2 position, @NotNull PowerUpType type, float width, float height){
            switch (type) {
                case BOMBCAPACITY:
                    return new BombCapacity(position, type, width, height);
                case INCREASERANGE:
                    return new IncreaseRange(position, type, width, height);
                case INCREASESPEED:
                    return new IncreaseSpeed(position, type, width, height);
                default:
                    throw new IllegalArgumentException();
            }
    }
}
