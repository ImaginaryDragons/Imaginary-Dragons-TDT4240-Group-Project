package com.dragons.game.model.bomb;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Shape;
import com.dragons.game.model.IModelType;
import com.dragons.game.model.IObject;
import com.dragons.game.model.gameWorld.GameMap;
import com.dragons.game.model.player.Player;
import com.dragons.game.utilities.Constants;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Bomb implements IObject {

    private Vector2 position;
    // TODO: FIX SHAPE (private Circle circleBounds;)
    private Timer timer;
    private float loadingTime;
    private TimerTask task;
    private float timeLeft = 0;
    public boolean bombExploded;
    private float bombRange;
    private Player player;
    private int tileHeight;
    private int tileWidth;
    private ArrayList<Vector2> fireTiles;
    private GameMap gameMap;

    //public static List<BombComponent> bombs = new ArrayList<BombComponent>(); // liste med antall bomber en spiller har, skal heller være i player

    public Bomb(Vector2 pos, float radius, TimerTask task, Player player){ // Ta inn noe tiles?
        this.position = pos;
        this.task = task;
        this.player = player;
        //this.circleBounds.set(pos, radius); TODO: FIX THIS
        bombExploded = false;
        loadingTime = Constants.BombExplodeTime;
        bombRange = this.player.getBombRange();
        //tileHeight = GameScreen.tileHeight;
        //tileWidth = GameScreen.tileWidth;



        // TODO: Set initial coundown parameters properly

    }

    public ArrayList<Vector2> checkForWall(String direction) {
        Vector2 checkTile = new Vector2(0, 0);
        ArrayList<Vector2> fireTiles = new ArrayList<Vector2>();
        int startPos;
        int increment;
        switch (direction) {
            case "up":
                startPos = (int) player.getPosition().y;
                checkTile.x = (int) player.getPosition().x;
                increment = 32;
                break;
            case "down":
                startPos = (int) player.getPosition().y;
                checkTile.x = (int) player.getPosition().x;
                increment = -32;
                break;
            case "left":
                startPos = (int) player.getPosition().x;
                checkTile.y = (int) player.getPosition().y;
                increment = -32;
                break;
            case "right":
                startPos = (int) player.getPosition().x;
                checkTile.y = (int) player.getPosition().y;
                increment = 32;
                break;
            default:
                startPos = 0;
                increment = 0;
        }

        for (int i = 0; i < player.getBombRange(); i += 32) {
            if (direction == "up" || direction == "down") {
                checkTile.y = startPos + increment;
            } else if (direction == "left" || direction == "right") {
                checkTile.x = startPos + increment;
            }
            Vector2 tile = gameMap.pos2tile(checkTile);
            Vector2 tileStart = gameMap.tilePos(tile);
            if (gameMap.tileContainers.get(tile.x, tile.y).contains("desblock")) {
                //denne tilen skal bli lik et bilde, starter i tilestart, 32x32, og så stoppe
                //Sjekke kontakt, Eldar og Jakob skal se på det
                fireTiles.add(tile);

            } else if (gameMap.tileContainers.get(tile.x, tile.y).contains("wallblock")) {
                //denne tilen skal ikke bli lik et bilde
                //Sjekke kontakt, Eldar og Jakob skal se på det

            } else if (gameMap.tileContainers.get(tile.x, tile.y).contains("desPowerupBlock")) {
                //denne tilen skal bli til en powerup
                //Sjekke kontakt, Eldar og Jakob skal se på det
                fireTiles.add(tile);
            } else {
                //Bli lik et bilde, sjekke videre
                fireTiles.add(tile);
            }

        }
        return fireTiles;
    }

    public void update(float timestep){
            // TODO: Implement timestep update for bomb! This means update countdown for each delta
            // Når bomben slippes (space presses i controller), fireball vises i "loadingtime" sek,
            // etter det skal eksplosjonen skje, som vil ødelegge blocks og skade motstanderene i nærheten
            /*
            timer = new Timer();
            timer.schedule(explosionTask, (long) (timestep * 1000)); //after 2.5 seconds
            timer.schedule(explosionDone, (long) (4000)); //etter 4 sek er bomben borte (den vises i 1,5 sek)
    */

            loadingTime -= timestep;
            if (loadingTime < 0) {
                checkForWall("up");
                checkForWall("down");
                checkForWall("left");
                checkForWall("right");
            }
        }

    @Override
    public void setPosition(Vector2 pos) {
        pos = player.getPosition();
        this.position = pos;
        //this.circleBounds.setPosition(pos.x, pos.y); TODO: FIX
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }


    @Override
    public Shape getShape() {
        // TODO: FIX THIS
        return null;
    }

    @Override
    public IModelType getType() {
        return null;
    }

    @Override
    public boolean isStatic() {
        return false;
    }

    @Override
    public boolean isSensor() {
        return false;
    }
}
