package com.dragons.game.model.bombs.fires;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.Model;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.utilities.Constants;



public class NormalFire extends Model implements IFire {

    private static final boolean isStatic = false;
    private static final boolean isSensor = true;
    private float DisplayTime = Constants.FireDisplayTime;;
    private boolean fireExpired;
    private final BombType bombType;

    public NormalFire(Vector2 position, float width, float height, BombType type) {
        super(position, width, height, isStatic, isSensor);
        this.fireExpired = false;
        bombType = type;
    }

    @Override
    public void update(float timestep) {
        DisplayTime -= timestep;
        if (DisplayTime < 0) {
            this.fireExpired = true;
        }
    }

    @Override
    public boolean isExpired() {
        return fireExpired;
    }

    @Override
    public BombType getBombType() {
        return bombType;
    }

    @Override
    public IFire clone() {
        try {
            return (IFire) super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }

    @Override
    public float getDisplayTime() {
        return DisplayTime;
    }

    @Override
    public void setDisplayTime(float time) {
        DisplayTime = time;
    }


}
