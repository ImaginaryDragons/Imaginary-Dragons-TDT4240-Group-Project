package com.dragons.game.model;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Shape;

public interface IModel {
    void setPosition(Vector2 position);
    Vector2 getPosition();
    IModelType getType();
    float getWidth();
    float getHeight();
    boolean isStatic();
    boolean isSensor();

    /**
     * checks if the model should be destroyed
     */
    boolean isDisposed();
}
