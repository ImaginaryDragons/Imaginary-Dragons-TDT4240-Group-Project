package com.dragons.game.model.powerUps;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.dragons.game.model.IModel;
import com.dragons.game.model.Model;
import com.dragons.game.model.player.Player;

import static com.dragons.game.utilities.Constants.PPM;

public class IncreaseRange extends Model implements IPowerUp {

    private static final int increaseAmount = 1;

    public IncreaseRange(Vector2 position, PowerUpType type, float width, float height) {
        super(position, type, width, height);
        final PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2 / PPM, height / 2 / PPM);
        super.setShape(shape);
    }


    @Override
    public void handlePickedUp(IModel model) {
        if (model instanceof Player) ((Player) model).increaseBombRange(increaseAmount);
        // for debugging
        else throw new IllegalArgumentException("Model is not of type Player");

        super.destroyModel();
    }
}
