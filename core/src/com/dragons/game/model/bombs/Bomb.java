package com.dragons.game.model.bombs;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.Model;
import com.dragons.game.model.bombs.fires.IFire;
import com.dragons.game.model.modelFactories.FireFactory;
import com.dragons.game.utilities.Constants;

public abstract class Bomb extends Model implements IBomb {

    private float detonationTime;
    private int bombRange;
    protected boolean bombExploded = false;
    private final BombType type;
    protected IFire fire;

    public Bomb(Vector2 pos, float width, float height, int bombRange, final BombType type, boolean isStatic, boolean isSensor){
        super(pos, width, height, isStatic, isSensor);
        this.bombRange = bombRange;
        this.type = type;
        this.detonationTime = Constants.DefaultDetonationTime;
        fire = (IFire) FireFactory.getInstance().createFire(pos, type, width, height);
    }

    @Override
    public void update(float timestep){
        detonationTime -= timestep;
        if (detonationTime < 0) {
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


    @Override
    public float getFireDisplayTime() {
        return fire.getDisplayTime();
    }

    @Override
    public float getDetonationTime(){
        return detonationTime;
    }

    protected void setDetonationTime(float detonationTime) {
        this.detonationTime = detonationTime;
    }
}
