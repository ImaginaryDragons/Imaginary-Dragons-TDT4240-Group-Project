package com.dragons.game.model.bombs;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.bombs.fires.IFire;
import com.dragons.game.model.maps.GameMap;

import java.util.ArrayList;

public interface IBomb extends IModel {

    boolean isExploded();
    void hitByFire();
    BombType getType();
    float getExplodeTime();
    IFire getFire();
    void increaseRange(int amount);
    int getBombRange();

}
