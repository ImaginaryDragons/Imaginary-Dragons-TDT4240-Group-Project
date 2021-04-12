
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
import com.dragons.game.model.gameWorld.GameMap;
import com.dragons.game.model.gameWorld.GameWorld;
import com.dragons.game.view.GameRenderer;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import java.io.IOException;
import java.util.ArrayList;

import static com.dragons.game.utilities.Constants.PPM;
import static com.dragons.game.utilities.Constants.VIRTUAL_HEIGHT;
import static com.dragons.game.utilities.Constants.VIRTUAL_WIDTH;

public class GameScreen extends ScreenAdapter {

    private GameWorld gameWorld;
    private GameRenderer gameRenderer;
    private AnnotationAssetManager manager;

    public GameMap gameMap;
    private SpriteBatch batch;


    private OrthographicCamera camera;

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
        manager = new AnnotationAssetManager();
        gameWorld = new GameWorld(b2dWorld, gameMap, manager);
        batch = new SpriteBatch();

        //TODO: Change viewPortWidth and height to variables
        camera = new OrthographicCamera(VIRTUAL_WIDTH, VIRTUAL_HEIGHT);
        camera.position.set(gameMap.getMapWidthInPixels() / 2f, gameMap.getMapHeightInPixels() / 2f, 0);
        camera.update();
        gameRenderer = new GameRenderer(gameWorld, manager, camera); // Initialize world renderer

        tiledMapRenderer = new OrthogonalTiledMapRenderer(gameMap.getTiledMap());
        tiledMapRenderer.setView(camera);

        batch.setProjectionMatrix(camera.combined);

        // TODO: Create functionality for spawning game world
        gameMap.generateBlocks(0, "map.txt");
        gameWorld.generateMapBlocks();
        gameWorld.initializePlayers();

        // BOMB TEST!!
        // TODO: get right tile position
        gameWorld.placeBomb(new Vector2(40,300), 2, 2);

        // FIRE TEST
        ArrayList<Vector2> fireTileList = new ArrayList<Vector2>();
        fireTileList.add(gameMap.tilePos(new Vector2(5,5)));
        fireTileList.add(gameMap.tilePos(new Vector2(5,6)));
        gameWorld.spawnFire(fireTileList);

        b2dr = new Box2DDebugRenderer();
        b2drCam = new OrthographicCamera(VIRTUAL_WIDTH / PPM, VIRTUAL_HEIGHT / PPM);
        b2drCam.position.set(gameMap.getMapWidthInPixels() / 2f / PPM, gameMap.getMapHeightInPixels() / 2f / PPM, 0);
        b2drCam.update();




    }

    @Override
    public void render(float delta) {
        //Gdx.app.log("GameScreen", "Rendering");
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Update game world
        gameWorld.update(delta);
        // gameWorld.updatePlayerPositions(); TODO: Implement this so that it always follows its body!

        //Render map
        tiledMapRenderer.render();

        // Render game objects
        batch.begin();
        gameRenderer.render(batch, delta);
        batch.end();

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
