package com.dragons.game;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public interface FireBaseInterface {


    public void writeHighscoreToFB(String name, int score, int id);

    public void SetOnValueChangedListener(FirebasePlayer firebasePlayer);



}
