
package com.dragons.game.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.dragons.game.controller.gameWorld.GameWorld;
import com.dragons.game.model.maps.GameMap;
import com.dragons.game.utilities.AssetLoader;
import com.dragons.game.view.GameRenderer;
import com.dragons.game.view.componentViews.TimerView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;


import static com.dragons.game.utilities.Constants.VIEWPORT_HEIGHT;
import static com.dragons.game.utilities.Constants.VIEWPORT_WIDTH;


public class GameScreen extends ScreenAdapter {
    public AssetManager assets;
    private final GameWorld gameWorld;
    private final GameRenderer gameRenderer;
    private final AnnotationAssetManager manager;

    private final SpriteBatch batch;
    private final TiledMapRenderer tiledMapRenderer;

    private final TimerView timerView;



    public GameScreen(AssetManager assets, BitmapFont font, String mapName, String mapTxtFile) {
        Gdx.app.log("GameScreen", "Attached");

        OrthographicCamera camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        GameMap gameMap = new GameMap(mapName);
        manager = new AnnotationAssetManager();
        loadAssets();

        gameWorld = new GameWorld(gameMap, manager, camera);
        batch = new SpriteBatch();

        camera.position.set(gameMap.getMapWidthInPixels() / 2f, gameMap.getMapHeightInPixels() / 2f, 0);
        camera.update();

        gameRenderer = new GameRenderer(gameWorld, manager); // Initialize world renderer

        tiledMapRenderer = new OrthogonalTiledMapRenderer(gameMap.getTiledMap());
        tiledMapRenderer.setView(camera);

        batch.setProjectionMatrix(camera.combined);

        timerView = new TimerView(assets, camera, font);
      
        gameMap.generateBlocks(mapTxtFile);
        gameWorld.generateMapBlocks();
        gameWorld.initializePlayers();


    }



    @Override
    public void render(float delta) {

        //Gdx.app.log("GameScreen", "Rendering");
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Render map
        tiledMapRenderer.render();

        // Render game objects
        batch.begin();
        gameRenderer.render(batch);
        batch.end();

        // Update game world
        gameWorld.update(delta);
        timerView.update(delta);

        //Gdx.app.log("GameScreen FPS", (1/delta) + "");

        timerView.stage.draw();

        if (timerView.isTimeUp()) {
            ScreenManager.getInstance().setGameOverScreen(timerView.getScoreCount());
        }

        if(gameWorld.getDeathDetector().isDead()){
            ScreenManager.getInstance().setGameOverScreen(timerView.getScoreCount());
        }
    }


    private void loadAssets() {
        Gdx.app.log("Asset loader", "Loading assets");
        manager.load(AssetLoader.class);
        manager.finishLoading();
        Gdx.app.log("Asset loader", "Loading assets finished");
    }

}
