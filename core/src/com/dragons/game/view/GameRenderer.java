package com.dragons.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.dragons.game.model.gameWorld.GameObject;
import com.dragons.game.model.gameWorld.GameWorld;
import com.dragons.game.utilities.AssetLoader;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import java.util.ArrayList;

public class GameRenderer {

    private GameWorld gameWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private AnnotationAssetManager manager;

    // Asset loading: https://github.com/libgdx/libgdx/wiki/Managing-your-assets
    // https://www.codinginsights.blog/libgdx-assetmanager/

    public GameRenderer(GameWorld world, AnnotationAssetManager manager, OrthographicCamera cam) {
        this.gameWorld = world;
        this.manager = manager;
        this.cam = cam;
        this.shapeRenderer = new ShapeRenderer();
        this.shapeRenderer.setProjectionMatrix(cam.combined);
        loadAssets();
    }

    // TODO: kanskje slå sammen disse til bare en for-løkke feks den under (eller slå sammen listene til en?)
    /*for (GameObject obj : gameWorld.getAllObjects) {
        if (obj.getModelView() == null) {
            // Do nothing
        } else {
            obj.getModelView().render(sb);
        }
    }*/

    public void render(SpriteBatch sb){
        ArrayList<GameObject> list = gameWorld.getGameObjects();
        for (GameObject obj : list) {
            if (obj.getModelView() == null) {
                // Do nothing
            } else {
                obj.getModelView().render(sb);
            }
        }

        for (GameObject player : gameWorld.getPlayers()) {
            if (player.getModelView() == null) {
                // Do nothing
            } else {
                player.getModelView().render(sb);
            }
        }

        for (GameObject fire : gameWorld.getFires()) {
            if (fire.getModelView() == null) {
                // Do nothing
            } else {
                fire.getModelView().render(sb);
            }
        }
    }

    private void loadAssets() {
        Gdx.app.log("Asset loader", "Loading assets");
        manager.load(AssetLoader.class);
        manager.finishLoading();
        Gdx.app.log("Asset loader", "Loading assets finished");
    }
    }
