package com.dragons.game.model.player;


import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.utilities.Constants;
import com.dragons.game.utilities.Direction;

import java.util.ArrayList;
import java.util.Observer;

enum PlayerColor {
    RED, BLUE, GREEN, YELLOW
}

public class Player {

    private int ID;
    private PlayerColor col;
    private Rectangle boundRectangle;
    // TODO: Should the player be given a controller, or a controller a player??
    // Alt 1 gives: private PlayerController controller;
    // This can work fine, but we can see
    private Direction orientation; // The direction the player is looking
    private Vector2 position;
    private int health;
    private int speed;
    private int bombCapacity;
    private int bombsAvailable;
    private float bombRange;
    private float bombReloadTime;

    private ArrayList observers; // TODO: Instantiate

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

    /*IMPORTANT: It is fully possible that we want to abstract an observable class that encapsulates the
    * property out from the player class itself! It would in such a case work like a wrapper for getting
    * data from player in a particular way. However, this might be perfectly fine as well.
    *
    * There is also a possibility that we might want to specialize our observer pattern in a way
    * where we only observe relevant data individually. How this can be done is in design patterns book
    *
    * ALSO IMPORTANT: Page 83 HFDP. Don't use java observable class because it sucks.
    * Might want to create own observer interface at some point?
    * See page 528 -> for better implementation at a later stage!
     */

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers(Observer o) {
        for (int i = 0; i < observers.size(); i++) {
            Observer obs = (Observer)observers.get(i);
            // TODO: obs.update(SPECIFIC DATA!!);
            // ALT: Specify e.g. notifyPosObserver(posObserver o)
        }
    }

    public int getID() {
        return ID;
    }

    public PlayerColor getCol() {
        return col;
    }

    public Rectangle getBoundRectangle() {
        return boundRectangle;
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

    public void setPosition(Vector2 position) {
        this.position = position;
        this.boundRectangle.setPosition(position.x, position.y);
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
