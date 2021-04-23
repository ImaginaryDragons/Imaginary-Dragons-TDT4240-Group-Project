package com.dragons.game.networking;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public interface FireBaseInterface {


    public void writeHighscoreToFB(FirebasePlayer firebasePlayer);

    public void SetOnValueChangedListener(FirebasePlayer firebasePlayer);

}
