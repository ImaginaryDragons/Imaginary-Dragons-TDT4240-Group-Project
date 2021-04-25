package com.dragons.game.model.bombs;

import com.badlogic.gdx.math.Vector2;

import com.dragons.game.model.bombs.hitByFireStrategies.Explode;
import com.dragons.game.utilities.Constants;



public class NormalBomb extends Bomb {

    private static final boolean isStatic = true;
    private static final boolean isSensor = true;
    private static final int startingRange = Constants.InitBombRange;



    public NormalBomb(Vector2 pos, float width, float height, int extraRange, BombType type){
        super(pos, width, height, startingRange + extraRange, type, isStatic, isSensor);
        hitByFireStrategy = new Explode();
    }



}
