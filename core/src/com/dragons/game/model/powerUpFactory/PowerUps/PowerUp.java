package com.dragons.game.model.powerUpFactory.PowerUps;


import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.Subject;

public abstract class PowerUp extends Subject {

    // TODO: add/modify fields

    public PowerUp() {
        super();
    }

    public abstract void setPosition(Vector2 pos);
    public abstract Vector2 getPosition();
    public abstract void setShape(Shape2D shape);
    public abstract Shape2D getShape();

    public abstract void whenPickedUp();

}
