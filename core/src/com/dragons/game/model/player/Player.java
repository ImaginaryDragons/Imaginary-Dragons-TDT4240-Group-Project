package com.dragons.game.model.player;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.dragons.game.model.IModelType;
import com.dragons.game.model.IObject;
import com.dragons.game.utilities.Constants;
import com.dragons.game.utilities.Direction;

/**
 * Instantiates a player. Has to be tied to a controller to control.
 * int ID, Vector2 startPos, Color color
 *
 * @author Eldar Sandanger
 */

public class Player implements IObject {

    private int ID;
    private Color col;
    //private Shape boundRectangle;
    private PolygonShape shape;
    private Direction orientation; // The direction the player is looking
    private Vector2 position;
    public int health;
    public int speed;
    public int bombCapacity;
    private int bombsAvailable;
    public float bombRange;
    private float bombReloadTime;

    // TODO: Consider if it is necessary to implement a decorator for color, ID etc..
    // I suspect the answer is no, but there might be a good reason for it

    public Player(int ID, Vector2 startPos, Color col, int width, int height) {
        this.ID = ID;
        this.col = col;
        this.position = startPos;
        this.shape = new PolygonShape();
        shape.setAsBox(width / 2, height / 2);

        // TODO: FIX SHAPE
        this.orientation = Direction.DOWN;
        this.health = Constants.InitPlayerHealth;
        this.speed = Constants.PlayerSpeed;
        this.bombCapacity = Constants.InitBombCap;
        this.bombsAvailable = this.bombCapacity;
        this.bombRange = Constants.InitBombRange;
        this.bombReloadTime = Constants.BombReloadTime;
    }

    // TODO: Write necessary observer classes for the player

    public int getID() {
        return ID;
    }

    public Color getCol() {
        return col;
    }

    public PolygonShape getShape() {
        return shape;
    }

    @Override
    public IModelType getType() {
        return null;
    }

    @Override
    public boolean isStatic() {
        return false;
    }

    @Override
    public boolean isSensor() {
        return false;
    }

    public void setShape(Shape shape) {
        //TODO:: FIX THIS
    }

    public Direction getOrientation() {
        return orientation;
    }

    public void setOrientation(Direction orientation) {
        this.orientation = orientation;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 pos) {
        this.position = pos;
        //this.boundRectangle.setPosition(pos.x, pos.y); TODO: FIX THIS
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getBombCapacity() {
        return bombCapacity;
    }

    public void setBombCapacity(int bombCapacity) {
        this.bombCapacity = bombCapacity;
    }

    public int getBombsAvailable() {
        return bombsAvailable;
    }

    public void setBombsAvailable(int bombsAvailable) {
        this.bombsAvailable = bombsAvailable;
    }

    public float getBombRange() {
        return bombRange;
    }

    public void setBombRange(float bombRange) {
        this.bombRange = bombRange;
    }
}
