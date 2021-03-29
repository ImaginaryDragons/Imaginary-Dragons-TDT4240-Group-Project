package com.dragons.game.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.dragons.game.components.Tiled;
import com.dragons.game.model.GameWorld.GameWorld;
import com.dragons.game.view.GameRenderer;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

public class GameScreen extends ScreenAdapter {

    private GameWorld gameWorld;
    private GameRenderer gameRenderer;
    private AnnotationAssetManager manager;
    private Tiled tileRenderer;

    private int tileWidth, tileHeight,
            mapWidthInTiles, mapHeightInTiles,
            mapWidthInPixels, mapHeightInPixels;

    TiledMap tiledMap;
    OrthographicCamera camera;
    TiledMapRenderer tiledMapRenderer;

    // TODO: Integrating the gameWorld onto the firebase server
    /*Right now the gameWorld is statically defined within our gamescreen. However, we need
    * some way of ensuring that the main gameworld is on our server and that this version is
    * primarily loaded from the server and then continuously updated. How this should be done is
    * not clear!
    * */

    public GameScreen() {
        //super();
        Gdx.app.log("GameScreen", "Attached");

        //float screenWidth = Gdx.graphics.getWidth();
        //float screenHeight = Gdx.graphics.getHeight();
        //float gameWidth = 136;

        gameWorld = new GameWorld();
        manager = new AnnotationAssetManager();
        //gameRenderer = new GameRenderer(gameWorld, manager); // Initialize world renderer
        tiledMap = new TmxMapLoader().load("TileMapMobile.tmx");

        MapProperties properties = tiledMap.getProperties();
        tileWidth         = properties.get("tilewidth", Integer.class);
        tileHeight        = properties.get("tileheight", Integer.class);
        mapWidthInTiles   = properties.get("width", Integer.class);
        mapHeightInTiles  = properties.get("height", Integer.class);
        mapWidthInPixels  = mapWidthInTiles  * tileWidth;
        mapHeightInPixels = mapHeightInTiles * tileHeight;
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        //camera = new OrthographicCamera();
        //camera.setToOrtho(false,w,h);
        //camera.update();

        camera = new OrthographicCamera(480.f, 350.f);
        camera.position.x = mapWidthInPixels * .50f;
        camera.position.y = mapHeightInPixels * .50f;
        camera.update();

        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        // TODO: Create functionality for spawning game world
    }

    @Override
    public void render(float delta) {
        Gdx.app.log("GameScreen", "Rendering");

        // Update game world
        gameWorld.update(delta);
        // Render screen
        // gameRenderer.render();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        Gdx.app.log("GameScreen FPS", (1/delta) + "");
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
        super.resize(width, height);
    }

    // TODO: At some point we want to remove all the override methods we haven't used!!
    // For now I'll leave them her so we can log whenever one is called for research purposes.

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");

        // Load all assets the game screen will use
        /* TODO: Add file paths so that we can load our assets!
        gameRenderer.loadAssets();
        while(!manager.update()) {
            float progress = manager.getProgress();
            System.out.println("Loading ... " + progress * 100 + "%");
        }
        To get an asset, use manager.get(AssetDescriptors.ASSET_YOU_WANT)
         */
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

}
