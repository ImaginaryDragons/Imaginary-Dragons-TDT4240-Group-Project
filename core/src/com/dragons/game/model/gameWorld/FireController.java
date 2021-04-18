package com.dragons.game.model.gameWorld;

import com.dragons.game.model.bombs.fires.IFire;

public class FireController implements IGameObjectController{

    private GameObject fireObject;
    public boolean removeController;
    private IFire fire;

    public FireController(GameObject fireObject) {
        this.fireObject = fireObject;
        this.fire = (IFire) fireObject.getObject();
        this.removeController = false;
    }

    @Override
    public void controllerAction(GameWorld gameWorld) {
        if (fire.isExpired()){
            fire = null;
            gameWorld.getStaticGameObjects().remove(fireObject);
            fireObject.dispose();
            removeController = true;
        }
    }

    @Override
    public boolean remove() {
        return removeController;
    }
}
