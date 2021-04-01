package com.dragons.game.model.bomb;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.Subject;
import com.dragons.game.model.blockFactory.blocks.DestructibleBlock;
import com.dragons.game.model.blockFactory.blocks.WallBlock;
import com.dragons.game.model.player.Player;
import com.dragons.game.utilities.Constants;

import java.util.Timer;
import java.util.TimerTask;

public class Bomb extends Subject {

    private Vector2 position;
    private Circle circleBounds;
    private Timer timer;
    private float loadingTime;
    private TimerTask task;
    private int timeLeft = 0;
    private boolean bombExplode;
    private float bombRange;
    private Player player;
    private DestructibleBlock destructibleBlock;
    private WallBlock wallBlock;
    //public static List<BombComponent> bombs = new ArrayList<BombComponent>(); // liste med antall bomber en spiller har, skal heller være i player

    public Bomb(Vector2 pos, float radius, TimerTask task, Player player, DestructibleBlock destructibleBlock, WallBlock wallBlock){ // Ta inn noe tiles?
        this.position = pos;
        this.task = task;
        this.player = player;
        this.destructibleBlock = destructibleBlock;
        this.wallBlock = wallBlock;
        this.circleBounds.set(pos, radius);
        bombExplode = false;
        loadingTime = Constants.BombExplodeTime;
        bombRange = this.player.getBombRange();

        // TODO: Set initial coundown parameters properly

    }
    TimerTask explosionTask = new TimerTask() {
        public void run() {
            //Her må alt som skal skje når bomben eksploderer skrives. Bildet skal vel vises i view?
            //Spiller må få mindre health, blocks må forsvinne hvis de er destructable og spiller
            // må få igjen bomben.
            //en tile er 32x32 pixler. Hvordan regne ut rangen?
            if (destructibleBlock.getPosition().x + 32 < (getPosition().x + player.getBombRange()) && destructibleBlock.getPosition().y < (getPosition().y + player.getBombRange())) {
                destructibleBlock.handleHitByBomb(); //sjekker om destructibleblokk er innenfor rangen. Hvis den er det utløses handlehitbybomb
            }
            if (wallBlock.getPosition().x + 32 < (getPosition().x + player.getBombRange()) && wallBlock.getPosition().y < (getPosition().y + player.getBombRange())) {
                wallBlock.handleHitByBomb(); //sjekker om den harde blokken er innenfor rangen. Hvis den er det utløses handlehitbybomb
            }
            if ((player.getPosition().x  + 32 < getPosition().x + player.getBombRange()) && (player.getPosition().y < getPosition().y + player.getBombRange())) {
                player.health -= 1; //Hvis spilleren er innenfor rangen skal spilleren miste health
            }

        }
    };
    //When explosion is done, hvordan få flammen til å forsvinne?
    TimerTask explosionDone = new TimerTask() {
        @Override
        public void run() {

        }
    };
    public void update(float timestep) {
        // TODO: Implement timestep update for bomb! This means update countdown for each delta
        // Når bomben slippes (space presses i controller), fireball vises i "loadingtime" sek,
        // etter det skal eksplosjonen skje, som vil ødelegge blocks og skade motstanderene i nærheten
        timer = new Timer();
        timer.schedule(explosionTask, (long) (timestep*1000)); //after 2.5 seconds
    }

    @Override
    public void setPosition(Vector2 pos) {
        pos = player.getPosition();
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
