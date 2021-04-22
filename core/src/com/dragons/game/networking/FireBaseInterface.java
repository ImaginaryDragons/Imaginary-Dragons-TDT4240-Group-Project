package com.dragons.game.networking;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public interface FireBaseInterface {


    public void writeHighscoreToFB(String name, double score, int id);

    public void SetOnValueChangedListener();
}
