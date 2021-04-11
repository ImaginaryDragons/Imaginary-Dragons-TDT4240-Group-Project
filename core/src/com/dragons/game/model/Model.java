package com.dragons.game.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Shape;

public abstract class Model implements IModel {
    public Vector2 position;
    private final IModelType type;
    private final float width, height;

    private Shape shape;

    public Model(Vector2 position, IModelType type, float width, float height) {
        this.position = position;
        this.type = type;
        this.width = width;
        this.height = height;
    }

    protected void setShape(Shape shape){
        this.shape = shape;
    }


    @Override
    public void setPosition(Vector2 position) {
        this.position = position;
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    @Override
    public Shape getShape() {
        return shape;
    }

    //TODO: Method might not be necessary
    @Override
    public IModelType getType() {
        return type;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }
}
