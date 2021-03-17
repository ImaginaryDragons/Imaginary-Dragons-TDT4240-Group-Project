package com.dragons.game.components;


import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class BombComponent {
    private Texture bomb;
    private int x, y;
    private Timer timer;
    private TimerTask task;
    private int timeLeft = 0;
    private boolean bombExplode;
    public static List<BombComponent> bombs = new ArrayList<BombComponent>(); // liste med antall bomber en spiller har

    public BombComponent (int x, int y){ // Ta inn noe tiles?
        this.x = x;
        this.y = y;
        bomb = new Texture("");
        bombExplode = false;
        bombs.add(this);

    }

}
