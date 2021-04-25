package com.dragons.game.model.modelFactories;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.players.NormalPlayer;
import com.dragons.game.model.players.playerEnums.PlayerType;

import org.jetbrains.annotations.NotNull;


/**
 * To extend the factory with a new player, create the new player class, add its corresponding
 * Enum to PlayerType and put it in the case statement below
 */

public final class PlayerFactory {
    private static final PlayerFactory INSTANCE = new PlayerFactory();

    public static PlayerFactory getInstance() {
        return INSTANCE;
    }

    private PlayerFactory() {
    }

    /**
     * Returns a  Player object of IModel type
     * @param position  Position where the model should be created
     * @param type Type of Player that should be created
     * @param color Color of the player
     * @param width Width of the object
     * @param height Height of the object
     * @return Player if the type is correct
     * @throws IllegalArgumentException if type doesn't exist
     *
     */
    // The factory method
    public IModel createPlayer(int ID, Vector2 position, @NotNull PlayerType type, Color color, float width, float height){
        switch (type){
            case NORMALPLAYER:
                return new NormalPlayer(ID, position, color, width, height);
            /*case NEWPLAYER:
            *    return new NewPlayer(ID, position, color, width, height)*/
            default:
                throw new IllegalArgumentException("The model enum has not been put in its factory");
        }
    }
}
