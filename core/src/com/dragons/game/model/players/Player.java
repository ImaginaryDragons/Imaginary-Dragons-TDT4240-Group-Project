package com.dragons.game.model.players;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.Model;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.model.bombs.IBomb;
import com.dragons.game.model.modelFactories.BombFactory;
import com.dragons.game.model.players.playerEnums.Direction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class Player extends Model implements IPlayer {

    protected int ID;
    protected Color color;
    protected int lives;
    protected float speed;
    protected int bombCapacity;
    protected int extraBombRange;
    protected Queue<IBomb> bombInventory;
    protected final Queue<IBomb> placedBombs = new LinkedList<>();
    protected float hitProtectionTime;
    protected boolean hitProtectionMode = false;
    private Direction orientation = Direction.UP; // The direction the player is looking

    private List<Float> newBombTimeCounters = new ArrayList<>();

    private static final boolean isStatic = false;
    private static final boolean isSensor = false;




    public Player(Vector2 startPos, float width, float height) {
        super(startPos, width, height, isStatic, isSensor);
    }

    @Override
    public void setPosition(float x, float y){
        super.setPosition(x, y);
        for (IBomb bomb : bombInventory){
            bomb.setPosition(x, y);
        }
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
         * Checks if
         *
         */
        if (bombInventory.size() < bombCapacity){
            List<Float> newCounterList = new ArrayList<>();
            for (Float timeToNewBomb : newBombTimeCounters){
                float newTime = timeToNewBomb - timestep;
                if (newTime < 0) {
                    // Bomb is finished exploding => add it back to inventory
                    addBombs(placedBombs.remove());
                }
                else newCounterList.add(newTime);
            }

            newBombTimeCounters = newCounterList;


        }
    }

    @Override
    public void increaseSpeed(float amount){
        speed += amount;
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
    public void useBomb() {
        IBomb bomb = bombInventory.remove();
        placedBombs.add(bomb);
        // add one counter for every bomb used;
        newBombTimeCounters.add(bomb.getExplodeTime() + bomb.getFire().getDisplayTime());
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
