package com.dragons.game.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.IObject;
import com.dragons.game.model.PowerUps.PowerUpType;
import com.dragons.game.model.factories.PowerUpFactory;
import com.dragons.game.model.gameWorld.GameMap;
import com.dragons.game.model.gameWorld.GameWorld;
import com.dragons.game.view.GameRenderer;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import java.io.IOException;

import static com.dragons.game.utilities.Constants.PPM;

public class GameScreen extends ScreenAdapter {

    private GameWorld gameWorld;
    private GameRenderer gameRenderer;
    private AnnotationAssetManager manager;
    private GameMap gameMap;
    private SpriteBatch sb;

    private OrthographicCamera camera;
    private OrthographicCamera sbcamera;
    private TiledMapRenderer tiledMapRenderer;
    private World b2dWorld;
    private Box2DDebugRenderer b2dr;
    private OrthographicCamera b2drCam;

    // TODO: Integrating the gameWorld onto the firebase server
    /*Right now the gameWorld is statically defined within our gamescreen. However, we need
    * some way of ensuring that the main gameworld is on our server and that this version is
    * primarily loaded from the server and then continuously updated. How this should be done is
    * not clear!
    * */

    public GameScreen() throws IOException {
        //super();
        Gdx.app.log("GameScreen", "Attached");

        gameMap = new GameMap("TileMapMobile.tmx");
        b2dWorld = new World(new Vector2(0,0), true); // Initialize Box2D World. Set Gravity 0 and 'not simulate inactive objects' true
        gameWorld = new GameWorld(b2dWorld, gameMap);
        manager = new AnnotationAssetManager();
        sb = new SpriteBatch();

        //TODO: Change viewPortWidth and height to variables
        camera = new OrthographicCamera(480.f, 350.f);
        camera.position.x = gameMap.getMapWidthInPixels() * .50f;
        camera.position.y = gameMap.getMapHeightInPixels() * .50f;
        camera.update();
        gameRenderer = new GameRenderer(gameWorld, manager, camera); // Initialize world renderer

        /**
         * Not good but debugRenderer is only a tool on not in the final implementation
         */
        //TODO: Change viewPortWidth and height to variables
        b2drCam = new OrthographicCamera(480.f, 350.f);
        b2drCam.position.x = (gameMap.getMapWidthInPixels()) * .50f;
        b2drCam.position.y = (gameMap.getMapHeightInPixels()) * .50f;
        b2drCam.update();
        b2dr = new Box2DDebugRenderer();
        tiledMapRenderer = new OrthogonalTiledMapRenderer(gameMap.getTiledMap());
        tiledMapRenderer.setView(camera);

        sbcamera = new OrthographicCamera(480.f, 350.f);
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        sbcamera.setToOrtho(false, w, h);
        sbcamera.position.x = gameMap.getMapWidthInPixels() * 0.5f;
        sbcamera.position.y = gameMap.getMapHeightInPixels() * 0.5f;
        sbcamera.update();
        sb.setProjectionMatrix(sbcamera.combined);

        // TODO: Create functionality for spawning game world
        gameMap.generateBlocks(0, "map.txt");
        gameWorld.generateMapBlocks();
        gameWorld.initializePlayers(manager);


    }

    @Override
    public void render(float delta) {

        //Gdx.app.log("GameScreen", "Rendering");
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        tiledMapRenderer.render();
        // Update game world
        gameWorld.update(delta);
        // Render screen
        sb.begin();
        gameRenderer.render(sb);
        sb.end();

        b2dr.render(b2dWorld, b2drCam.combined);
        //Gdx.app.log("GameScreen FPS", (1/delta) + "");
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

}
