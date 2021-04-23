package com.dragons.game.model.bombs.fires;

import com.dragons.game.model.IModel;
import com.dragons.game.model.bombs.BombType;

public interface IFire extends IModel {

    boolean isExpired();
    float getDisplayTime();
    void setDisplayTime(float time);

}
