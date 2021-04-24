package com.dragons.game.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.controller.gameWorld.GameObject;
import com.dragons.game.controller.gameWorld.GameWorld;
import com.dragons.game.view.componentViews.LifeDisplayView;

import java.util.List;

/**
 * This class encapsulate the rendering of the GameWorld
 */
public class GameRenderer {

    private final GameWorld gameWorld;

    public GameRenderer(GameWorld world) {
        this.gameWorld = world;
    }

    public void render(SpriteBatch batch){
        // Renders the dynamic objects in the GameWorld
        List<GameObject> dynamicGameObjects = gameWorld.getDynamicGameObjects();
        for (GameObject object : dynamicGameObjects){
            if (object.getModelView() != null){
                object.getModelView().render(batch);
            }
        }
        // Renders the static objects in the GameWorld
        List<GameObject> staticGameObjects = gameWorld.getStaticGameObjects();
        for (GameObject object : staticGameObjects){
            if (object.getModelView() != null){
                object.getModelView().render(batch);
            }
        }

        // Renders the input handler which includes buttons and joysticks
        gameWorld.getInputHandler().render(batch);

        // Renders the hearts which represent the lives of each player
        for (LifeDisplayView life : gameWorld.getLifeDisplay()){
            life.render(batch);
        }
    }


}
