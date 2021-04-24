package com.dragons.game.controller.bombController;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.controller.IGameObjectController;
import com.dragons.game.controller.gameWorld.GameObject;
import com.dragons.game.controller.gameWorld.GameWorld;
import com.dragons.game.model.IModel;
import com.dragons.game.model.blocks.DestructibleBlock;
import com.dragons.game.model.blocks.WallBlock;
import com.dragons.game.model.bombs.Bomb;
import com.dragons.game.model.bombs.IBomb;
import com.dragons.game.model.maps.GameMap;

import java.util.ArrayList;
import java.util.Iterator;

public class BombController implements IGameObjectController {

    private final GameObject bombObject;
    private Bomb bomb;
    public boolean removeController;

    public BombController(GameObject bombObject) {
        this.bombObject = bombObject;
        this.bomb = (Bomb) bombObject.getModel();
        this.removeController = false;
    }

    @Override
    public void controllerAction(GameWorld gameWorld) {
        if (bomb.isExploded()) {

            ArrayList<Vector2> fireTiles = getFireTiles(gameWorld.getMap());
            gameWorld.spawnFire(fireTiles, bomb);

            bombObject.getModel().dispose();
            removeController = true;
        }
    }

    @Override
    public boolean remove() {
        return this.removeController;
    }

    // Return which tiles we want to add fires to
    public ArrayList<Vector2> getFireTiles(GameMap gameMap) {
        ArrayList<Vector2> fireTiles = new ArrayList<Vector2>();
        fireTiles.addAll(addFireInDirection("up", gameMap));
        fireTiles.addAll(addFireInDirection("down", gameMap));
        fireTiles.addAll(addFireInDirection("left", gameMap));
        fireTiles.addAll(addFireInDirection("right", gameMap));
        fireTiles.add(gameMap.tilePosCenter(gameMap.pos2tile(bomb.getPosition())));
        return fireTiles;
    }

    // Returns the tiles we want fire to in IView given direction
    private ArrayList<Vector2> addFireInDirection(String direction, GameMap gameMap) {
        Vector2 checkTile = gameMap.pos2tile(bomb.getPosition());
        ArrayList<Vector2> fireTiles = new ArrayList<Vector2>();

        int increment;
        if (direction.equals("up") || direction.equals("right")) {
            increment = 1;
        } else if (direction.equals("down") || direction.equals("left")) {
            increment = -1;
        } else {
            increment = 0;
        }

        // Checks how many tiles the fire should expand to
        for (int i = 0; i < bomb.getBombRange(); i++) {
            if (direction.equals("up") || direction.equals("down")) {
                checkTile.y += increment;
            } else if (direction.equals("left") || direction.equals("right")) {
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
                }

            }
            if (addCurrentTile) {
                fireTiles.add(new Vector2(gameMap.tilePosCenter(checkTile)));
            }
            if (stopExpanding) {
                break;
            }
        }

        return fireTiles;
    }


}
