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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/**
 * Instantiates a player. Has to be tied to a controller to control.
 * int ID, Vector2 startPos, Color color
 *
 * @author Eldar Sandanger
 */



public class NormalPlayer extends Model implements IPlayer{

    private final int ID;
    private final Color col;
    private Direction orientation; // The direction the player is looking
    private int lives;
    private float speed;
    private int bombCapacity;
    private int bombsAvailable;
    private int bombRange;
    private final BombType bombType = BombType.NORMALBOMB;
    private float hitProtectionTime;
    private boolean hitProtectionMode;

    private final static float timeToNewBomb = Constants.BombExplodeTime + Constants.FireDisplayTime;;
    private List<Float> newBombTimeCounters = new ArrayList<>();

    private static final boolean isStatic = false;
    private static final boolean isSensor = false;


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
        hitProtectionTime = Constants.FireDisplayTime + 1f; // TODO: magic number
        hitProtectionMode = false;
    }

    @Override
    public void update(final float timestep) {
        if (hitProtectionMode) {
            hitProtectionTime -= timestep;
            if (hitProtectionTime < 0){
                hitProtectionMode = false;
            }
        }


        if (bombsAvailable < bombCapacity){
            List<Float> newCounterList = new ArrayList<>();
            for (Float counter : newBombTimeCounters){
                float newTime = counter + timestep;
                if (newTime > timeToNewBomb) {
                    addNewBomb();
                }
                else newCounterList.add(newTime);
            }

            newBombTimeCounters = newCounterList;


        }
    }
    @Override
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

    @Override
    public void useBomb() {
        bombsAvailable -= 1;
        // add one counter for every bomb used;
        newBombTimeCounters.add(0f);
    }

    @Override
    public void setOrientation(Direction orientation) {
        this.orientation = orientation;
    }

    @Override
    public float getSpeed() {
        return speed;
    }


    public void increaseSpeed(float amount){
        speed += amount;
    }

    public void increaseBombRange(int amount){
        bombRange += amount;
    }

    public void increaseBombCapacity(int amount){
        bombCapacity += amount;
        addNewBomb();
    }

    private void addNewBomb(){
        if (bombsAvailable < bombCapacity) bombsAvailable += 1;
    }

    public void setBombRange(int bombRange) {
        this.bombRange = bombRange;
    }
    public void setLives(int lives) {
        this.lives = lives;
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
