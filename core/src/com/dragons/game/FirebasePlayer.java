package com.dragons.game;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirebasePlayer {

    public String name;
    public double score;

    private Map<String, Double> scores = new LinkedHashMap<>();

    public FirebasePlayer(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setScores(String name, double score) {
        scores.put(name, score);
    }

    public static Map<String, Double> getScores(){
        return scores;
    }


}
