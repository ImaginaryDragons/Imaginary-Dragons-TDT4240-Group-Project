package com.dragons.game.model.bombs;

import com.badlogic.gdx.math.Vector2;

import com.dragons.game.model.IModel;
import com.dragons.game.model.Model;
import com.dragons.game.model.blocks.DestructibleBlock;
import com.dragons.game.model.blocks.WallBlock;
import com.dragons.game.model.maps.GameMap;
import com.dragons.game.utilities.Constants;

import java.util.ArrayList;
import java.util.Iterator;


public class NormalBomb extends Bomb {

    private static final boolean isStatic = true;
    private static final boolean isSensor = true;



    public NormalBomb(Vector2 pos, float width, float height, int bombRange, BombType type){
        super(pos, width, height, bombRange, type, isStatic, isSensor);
    }



    @Override
    public void hitByFire(){
        bombExploded = true;
    }


}
