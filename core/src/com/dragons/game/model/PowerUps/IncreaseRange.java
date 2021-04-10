package com.dragons.game.model.PowerUps;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.dragons.game.model.Model;

import static com.dragons.game.utilities.Constants.PPM;

public class IncreaseRange extends Model implements IPowerUp {

    private static final boolean isStatic = true;
    private static final boolean isSensor = true;

    public IncreaseRange(Vector2 position, PowerUpType type, float width, float height) {
        super(position, type, width, height, isStatic, isSensor);
        final PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2 / PPM, height / 2 / PPM);
        super.setShape(shape);
    }


    @Override
    public void handlePickedUp() {
        //TODO: Implement method
    }
}
