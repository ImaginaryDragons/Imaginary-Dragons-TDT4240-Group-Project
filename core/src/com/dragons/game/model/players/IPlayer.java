package com.dragons.game.model.players;

import com.badlogic.gdx.graphics.Color;

public interface IPlayer {
    Color getColor();
    public void handleHitByBomb();
}
