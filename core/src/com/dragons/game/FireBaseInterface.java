package com.dragons.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.player.PlayerColor;

public interface FireBaseInterface {

    public void SomeFunction();

    public void writePlayerToFB(int ID, Vector2 position, Color color, int width, int height);

    public void SetOnValueChangedListener();
}
