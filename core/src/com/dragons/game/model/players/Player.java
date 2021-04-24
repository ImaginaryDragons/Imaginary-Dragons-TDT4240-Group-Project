package com.dragons.game.model.players;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.Model;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.model.bombs.IBomb;
import com.dragons.game.model.modelFactories.BombFactory;
import com.dragons.game.model.players.playerEnums.Direction;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Player extends Model implements IPlayer {

    protected int ID;
    protected int lives;
    protected int bombCapacity;
    protected int extraBombRange;
    protected float speed;
    protected float hitProtectionTime;
    protected Color color;
    protected boolean hitProtectionMode = false;
    protected Queue<IBomb> bombInventory = new LinkedList<>();
    protected Queue<IBomb> placedBombs = new LinkedList<>();
    private Queue<Float> newBombTimeCounters = new LinkedList<>(); // A queue of the explodingtime remaining for all the placed bombs
    private Direction orientation = Direction.UP; // The direction the player is looking

    private static final boolean isStatic = false;
    private static final boolean isSensor = false;

    public Player(Vector2 startPos, float width, float height) {
        super(startPos, width, height, isStatic, isSensor);
    }


    @Override
    public void update(final float timestep) {
        if (hitProtectionMode) {
            hitProtectionTime -= timestep;
            if (hitProtectionTime < 0){
                hitProtectionMode = false;
            }
        }

        /*
         * Checks if the player has more space for any bombs in its inventory
         * If it does then the method checks if there are any bombs of which their fire is finished to display
         * Removes those bombs from the placed bombs queue and put it back to the inventory
         */
        if (bombInventory.size() < bombCapacity){
            LinkedList<Float> newCounterList = new LinkedList<>();
            for (Float timeToNewBomb : newBombTimeCounters){
                float newTime = timeToNewBomb - timestep;
                if (newTime < 0) {
                    // Bomb is finished exploding => add it back to inventory
                    addBombs(placedBombs.remove());
                }
                // Not finished exploding => add new time to the queue
                else newCounterList.add(newTime);
            }

            newBombTimeCounters = newCounterList;


        }
    }



    @Override
    public void increaseBombRange(int amount){
        extraBombRange += amount;
        for (IBomb bomb : bombInventory){
            bomb.increaseRange(amount);
        }

        for (IBomb bomb : placedBombs){
            bomb.increaseRange(amount);
        }

    }

    @Override
    public void increaseSpeed(float amount){
        speed += amount;
    }

    @Override
    public void increaseBombCapacity(int amount, BombType bombType){
        bombCapacity += amount;
        for (int i = 0; i < amount; i++) {
            addBombs(createBomb(getPosition(), bombType, getWidth(), getHeight(), extraBombRange));
        }
    }

    protected IBomb createBomb(Vector2 pos, BombType bombType, float width, float height, int extraRange){
        return (IBomb) BombFactory.getInstance().createBomb(pos, bombType, width, height, extraRange);
    }

    private void addBombs(IBomb bomb){
        if (this.bombInventory.size() < bombCapacity) this.bombInventory.add(bomb);

    }

    @Override
    public void useBomb() {
        IBomb bomb = bombInventory.remove();
        placedBombs.add(bomb);
        // add one counter for every bomb used;
        newBombTimeCounters.add(bomb.getDetonationTime() + bomb.getFireDisplayTime());
    }


    @Override
    public int getExtraBombRange(){
        return extraBombRange;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public Color getColor() {
        return color;
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
    public IBomb getBomb() {
        return bombInventory.peek();
    }

    @Override
    public void setOrientation(Direction orientation) {
        this.orientation = orientation;
    }

    @Override
    public float getSpeed() {
        return speed;
    }




}
