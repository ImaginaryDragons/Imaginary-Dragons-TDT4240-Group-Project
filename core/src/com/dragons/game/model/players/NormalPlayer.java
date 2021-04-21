package com.dragons.game.model.players;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.Model;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.utilities.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * Instantiates a player. Has to be tied to a controller to control.
 * int ID, Vector2 startPos, Color color
 *
 */



public class NormalPlayer extends Model implements IPlayer{

    private final int ID;
    private final Color col;
    private Direction orientation; // The direction the player is looking
    private int lives;
    private float speed;
    private int bombCapacity;
    private int bombRange;
    private final Queue<BombType> bombInventory;
    private final Queue<BombType> placedBombs = new PriorityQueue<>();
    private float hitProtectionTime;
    private boolean hitProtectionMode;

    private final static float timeToNewBomb = Constants.BombExplodeTime + Constants.FireDisplayTime;;
    private List<Float> newBombTimeCounters = new ArrayList<>();

    private static final boolean isStatic = false;
    private static final boolean isSensor = false;
    private static final BombType startingBomb = BombType.NEW_TEST_BOMB;


    public NormalPlayer(int ID, Vector2 startPos, Color col, float width, float height) {
        super(startPos, width, height, isStatic, isSensor);
        this.ID = ID;
        this.col = col;


        orientation = Direction.UP;
        lives = Constants.InitPlayerHealth;
        speed = Constants.PlayerSpeed;
        bombCapacity = Constants.InitBombCap;
        bombInventory = new PriorityQueue<>();
        for (int i = 0; i < bombCapacity; i++) {
            bombInventory.add(startingBomb);
        }

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


        if (bombInventory.size() < bombCapacity){
            List<Float> newCounterList = new ArrayList<>();
            for (Float counter : newBombTimeCounters){
                float newTime = counter + timestep;
                if (newTime > timeToNewBomb) {
                    // Bomb is finished exploding => add it back to inventory
                    addBombs(placedBombs.remove());
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
        return bombInventory.size();
    }

    @Override
    public int getBombRange() {
        return bombRange;
    }

    @Override
    public BombType getBombType() {
        return bombInventory.peek();
    }

    @Override
    public void useBomb() {
        placedBombs.add(bombInventory.remove());
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

    public void increaseBombCapacity(int amount, BombType bombType){
        bombCapacity += amount;
        for (int i = 0; i < amount; i++) {
            addBombs(bombType);
        }
    }

    private void addBombs(BombType bomb){
        if (this.bombInventory.size() < bombCapacity) this.bombInventory.add(bomb);

    }



}
