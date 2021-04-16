package com.dragons.game.model.bombs;

import com.badlogic.gdx.math.Vector2;

import com.dragons.game.model.IModel;
import com.dragons.game.model.Model;
import com.dragons.game.model.blocks.DestructibleBlock;
import com.dragons.game.model.blocks.WallBlock;
import com.dragons.game.model.gameWorld.GameMap;
import com.dragons.game.utilities.Constants;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class NormalBomb extends Model implements IBomb {

    private float loadingTime;
    private boolean bombExploded;
    private float bombRange;
    private static final boolean isStatic = false;
    private static final boolean isSensor = false;


    public NormalBomb(Vector2 pos, float width, float height, float bombRange){
        super(pos, width, height, isStatic, isSensor);
        this.bombRange = bombRange;
        this.bombExploded = false;
        loadingTime = Constants.BombExplodeTime;
    }

    @Override
    public void update(float timestep){
        loadingTime -= timestep;
        if (loadingTime < 0) {
            this.bombExploded = true;
        }
    }


    public boolean isExploded() {
        return bombExploded;
    }

    @Override
    public ArrayList<Vector2> getFireTiles(GameMap gameMap) {
        ArrayList<Vector2> fireTiles = new ArrayList<Vector2>();
        fireTiles.addAll(checkForWall("up", gameMap));
        fireTiles.addAll(checkForWall("down", gameMap));
        fireTiles.addAll(checkForWall("left", gameMap));
        fireTiles.addAll(checkForWall("right", gameMap));
        fireTiles.add(gameMap.tilePosCenter(gameMap.pos2tile(super.getPosition())));
        System.out.println(fireTiles.toString());
        return fireTiles;
    }

    private ArrayList<Vector2> checkForWall(String direction, GameMap gameMap) {
        Vector2 checkTile = new Vector2(0, 0);
        ArrayList<Vector2> fireTiles = new ArrayList<Vector2>();
        int startPos;
        int increment;
        switch (direction) {
            case "up":
                startPos = (int) super.getPosition().y;
                checkTile.x = (int) super.getPosition().x;
                increment = 32;
                break;
            case "down":
                startPos = (int) super.getPosition().y;
                checkTile.x = (int) super.getPosition().x;
                increment = -32;
                break;
            case "left":
                startPos = (int) super.getPosition().x;
                checkTile.y = (int) super.getPosition().y;
                increment = -32;
                break;
            case "right":
                startPos = (int) super.getPosition().x;
                checkTile.y = (int) super.getPosition().y;
                increment = 32;
                break;
            default:
                startPos = 0;
                increment = 0;
        }

        System.out.println("Ready to check for wall");

        for (int i = 0; i < bombRange; i++) {
            if (direction == "up" || direction == "down") {
                checkTile.y = startPos + increment;
            } else if (direction == "left" || direction == "right") {
                checkTile.x = startPos + increment;
            }
            Vector2 tile = gameMap.pos2tile(checkTile);
            System.out.println(tile.toString());
            ArrayList<IModel> tileContainer = gameMap.tileContainers.get((int)tile.x, (int)tile.y);
            if (tileContainer == null){
                System.out.println("Breaking stuff here");
                break;
            }
            if (tileContainer.isEmpty()) {
                System.out.println("Is empty here");
                break;
            }

            System.out.println("Checking stuff here");
            boolean stopExpanding = false;
            boolean addCurrentTile = true;
            for (IModel obj : tileContainer) {

                if (obj instanceof WallBlock) {
                    stopExpanding = true;
                    addCurrentTile = false;
                }
                else if(obj instanceof DestructibleBlock) {
                    stopExpanding = true;
                    addCurrentTile = true;
                } else {
                    // Do nothing??
                }
            }

            if (addCurrentTile == true) {
                System.out.println("Tile added");
                fireTiles.add(tile);
            }

            if (stopExpanding == true) {
                // TODO: Check that this has the desired behavior
                System.out.println("Is the loop cut off entirely??");
                break;
            }

            /*
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

             */

        }
        return fireTiles;
    }
}
