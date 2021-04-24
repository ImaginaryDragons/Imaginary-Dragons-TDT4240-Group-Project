package com.dragons.game.model.powerUps;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.Model;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.model.players.IPlayer;


public class BombCapacity extends Model implements IPowerUp {

    private static final boolean isStatic = true;
    private static final boolean isSensor = true;

    // TODO: take from constants?
    private static final int increaseAmount = 1;

    // The type of bomb this PowerUp should add to player inventory;
    private static final BombType bombType = BombType.NORMALBOMB;

    public BombCapacity(Vector2 position, float width, float height) {
        super(position, width, height, isStatic, isSensor);
    }


    @Override
    public void handlePickedUp(IModel model) {
        if (model instanceof IPlayer) ((IPlayer) model).increaseBombCapacity(increaseAmount, bombType);
            // for debugging
        else throw new IllegalArgumentException("Model is not of type IPlayer");

        super.dispose();
    }
}
