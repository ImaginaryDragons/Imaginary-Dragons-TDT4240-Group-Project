package com.dragons.game.model.player;


import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.Subject;
import com.dragons.game.utilities.Constants;
import com.dragons.game.utilities.Direction;

import java.util.ArrayList;
import java.util.Observer;

import javax.swing.ImageIcon;

/**
 * Instantiates a player. Has to be tied to a controller to control.
 * @param int ID, Vector2 startPos, PlayerColor color
 *
 * @author Eldar Sandanger
 */

enum PlayerColor {
    RED, BLUE, GREEN, YELLOW
}

public class Player extends Subject {

    private int ID;
    private PlayerColor col;
    private Rectangle boundRectangle;
    private Direction orientation; // The direction the player is looking
    private Vector2 position;
    private int health;
    private int speed;
    private int bombCapacity;
    private int bombsAvailable;
    private float bombRange;
    private float bombReloadTime;

    // TODO: Consider if it is necessary to implement a decorator for color, ID etc..
    // I suspect the answer is no, but there might be a good reason for it

    public Player(int ID, Vector2 startPos, PlayerColor col) {
        this.ID = ID;
        this.col = col;
        this.position = startPos;
        this.boundRectangle = new Rectangle(startPos.x, startPos.y, Constants.PlayerWidth, Constants.PlayerHeight);
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

    public PlayerColor getCol() {
        return col;
    }

    public Rectangle getShape() {
        return boundRectangle;
    }

    public void setShape(Shape2D shape) {
        boundRectangle.set((Rectangle)shape);
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
        this.boundRectangle.setPosition(pos.x, pos.y);
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
