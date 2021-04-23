package com.dragons.game.model.modelFactories;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.players.NormalPlayer;
import com.dragons.game.model.players.playerEnums.PlayerType;

import org.jetbrains.annotations.NotNull;

public final class PlayerFactory {
    private static final PlayerFactory INSTANCE = new PlayerFactory();

    public static PlayerFactory getInstance() {
        return INSTANCE;
    }

    private PlayerFactory() {
    }

    /**
     * Returns a NormalPlayer object
     * @param type NormalPlayer enum, Vector 2 position, width and height of NormalPlayer.
     * @return NormalPlayer if the type is correct
     * @throws IllegalArgumentException if type doesn't exist
     *
     */
    public IModel createPlayer(int ID, Vector2 position, @NotNull PlayerType type, Color color, float width, float height){
        switch (type){
            case NORMALPLAYER:
                return new NormalPlayer(ID, position, color, width, height);
            default:
                throw new IllegalArgumentException();
        }
    }
}
