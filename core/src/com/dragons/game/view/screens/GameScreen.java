
package com.dragons.game.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.DragonsGame;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.controller.gameWorld.GameWorld;
import com.dragons.game.model.maps.GameMap;
import com.dragons.game.utilities.AssetLoader;
import com.dragons.game.view.GameRenderer;
import com.dragons.game.view.componentViews.TimerView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import java.io.IOException;

import static com.dragons.game.utilities.Constants.VIEWPORT_HEIGHT;
import static com.dragons.game.utilities.Constants.VIEWPORT_WIDTH;


public class GameScreen extends ScreenAdapter {
    public AssetManager assets;
    private final DragonsGame dragonsGame;
    private final GameWorld gameWorld;
    private final GameRenderer gameRenderer;
    private final AnnotationAssetManager manager;
    private OrthographicCamera camera;

    private final GameMap gameMap;
    private final SpriteBatch batch;
    private final TiledMapRenderer tiledMapRenderer;

    private TimerView timerView;

    // TODO: Integrating the gameWorld onto the firebase server
    /*Right now the gameWorld is statically defined within our gamescreen. However, we need
     * some way of ensuring that the main gameworld is on our server and that this version is
     * primarily loaded from the server and then continuously updated. How this should be done is
     * not clear!
     * */


    public GameScreen(DragonsGame dragonsGame) throws IOException {
        this.dragonsGame = dragonsGame;
        //super();
        Gdx.app.log("GameScreen", "Attached");

        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        gameMap = new GameMap("TileMapMobile.tmx");
        manager = new AnnotationAssetManager();
        loadAssets();

        gameWorld = new GameWorld(gameMap, manager, camera, dragonsGame);
        batch = new SpriteBatch();

        camera.position.set(gameMap.getMapWidthInPixels() / 2f, gameMap.getMapHeightInPixels() / 2f, 0);
        camera.update();

        gameRenderer = new GameRenderer(gameWorld, manager); // Initialize world renderer

        tiledMapRenderer = new OrthogonalTiledMapRenderer(gameMap.getTiledMap());
        tiledMapRenderer.setView(camera);

        batch.setProjectionMatrix(camera.combined);

        timerView = new TimerView(dragonsGame.assets, camera);
      
        gameMap.generateBlocks( "map.txt");
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
            dragonsGame.setScreen(new GameOverScreen(dragonsGame, timerView.getScoreCount()));
        }
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
        super.resize(width, height);
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
        super.show();
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
        super.hide();
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
        super.pause();
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    private void loadAssets() {
        Gdx.app.log("Asset loader", "Loading assets");
        manager.load(AssetLoader.class);
        manager.finishLoading();
        Gdx.app.log("Asset loader", "Loading assets finished");
    }

}
