package com.dragons.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.dragons.game.model.IObject;
import com.dragons.game.model.gameWorld.GameObject;
import com.dragons.game.model.gameWorld.GameWorld;
import com.dragons.game.utilities.AssetLoader;
import com.dragons.game.view.modelViews.ModelView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

public class GameRenderer {

    private GameWorld gameWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch spriteBatch;
    private AnnotationAssetManager manager;

    // Asset loading: https://github.com/libgdx/libgdx/wiki/Managing-your-assets
    // https://www.codinginsights.blog/libgdx-assetmanager/

    public GameRenderer(GameWorld world, AnnotationAssetManager manager, OrthographicCamera cam) {
        this.gameWorld = world;
        this.manager = manager;
        this.cam = cam;
        this.shapeRenderer = new ShapeRenderer();
        this.shapeRenderer.setProjectionMatrix(cam.combined);
        this.spriteBatch = new SpriteBatch();
        this.spriteBatch.setProjectionMatrix(cam.combined);
        loadAssets();
    }

    public void render() {
        Gdx.app.log("GameRenderer", "render");
        for (GameObject obj : gameWorld.getGameObjects()) {
            ModelView view = obj.getModelView();
            if (view == null) {
                break;
            } else {
                obj.getModelView().render();
            }
        }
    }

    private void loadAssets(){
        manager.load(AssetLoader.class);
        manager.finishLoading();
    }
}
