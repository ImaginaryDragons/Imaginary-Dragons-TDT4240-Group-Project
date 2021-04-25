package com.dragons.game.model.players;

import com.badlogic.gdx.graphics.Color;
import com.dragons.game.model.IModel;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.model.bombs.IBomb;
import com.dragons.game.model.players.playerEnums.Direction;

public interface IPlayer {
    int getID();
    int getLives();
    int getBombsAvailable();
    int getExtraBombRange();
    float getSpeed();
    Direction getOrientation();
    Color getColor();
    IBomb getBomb();
    void handleHitByBomb();
    void useBomb();
    void setOrientation(Direction orientation);
    void increaseSpeed(float amount);
    void increaseBombRange(int amount);
    void increaseBombCapacity(int amount, BombType bombType);
}
