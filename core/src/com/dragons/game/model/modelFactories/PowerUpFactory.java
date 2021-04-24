package com.dragons.game.model.modelFactories;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.powerUps.NewPowerUpTemplate;
import com.dragons.game.model.powerUps.PowerUpType;
import com.dragons.game.model.powerUps.BombCapacity;
import com.dragons.game.model.powerUps.IncreaseRange;
import com.dragons.game.model.powerUps.IncreaseSpeed;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;


/**
 * To extend the factory with a new powerup, create the new powerup class, add its corresponding
 * Enum to PowerUpType and put it in the case statement below
 */

public final class PowerUpFactory {

    private static final PowerUpFactory INSTANCE = new PowerUpFactory();
    private final PowerUpType[] powerUps=PowerUpType.values();
    private final Random random = new Random();

    public static PowerUpFactory getInstance() {
        return INSTANCE;
    }

    private PowerUpFactory() {
    }

    /**
     * Returns a PowerUp object of IModel type
     * @param position Position where the model should be created
     * @param type Type of PowerUp that should be created
     * @param width Width of the object
     * @param height Height of the object
     * @return PowerUp if the type is correct
     * @throws IllegalArgumentException if type doesn't exist
     *
     */
    // The factory method
    public IModel createPowerUp(Vector2 position, @NotNull PowerUpType type, float width, float height) {
        if (type == PowerUpType.RANDOM){
            type = powerUps[random.nextInt(powerUps.length-1)];
        }
        switch (type) {
            case BOMBCAPACITY:
                return new BombCapacity(position, width, height);
            case INCREASERANGE:
                return new IncreaseRange(position, width, height);
            case INCREASESPEED:
                return new IncreaseSpeed(position, width, height);
            /*case NEWPOWERUPTEMPLATE:
                return new NewPowerUpTemplate(position, width, height);*/
            default:
                throw new IllegalArgumentException("The model enum has not been put in its factory");
        }
    }
}
