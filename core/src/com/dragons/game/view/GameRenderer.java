package com.dragons.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.controller.gameWorld.GameObject;
import com.dragons.game.controller.gameWorld.GameWorld;
import com.dragons.game.utilities.AssetLoader;
import com.dragons.game.view.componentViews.LifeDisplayView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import java.util.ArrayList;

public class GameRenderer {

    private GameWorld gameWorld;
    private AnnotationAssetManager manager;

    // Asset loading: https://github.com/libgdx/libgdx/wiki/Managing-your-assets
    // https://www.codinginsights.blog/libgdx-assetmanager/

    public GameRenderer(GameWorld world, AnnotationAssetManager manager) {
        this.gameWorld = world;
        this.manager = manager;
        loadAssets();
    }

    public void render(SpriteBatch batch){
        ArrayList<GameObject> dynamicGameObjects = gameWorld.getDynamicGameObjects();
        for (GameObject object : dynamicGameObjects){
            if (object.getModelView() != null){
                object.getModelView().render(batch);
            }
        }
        ArrayList<GameObject> staticGameObjects = gameWorld.getStaticGameObjects();
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

    private void loadAssets() {
        Gdx.app.log("Asset loader", "Loading assets");
        manager.load(AssetLoader.class);
        manager.finishLoading();
        Gdx.app.log("Asset loader", "Loading assets finished");
    }
}
