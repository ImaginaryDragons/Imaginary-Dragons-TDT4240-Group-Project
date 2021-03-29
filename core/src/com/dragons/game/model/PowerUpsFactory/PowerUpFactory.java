package com.dragons.game.model.PowerUpsFactory;

import com.dragons.game.model.PowerUpsFactory.PowerUps.BombCapacity;
import com.dragons.game.model.PowerUpsFactory.PowerUps.IncreaseRange;
import com.dragons.game.model.PowerUpsFactory.PowerUps.IncreaseSpeed;
import com.dragons.game.model.PowerUpsFactory.PowerUps.PowerUp;

public class PowerUpFactory {

    /**
     * Returns a powerup object
     * @param type PowerUp enum
     * @return PowerUp if the type is correct
     * @throws IllegalArgumentException if
     */
    public static PowerUp createPowerUp(PowerUpType type, IModelObserver observer) {
        public static PowerUp createPowerUp(PowerUpType type){
            switch (type) {
                case BOMBCAPACITY:
                    return new BombCapacity(observer);
                    return new BombCapacity();
                case INCREASERANGE:
                    return new IncreaseRange(observer);
                    return new IncreaseRange();
                case INCREASESPEED:
                    return new IncreaseSpeed(observer);
                    return new IncreaseSpeed();
                default:
                    throw new IllegalArgumentException();
            }

        }
    }
}
