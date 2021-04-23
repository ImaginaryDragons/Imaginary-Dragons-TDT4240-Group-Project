package com.dragons.game.model.bombs.fires;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.Model;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.utilities.Constants;



public class NormalFire extends Model implements IFire {

    // Has to be false! Static objects dont collide with other static objects, in this case destructible block
    private static final boolean isStatic = false;
    private static final boolean isSensor = true;
    private float DisplayTime = Constants.FireDisplayTime;;
    private boolean fireExpired;

    public NormalFire(Vector2 position, float width, float height) {
        super(position, width, height, isStatic, isSensor);
        this.fireExpired = false;
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
    public float getDisplayTime() {
        return DisplayTime;
    }

    @Override
    public void setDisplayTime(float time) {
        DisplayTime = time;
    }


}
