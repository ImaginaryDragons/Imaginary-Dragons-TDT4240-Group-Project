package com.dragons.game;

import com.badlogic.gdx.Game;
import com.dragons.game.view.componentViews.TimerView;
import com.dragons.game.view.screens.GameOverScreen;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirebasePlayer {

    private String name;
    private int score;
    public static Map<String, Integer> scores = new LinkedHashMap<>();

    public FirebasePlayer(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setScores(String name, int score) {
        scores.put(name, score);
    }

    public static Map<String, Integer> getScores(){
        return scores;
    }


}
