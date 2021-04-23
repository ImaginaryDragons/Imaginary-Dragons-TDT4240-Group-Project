package com.dragons.game.model.bombs;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.Model;
import com.dragons.game.model.blocks.DestructibleBlock;
import com.dragons.game.model.blocks.WallBlock;
import com.dragons.game.model.bombs.fires.IFire;
import com.dragons.game.model.maps.GameMap;
import com.dragons.game.model.modelFactories.FireFactory;
import com.dragons.game.utilities.Constants;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Bomb extends Model implements IBomb {

    private float explodeTime;
    private int bombRange;
    protected boolean bombExploded = false;
    private final BombType type;
    protected IFire fire;

    public Bomb(Vector2 pos, float width, float height, int bombRange, final BombType type, boolean isStatic, boolean isSensor){
        super(pos, width, height, isStatic, isSensor);
        this.bombRange = bombRange;
        this.type = type;
        this.explodeTime = Constants.DefaultBombExplodeTime;
        fire = (IFire) FireFactory.getInstance().createFire(pos, type, width, height);
    }

    @Override
    public void update(float timestep){
        explodeTime -= timestep;
        if (explodeTime < 0) {
            bombExploded = true;
        }
    }

    @Override
    public int getBombRange() {
        return bombRange;
    }


    @Override
    public BombType getType() {
        return type;
    }

    @Override
    public boolean isExploded() {
        return bombExploded;
    }

    @Override
    public void increaseRange(int amount){
        bombRange += amount;
    }


    public float getExplodeTime(){
        return explodeTime;
    }

    @Override
    public IFire getFire() {
        return fire;
    }

    protected void setExplodeTime(float explodeTime) {
        this.explodeTime = explodeTime;
    }
}
