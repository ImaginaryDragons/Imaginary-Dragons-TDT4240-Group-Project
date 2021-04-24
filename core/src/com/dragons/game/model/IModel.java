package com.dragons.game.model;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Shape;

public interface IModel {
    Vector2 getPosition();
    void setPosition(float x, float y);
    float getWidth();
    float getHeight();
    boolean isStatic();
    boolean isSensor();
    void update(float timestep);

    /**
     * checks if the model should be destroyed
     */
    boolean isDisposed();
    void dispose();
}
