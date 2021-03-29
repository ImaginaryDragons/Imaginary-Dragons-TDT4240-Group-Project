package com.dragons.game.model.bomb;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.Subject;

import java.util.Timer;
import java.util.TimerTask;

public class Bomb extends Subject {

    private Vector2 position;
    private Circle circleBounds;
    private Timer timer;
    private TimerTask task;
    private int timeLeft = 0;
    private boolean bombExplode;
    //public static List<BombComponent> bombs = new ArrayList<BombComponent>(); // liste med antall bomber en spiller har, skal heller være i player

    public Bomb(Vector2 pos, float radius){ // Ta inn noe tiles?
        this.position = pos;
        this.circleBounds.set(pos, radius);
        bombExplode = false;

        // TODO: Set initial coundown parameters properly
    }

    public void update(float timestep) {
        // TODO: Implement timestep update for bomb! This means update countdown for each delta
    }

    @Override
    public void setPosition(Vector2 pos) {
        this.position = pos;
        this.circleBounds.setPosition(pos.x, pos.y);
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    @Override
    public void setShape(Shape2D shape) {
        this.circleBounds = (Circle)shape;
    }

    @Override
    public Shape2D getShape() {
        return this.circleBounds;
    }
}
