package com.dragons.game.model.powerUpFactory;

import com.dragons.game.model.powerUpFactory.PowerUps.BombCapacity;
import com.dragons.game.model.powerUpFactory.PowerUps.IncreaseRange;
import com.dragons.game.model.powerUpFactory.PowerUps.IncreaseSpeed;
import com.dragons.game.model.powerUpFactory.PowerUps.PowerUp;
import com.dragons.game.view.modelViews.IModelObserver;

/**
 * To extend the factory with a new powerup, create the new powerup class, add its corresponding
 * Enum to PowerUpType and put it in the case statement below
 */

public class PowerUpFactory {

    /**
     * Returns a powerup object
     * @param type PowerUp enum
     * @return PowerUp if the type is correct
     * @throws IllegalArgumentException if
     */
    public static PowerUp createPowerUp(PowerUpType type){
        switch (type){
            case BOMBCAPACITY:
                return new BombCapacity();
            case INCREASERANGE:
                return new IncreaseRange();
            case INCREASESPEED:
                return new IncreaseSpeed();
            default:
                throw new IllegalArgumentException();
        }

    }

}
