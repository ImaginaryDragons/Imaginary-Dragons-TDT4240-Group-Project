package com.dragons.game.model.bombs.fires;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.Model;
import com.dragons.game.utilities.Constants;



public class NormalFire extends Model implements IFire {

    private static final boolean isStatic = true;
    private static final boolean isSensor = false;
    private boolean fireExpired;
    private float loadingTime;

    public NormalFire(Vector2 position, float width, float height) {
        super(position, width, height, isStatic, isSensor);
        this.fireExpired = false;
        loadingTime = Constants.FireDisplayTime;
    }

    @Override
    public void update(float timestep) {
        loadingTime -= timestep;
        if (loadingTime < 0) {
            this.fireExpired = true;
        }
    }

    @Override
    public boolean isExpired() {
        return fireExpired;
    }


}
