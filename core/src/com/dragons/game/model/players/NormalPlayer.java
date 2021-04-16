package com.dragons.game.model.players;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.Model;
import com.dragons.game.utilities.Constants;
import com.dragons.game.utilities.Direction;

import static com.dragons.game.model.players.PlayerType.NORMALPLAYER;


/**
 * Instantiates a player. Has to be tied to a controller to control.
 * int ID, Vector2 startPos, Color color
 *
 * @author Eldar Sandanger
 */



public class NormalPlayer extends Model implements IPlayer {

    private int ID;
    private Color col;
    private Direction orientation; // The direction the player is looking
    private int lives;
    private int speed;
    private int bombCapacity;
    private int bombsAvailable;
    private int bombRange;
    private float bombReloadTime;

    private static final boolean isStatic = false;
    private static final boolean isSensor = false;


    // TODO: Consider if it is necessary to implement a decorator for color, ID etc..
    // I suspect the answer is no, but there might be a good reason for it
    // TODO: change width and height to float
    public NormalPlayer(int ID, Vector2 startPos, Color col, float width, float height) {
        super(startPos, width, height, isStatic, isSensor);
        this.ID = ID;
        this.col = col;

        orientation = Direction.UP;
        lives = Constants.InitPlayerHealth;
        speed = Constants.PlayerSpeed;
        bombCapacity = Constants.InitBombCap;
        bombsAvailable = bombCapacity; // Whats the difference between this and bombCapacity?
        bombRange = Constants.InitBombRange;
        bombReloadTime = Constants.BombReloadTime;
    }


    public int getID() {
        return ID;
    }

    @Override
    public Color getColor() {
        return col;
    }

    public void increaseSpeed(int amount){
        speed += amount;
    }

    public void increaseBombRange(int amount){
        bombRange += amount;
    }

    public void increaseBombCapacity(int amount){
        bombCapacity += amount;
    }


    public Direction getOrientation() {
        return orientation;
    }

    public void setOrientation(Direction orientation) {
        this.orientation = orientation;
    }


    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
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

    public void setBombRange(int bombRange) {
        this.bombRange = bombRange;
    }

}
