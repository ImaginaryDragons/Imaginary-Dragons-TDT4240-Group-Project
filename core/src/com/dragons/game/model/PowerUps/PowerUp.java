package com.dragons.game.model.PowerUps;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.dragons.game.model.Object;


public abstract class PowerUp extends Object {

    //TODO: Put these fields in each subclass and make this class an interface?
    private static final boolean isStatic = true;
    private static final boolean isSensor = true;
    private static final Shape.Type shapeType = Shape.Type.Polygon;

    protected abstract void handlePickedUp();

    public PowerUp(Vector2 position, PowerUpType type, float width, float height) {
        super(position, type, width, height, isStatic, isSensor, shapeType);

    }


}
