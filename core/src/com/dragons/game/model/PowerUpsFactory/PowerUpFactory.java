package com.dragons.game.model.PowerUpsFactory;

import com.dragons.game.model.PowerUpsFactory.PowerUps.BombCapacity;
import com.dragons.game.model.PowerUpsFactory.PowerUps.IncreaseRange;
import com.dragons.game.model.PowerUpsFactory.PowerUps.IncreaseSpeed;
import com.dragons.game.model.PowerUpsFactory.PowerUps.PowerUp;

public class PowerUpFactory {



    public static PowerUp createPowerUp(PowerUpType type){

        switch (type){
            case BOMBCAPACITY:
                return new BombCapacity();
            case INCREASERANGE:
                return new IncreaseRange();
            case INCREASESPEED:
                return new IncreaseSpeed();
            default:
                return null;
        }

    }

}
