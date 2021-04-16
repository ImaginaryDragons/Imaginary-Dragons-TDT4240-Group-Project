package com.dragons.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.gameWorld.GameObject;
import com.dragons.game.model.gameWorld.GameWorld;
import com.dragons.game.playerController.Joystick;
import com.dragons.game.playerController.PlayerController;
import com.dragons.game.utilities.AssetLoader;

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
        gameWorld.getPlayerController().render(batch);
    }

    private void loadAssets() {
        Gdx.app.log("Asset loader", "Loading assets");
        manager.load(AssetLoader.class);
        manager.finishLoading();
        Gdx.app.log("Asset loader", "Loading assets finished");
    }
}
