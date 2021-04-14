package com.dragons.game.model.bombs.fires;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModelType;
import com.dragons.game.model.Model;


public class NormalFire extends Model implements IFire{

    private static final boolean isStatic = true;
    private static final boolean isSensor = false;

    public NormalFire(Vector2 position, IModelType type, float width, float height) {
        super(position, type, width, height, isStatic, isSensor);


    }


}
