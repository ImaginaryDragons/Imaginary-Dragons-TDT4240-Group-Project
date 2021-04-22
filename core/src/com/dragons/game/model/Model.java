package com.dragons.game.model;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.blocks.BlockType;

public abstract class Model implements IModel {
    private Vector2 position;
    private final float width, height;
    private boolean disposeModel = false;
    private final boolean isStatic, isSensor;

    public Model(Vector2 position, float width, float height, boolean isStatic, boolean isSensor) {
        this.position = position;
        this.width = width;
        this.height = height;
        this.isStatic = isStatic;
        this.isSensor = isSensor;
    }


    @Override
    public Vector2 getPosition() {
        return position;
    }

    @Override
    public void setPosition(float x, float y){
        position.set(x, y);
    }


    @Override
    public boolean isDisposed() {
        return disposeModel;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public boolean isSensor() {
        return isSensor;
    }

    @Override
    public void update(float timestep) {

    }

    /**
     * Sets the destroyModel value to true => this tells the world to destroy the model
     */
    protected void disposeModel(){
        disposeModel = true;
    }

    @Override
    public float getHeight() {
        return height;
    }

    @Override
    public float getWidth() {
        return width;
    }


}
