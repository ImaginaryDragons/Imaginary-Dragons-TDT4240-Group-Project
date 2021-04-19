package com.dragons.game.model.players;

import com.badlogic.gdx.graphics.Color;
import com.dragons.game.model.IModel;

public interface IPlayer extends IModel {
    int getID();
    Color getColor();
    int getLives();
    void handleHitByBomb();
}
