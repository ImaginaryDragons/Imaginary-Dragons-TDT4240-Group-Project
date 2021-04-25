package com.dragons.game.networking;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirebasePlayer {

    private String name;
    private int score;
    public static Map<String, Map<String, Integer>> scores = new LinkedHashMap<>();

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

    public int getScore() {
        return score;
    }

    public static Map<String, Map<String, Integer>> getScores(){
        return scores;
    }
}

