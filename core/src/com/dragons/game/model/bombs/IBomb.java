package com.dragons.game.model.bombs;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.gameWorld.GameMap;

import java.util.ArrayList;

public interface IBomb extends IModel {

    public boolean isExploded();
    public ArrayList<Vector2> getFireTiles(GameMap gameMap);

}
