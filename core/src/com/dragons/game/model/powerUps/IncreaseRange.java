package com.dragons.game.model.powerUps;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.Model;
import com.dragons.game.model.players.IPlayer;


public class IncreaseRange extends Model implements IPowerUp {

    // TODO: take from constants?
    private static final int increaseAmount = 1;
    private static final boolean isStatic = true;
    private static final boolean isSensor = true;

    public IncreaseRange(Vector2 position, float width, float height) {
        super(position, width, height, isStatic, isSensor);
    }


    @Override
    public void handlePickedUp(IModel model) {
        if (model instanceof IPlayer) ((IPlayer) model).increaseBombRange(increaseAmount);
        // for debugging
        else throw new IllegalArgumentException("Model is not of type NormalPlayer");

        super.dispose();
    }
}
