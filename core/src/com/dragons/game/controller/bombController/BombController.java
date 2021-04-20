package com.dragons.game.controller.bombController;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.controller.IGameObjectController;
import com.dragons.game.controller.gameWorld.GameObject;
import com.dragons.game.controller.gameWorld.GameWorld;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.model.bombs.IBomb;

import java.util.ArrayList;

public class BombController implements IGameObjectController {

    private GameObject bombObject;
    private IBomb bomb;
    public boolean removeController;

    public BombController(GameObject bombObject) {
        this.bombObject = bombObject;
        this.bomb = (IBomb) bombObject.getObject();
        this.removeController = false;
    }

    @Override
    public void controllerAction(GameWorld gameWorld) {
        if (bomb.isExploded()) {

            ArrayList<Vector2> fireTiles = bomb.getFireTiles(gameWorld.getMap());
            gameWorld.spawnFire(fireTiles, BombType.NORMALBOMB);

            // Dispose of everything related to this bomb
            bomb = null;
            gameWorld.getDynamicGameObjects().remove(bombObject);
            bombObject.dispose();
            removeController = true;
        }
    }

    @Override
    public boolean remove() {
        return this.removeController;
    }


}