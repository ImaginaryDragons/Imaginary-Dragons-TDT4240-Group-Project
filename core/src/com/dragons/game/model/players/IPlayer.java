package com.dragons.game.model.players;

import com.badlogic.gdx.graphics.Color;
import com.dragons.game.model.IModel;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.utilities.Direction;

public interface IPlayer extends IModel {
    int getID();
    Color getColor();
    int getLives();
    void handleHitByBomb();
    Direction getOrientation();
    int getBombRange();
    BombType getBombType();
    int getBombsAvailable();
}
