package com.dragons.game.model;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Shape;

public interface IObject {
    void setPosition(Vector2 position);
    Vector2 getPosition();
    Shape getShape();
    IModelType getType();
    boolean isStatic();
    boolean isSensor();


}
