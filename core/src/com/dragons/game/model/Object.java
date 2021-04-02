package com.dragons.game.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.Shape.Type;

import static com.dragons.game.utilities.Constants.PPM;

public abstract class Object implements IObject{
    private Vector2 position;
    private final IModelType type;
    private final float width, height;
    private final boolean isStatic;
    private final boolean isSensor;
    private final Shape shape;

    public Object(Vector2 position, IModelType type, float width, float height, boolean isStatic,
                  boolean isSensor, Shape.Type shapeType) {

        this.position = position;
        this.type = type;
        this.width = width;
        this.height = height;
        this.isStatic = isStatic;
        this.isSensor = isSensor;

        shape = chooseShape(shapeType);
    }

    //TODO: check if it's width / 2 / PPM or width / PPM
    //TODO: implementation works, but only if every body has only one fixture. Shall dragon av rectangleShape?
    private Shape chooseShape(Type shapeType){
        switch (shapeType){
            case Polygon:
                PolygonShape polygonShape = new PolygonShape();
                polygonShape.setAsBox(width / 2 / PPM, height / 2 / PPM);
                return polygonShape;

            case Circle:
                CircleShape circleShape = new CircleShape();
                circleShape.setRadius(width / 2 / PPM);
                return circleShape;

            default:
                throw new IllegalArgumentException();
        }
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

    @Override
    public IModelType getType() {
        return type;
    }

    @Override
    public boolean isStatic() {
        return isStatic;
    }

    @Override
    public boolean isSensor() {
        return isSensor;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }
}
