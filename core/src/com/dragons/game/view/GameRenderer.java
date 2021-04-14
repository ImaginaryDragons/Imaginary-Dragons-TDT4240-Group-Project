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
    private ShapeRenderer shapeRenderer;
    private AnnotationAssetManager manager;

    // Asset loading: https://github.com/libgdx/libgdx/wiki/Managing-your-assets
    // https://www.codinginsights.blog/libgdx-assetmanager/

    public GameRenderer(GameWorld world, AnnotationAssetManager manager, OrthographicCamera cam) {
        this.gameWorld = world;
        this.manager = manager;
        //this.shapeRenderer = new ShapeRenderer();
        //this.shapeRenderer.setProjectionMatrix(cam.combined);
        loadAssets();
    }


    public void render(SpriteBatch batch){
        gameWorld.render(batch);


    }

    private void loadAssets() {
        Gdx.app.log("Asset loader", "Loading assets");
        manager.load(AssetLoader.class);
        manager.finishLoading();
        Gdx.app.log("Asset loader", "Loading assets finished");
    }
    }
