package com.dragons.game.model.bombs;

import com.badlogic.gdx.math.Vector2;

import com.dragons.game.model.IModel;
import com.dragons.game.model.Model;
import com.dragons.game.model.blocks.DestructibleBlock;
import com.dragons.game.model.blocks.WallBlock;
import com.dragons.game.model.maps.GameMap;
import com.dragons.game.utilities.Constants;

import java.util.ArrayList;
import java.util.Iterator;


public class NormalBomb extends Model implements IBomb {

    private float loadingTime;
    private final int bombRange;
    private boolean bombExploded = false;
    private static final boolean isStatic = true;
    private static final boolean isSensor = true;


    public NormalBomb(Vector2 pos, float width, float height, int bombRange){
        super(pos, width, height, isStatic, isSensor);
        this.bombRange = bombRange;
        loadingTime = Constants.BombExplodeTime;
    }

    @Override
    public void update(float timestep){
        loadingTime -= timestep;
        if (loadingTime < 0) {
            bombExploded = true;
        }
    }

    @Override
    public void hitByFire(){
        bombExploded = true;
    }

    @Override
    public boolean isExploded() {
        return bombExploded;
    }

    @Override
    // Return which tiles we want to add fires to
    public ArrayList<Vector2> getFireTiles(GameMap gameMap) {
        ArrayList<Vector2> fireTiles = new ArrayList<Vector2>();
        fireTiles.addAll(addFireInDirection("up", gameMap));
        fireTiles.addAll(addFireInDirection("down", gameMap));
        fireTiles.addAll(addFireInDirection("left", gameMap));
        fireTiles.addAll(addFireInDirection("right", gameMap));
        fireTiles.add(gameMap.tilePosCenter(gameMap.pos2tile(super.getPosition())));
        return fireTiles;
    }

    // Returns the tiles we want fire to in a given direction
    private ArrayList<Vector2> addFireInDirection(String direction, GameMap gameMap) {
        Vector2 checkTile = gameMap.pos2tile(super.getPosition());
        ArrayList<Vector2> fireTiles = new ArrayList<Vector2>();

        int increment;
        if (direction == "up" || direction == "right") {
            increment = 1;
        } else if (direction == "down" || direction == "left") {
            increment = -1;
        } else {
            increment = 0;
        }

        // Checks how many tiles the fire should expand to
        for (int i = 0; i < bombRange; i++) {
            if (direction == "up" || direction == "down") {
                checkTile.y += increment;
            } else if (direction == "left" || direction == "right") {
                checkTile.x += increment;
            }
            ArrayList<IModel> tileContainer = gameMap.getTileContent((int)checkTile.x, (int)checkTile.y);
            if (tileContainer == null){
                // Indicates outside map boundaries. Stop checking in this direction
                break;
            }

            boolean stopExpanding = false;
            boolean addCurrentTile = true;

            Iterator<IModel> it = tileContainer.iterator();
            IModel obj;
            while(it.hasNext()){
                obj = it.next();
                if (obj instanceof WallBlock) {
                    stopExpanding = true;
                    addCurrentTile = false;
                }
                else if(obj instanceof DestructibleBlock) {
                    stopExpanding = true;
                    addCurrentTile = true;
                    it.remove();
                } else {
                    // Do nothing
                }
            }
            if (addCurrentTile == true) {
                fireTiles.add(new Vector2(gameMap.tilePosCenter(checkTile)));
            }
            if (stopExpanding == true) {
                break;
            }
        }

        return fireTiles;
    }
}
