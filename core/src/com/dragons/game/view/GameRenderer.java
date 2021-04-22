package com.dragons.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.controller.gameWorld.GameObject;
import com.dragons.game.controller.gameWorld.GameWorld;
import com.dragons.game.utilities.AssetLoader;
import com.dragons.game.view.componentViews.LifeDisplayView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import java.util.ArrayList;
import java.util.LinkedList;

public class GameRenderer {

    private GameWorld gameWorld;
    private AnnotationAssetManager manager;

    // Asset loading: https://github.com/libgdx/libgdx/wiki/Managing-your-assets
    // https://www.codinginsights.blog/libgdx-assetmanager/

    public GameRenderer(GameWorld world, AnnotationAssetManager manager) {
        this.gameWorld = world;
        this.manager = manager;
    }

    public void render(SpriteBatch batch){
        LinkedList<GameObject> dynamicGameObjects = gameWorld.getDynamicGameObjects();
        for (GameObject object : dynamicGameObjects){
            if (object.getModelView() != null){
                object.getModelView().render(batch);
            }
        }
        LinkedList<GameObject> staticGameObjects = gameWorld.getStaticGameObjects();
        for (GameObject object : staticGameObjects){
            if (object.getModelView() != null){
                object.getModelView().render(batch);
            }
        }
//        gameWorld.getPlayerController1().render(batch);
//        gameWorld.getPlayerController2().render(batch);
        gameWorld.getInputHandler().render(batch);

        for (LifeDisplayView life : gameWorld.getLifeDisplay()){
            life.render(batch);
        }
    }


}
