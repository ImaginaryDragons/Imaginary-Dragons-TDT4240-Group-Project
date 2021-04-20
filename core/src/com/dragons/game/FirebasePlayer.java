package com.dragons.game;

import com.badlogic.gdx.Game;
import com.dragons.game.view.modelViews.timer.TimerView;
import com.dragons.game.view.screens.GameOverScreen;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirebasePlayer {

    public String name;
    public double score;

    private TimerView timerView;
    private DragonsGame dragonsGame;

    public static Map<String, Double> scores = new LinkedHashMap<>();

    private GameOverScreen gameOver = new GameOverScreen(dragonsGame, score);

    public FirebasePlayer(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return gameOver.getName();
    }

    public void setName(String name) {
        this.name = gameOver.getName();
    }

    public double getScore() {
        return timerView.getScoreCount();
    }

    public void setScore(double score) {
        this.score = timerView.getScoreCount();
    }

    public void setScores(String name, double score) {
        scores.put(name, score);
    }

    public static Map<String, Double> getScores(){
        return scores;
    }


}
