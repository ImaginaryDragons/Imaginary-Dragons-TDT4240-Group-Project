package com.dragons.game.controller;

import com.dragons.game.controller.gameWorld.GameWorld;

public interface IGameObjectController {

    void controllerAction(GameWorld gameWorld);

    boolean remove();

}
