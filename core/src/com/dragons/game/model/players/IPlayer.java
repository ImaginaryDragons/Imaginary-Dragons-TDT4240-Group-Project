package com.dragons.game.model.players;

import com.badlogic.gdx.graphics.Color;
import com.dragons.game.model.IModel;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.utilities.Direction;

public interface IPlayer extends IModel {
    int getID();
    int getLives();
    int getBombRange();
    int getBombsAvailable();
    float getSpeed();
    Direction getOrientation();
    Color getColor();
    BombType getBombType();
    void handleHitByBomb();
    void useBomb();
    void setOrientation(Direction orientation);
    void increaseSpeed(float amount);
    void increaseBombRange(int amount);
    void increaseBombCapacity(int amount);
}
