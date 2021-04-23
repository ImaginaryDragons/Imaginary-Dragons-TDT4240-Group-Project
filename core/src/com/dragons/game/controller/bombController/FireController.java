package com.dragons.game.controller.bombController;

import com.dragons.game.controller.IGameObjectController;
import com.dragons.game.controller.gameWorld.GameObject;
import com.dragons.game.controller.gameWorld.GameWorld;
import com.dragons.game.model.bombs.fires.IFire;

public class FireController implements IGameObjectController {

    private GameObject fireObject;
    public boolean removeController;
    private IFire fire;

    public FireController(GameObject fireObject) {
        this.fireObject = fireObject;
        this.fire = (IFire) fireObject.getModel();
        this.removeController = false;
    }

    @Override
    public void controllerAction(GameWorld gameWorld) {
        if (fire.isExpired()){
            fireObject.getModel().dispose();
            removeController = true;
        }
    }

    @Override
    public boolean remove() {
        return removeController;
    }
}
