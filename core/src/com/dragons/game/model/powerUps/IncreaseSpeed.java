package com.dragons.game.model.powerUps;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.Model;
import com.dragons.game.model.player.Player;


public class IncreaseSpeed extends Model implements IPowerUp {

    private static final int increaseAmount = 1;

    public IncreaseSpeed(Vector2 position, PowerUpType type, float width, float height) {
        super(position, type, width, height);

    }


    @Override
    public void handlePickedUp(IModel model) {
        if (model instanceof Player) ((Player) model).increaseSpeed(increaseAmount);
        // For debugging
        else throw new IllegalArgumentException("Model is not of type Player");

        super.destroyModel();
    }
}
