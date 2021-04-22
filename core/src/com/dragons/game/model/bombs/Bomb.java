package com.dragons.game.model.bombs;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.Model;
import com.dragons.game.model.blocks.DestructibleBlock;
import com.dragons.game.model.blocks.WallBlock;
import com.dragons.game.model.bombs.fires.IFire;
import com.dragons.game.model.maps.GameMap;
import com.dragons.game.model.modelFactories.FireFactory;
import com.dragons.game.utilities.Constants;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Bomb extends Model implements IBomb {

    private float explodeTime;
    private int bombRange;
    protected boolean bombExploded = false;
    private final BombType type;
    protected IFire fire;

    public Bomb(Vector2 pos, float width, float height, int bombRange, final BombType type, boolean isStatic, boolean isSensor){
        super(pos, width, height, isStatic, isSensor);
        this.bombRange = bombRange;
        this.type = type;
        this.explodeTime = Constants.DefaultBombExplodeTime;
        fire = (IFire) FireFactory.getInstance().createFire(pos, type, width, height);
    }

    @Override
    public void update(float timestep){
        explodeTime -= timestep;
        if (explodeTime < 0) {
            bombExploded = true;
        }
    }


    @Override
    public BombType getType() {
        return type;
    }

    @Override
    public boolean isExploded() {
        return bombExploded;
    }

    @Override
    public void increaseRange(int amount){
        bombRange += amount;
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
        if (direction.equals("up") || direction.equals("right")) {
            increment = 1;
        } else if (direction.equals("down") || direction.equals("left")) {
            increment = -1;
        } else {
            increment = 0;
        }

        // Checks how many tiles the fire should expand to
        for (int i = 0; i < bombRange; i++) {
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

    public float getExplodeTime(){
        return explodeTime;
    }

    @Override
    public IFire getFire() {
        return fire;
    }

    protected void setExplodeTime(float explodeTime) {
        this.explodeTime = explodeTime;
    }
}
