package com.dragons.game.networking;

import com.badlogic.gdx.Game;
import com.dragons.game.view.componentViews.TimerView;
import com.dragons.game.view.screens.GameOverScreen;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirebasePlayer {

    private String name;
    private int score;
    public static Map<String, Integer> scores = new LinkedHashMap<>();

    public FirebasePlayer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static Map<String, Integer> getScores(){
        return scores;
    }


}
