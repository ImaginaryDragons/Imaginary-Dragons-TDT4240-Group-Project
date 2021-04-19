package com.dragons.game.model.players;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.Model;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.model.bombs.NormalBomb;
import com.dragons.game.utilities.Constants;
import com.dragons.game.utilities.Direction;
import com.dragons.game.view.IModelObserver;

import java.util.ArrayList;
import java.util.List;


/**
 * Instantiates a player. Has to be tied to a controller to control.
 * int ID, Vector2 startPos, Color color
 *
 * @author Eldar Sandanger
 */



public class NormalPlayer extends Model implements IPlayer{

    private int ID;
    private Color col;
    private Direction orientation; // The direction the player is looking
    private int lives;
    private int speed;
    private int bombCapacity;
    private int bombsAvailable;
    private int bombRange;
    private float bombReloadTime;
    private final BombType bombType = BombType.NORMALBOMB;
    private float hitProtectionTime;
    private boolean hitProtectionMode;

    private static final boolean isStatic = false;
    private static final boolean isSensor = false;


    // TODO: Consider if it is necessary to implement a decorator for color, ID etc..
    // I suspect the answer is no, but there might be a good reason for it

    public NormalPlayer(int ID, Vector2 startPos, Color col, float width, float height) {
        super(startPos, width, height, isStatic, isSensor);
        this.ID = ID;
        this.col = col;


        orientation = Direction.UP;
        lives = Constants.InitPlayerHealth;
        speed = Constants.PlayerSpeed;
        bombCapacity = Constants.InitBombCap;
        bombsAvailable = bombCapacity;
        bombRange = Constants.InitBombRange;
        bombReloadTime = Constants.BombReloadTime;
        hitProtectionTime = Constants.FireDisplayTime + 1f;
        hitProtectionMode = false;
    }

    @Override
    public void update(float timestep) {
        if (hitProtectionMode) {
            hitProtectionTime -= timestep;
            if (hitProtectionTime < 0){
                hitProtectionMode = false;
            }
        }
    }

    public int getID() {
        return ID;
    }

    @Override
    public Color getColor() {
        return col;
    }

    @Override
    public void handleHitByBomb() {
        if (!hitProtectionMode){
            lives -= 1;
            hitProtectionMode = true;
        }
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

    @Override
    public Direction getOrientation() {
        return orientation;
    }


    @Override
    public int getLives() {
        return lives;
    }

    @Override
    public int getBombsAvailable() {
        return bombsAvailable;
    }

    @Override
    public int getBombRange() {
        return bombRange;
    }

    @Override
    public BombType getBombType() {
        return bombType;
    }

    public void setOrientation(Direction orientation) {
        this.orientation = orientation;
    }

    public void setBombRange(int bombRange) {
        this.bombRange = bombRange;
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


    public void setBombsAvailable(int bombsAvailable) {
        this.bombsAvailable = bombsAvailable;
    }

}
