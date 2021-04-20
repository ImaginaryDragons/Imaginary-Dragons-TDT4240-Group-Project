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
    Direction getOrientation();
    Color getColor();
    BombType getBombType();
    void handleHitByBomb();
    void useBomb();
}
