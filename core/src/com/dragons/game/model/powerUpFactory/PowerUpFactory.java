package com.dragons.game.model.powerUpFactory;

import com.dragons.game.model.player.Player;
import com.dragons.game.model.powerUpFactory.PowerUps.BombCapacity;
import com.dragons.game.model.powerUpFactory.PowerUps.IncreaseRange;
import com.dragons.game.model.powerUpFactory.PowerUps.IncreaseSpeed;
import com.dragons.game.model.powerUpFactory.PowerUps.PowerUp;

/**
 * To extend the factory with a new powerup, create the new powerup class, add its corresponding
 * Enum to PowerUpType and put it in the case statement below
 */

public class PowerUpFactory {
    private Player player;


    /**
     * Returns a powerup object
     * @param type PowerUp enum
     * @return PowerUp if the type is correct
     * @throws IllegalArgumentException if
     */
        public static PowerUp createPowerUp(PowerUpType type){
            switch (type) {
                case BOMBCAPACITY:
                    return new BombCapacity(player);
                case INCREASERANGE:
                    return new IncreaseRange(player);
                case INCREASESPEED:
                    return new IncreaseSpeed(player);
                default:
                    throw new IllegalArgumentException();
            }
    }
}
