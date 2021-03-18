package com.dragons.game.model.powerups;

import com.badlogic.gdx.math.Vector2;
import java.util.Timer;
import java.util.TimerTask;

public class Bomb {

    private Vector2 position;
    private Timer timer;
    private TimerTask task;
    private int timeLeft = 0;
    private boolean bombExplode;
    //public static List<BombComponent> bombs = new ArrayList<BombComponent>(); // liste med antall bomber en spiller har, skal heller være i player

    public Bomb(int x, int y){ // Ta inn noe tiles?
        this.position.x = x;
        this.position.y = y;
        bombExplode = false;
        // bombs.add(this);
    }

}
