package com.dragons.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.dragons.game.model.Model;
import com.dragons.game.model.gameWorld.GameObject;
import com.dragons.game.model.gameWorld.GameWorld;
import com.dragons.game.utilities.AssetLoader;
import com.dragons.game.view.modelViews.DestructibleBlockView;
import com.dragons.game.view.modelViews.ModelView;

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

    public void render(SpriteBatch sb){
        /*
        for (GameObject obj : gameWorld.getGameObjects()) {
            ModelView view = obj.getModelView();
            if (view == null) {
                Gdx.app.log("GameRenderer", "render");
                break;
=======
    public void render(SpriteBatch sb) {
        ArrayList<GameObject> list = gameWorld.getGameObjects();
        for (GameObject obj : list) {
            if (obj.getModelView() == null) {
                // Do nothing
>>>>>>> 1fe4bd8fd5c25b6cd7b8bd03fafabce1ca53bef1
            } else {
                obj.getModelView().render(sb);
            }
        }
<<<<<<< HEAD
        */
        for(GameObject player : gameWorld.getPlayers()) {
            ModelView view = player.getModelView();
            view.render(sb);
            }
        }

        private void loadAssets() {
            Gdx.app.log("Asset loader", "Loading assets");
            manager.load(AssetLoader.class);
            manager.finishLoading();
            Gdx.app.log("Asset loader", "Loading assets finished");
        }
    }
