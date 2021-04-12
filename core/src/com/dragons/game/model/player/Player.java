package com.dragons.game.model.player;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.dragons.game.model.Model;
import com.dragons.game.utilities.Constants;
import com.dragons.game.utilities.Direction;

import static com.dragons.game.utilities.Constants.PPM;

/**
 * Instantiates a player. Has to be tied to a controller to control.
 * int ID, Vector2 startPos, Color color
 *
 * @author Eldar Sandanger
 */



public class Player extends Model {

    private int ID;
    private Color col;
    //private Shape boundRectangle;
    private PolygonShape shape;
    private Direction orientation; // The direction the player is looking
    private int lives;
    private int speed;
    private int bombCapacity;
    private int bombsAvailable;
    private int bombRange;
    private float bombReloadTime;


    // TODO: Consider if it is necessary to implement a decorator for color, ID etc..
    // I suspect the answer is no, but there might be a good reason for it
    // TODO: change width and height to float
    public Player(int ID, Vector2 startPos, Color col, int width, int height) {
        super(startPos, PlayerType.NORMALPLAYER, (float) width, (float) height);
        this.ID = ID;
        this.col = col;
        final PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2f / PPM, height / 2f / PPM);
        super.setShape(shape);

        orientation = Direction.UP;
        lives = Constants.InitPlayerHealth;
        speed = Constants.PlayerSpeed;
        bombCapacity = Constants.InitBombCap;
        bombsAvailable = bombCapacity; // Whats the difference between this and bombCapacity?
        bombRange = Constants.InitBombRange;
        bombReloadTime = Constants.BombReloadTime;
    }

    // TODO: Write necessary observer classes for the player

    public int getID() {
        return ID;
    }

    public Color getCol() {
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
