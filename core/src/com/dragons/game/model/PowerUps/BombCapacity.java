package com.dragons.game.model.PowerUps;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.dragons.game.model.Object;

import static com.dragons.game.utilities.Constants.PPM;

public class BombCapacity extends Object implements IPowerUp {

    private static final boolean isStatic = false;
    private static final boolean isSensor = false;


    public BombCapacity(Vector2 position, PowerUpType type, float width, float height) {
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
