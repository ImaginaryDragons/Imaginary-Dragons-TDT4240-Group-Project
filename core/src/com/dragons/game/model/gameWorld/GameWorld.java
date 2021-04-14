package com.dragons.game.model.gameWorld;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.IModel;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.model.factories.BlockFactory;
import com.dragons.game.model.factories.BombFactory;
import com.dragons.game.model.factories.FireFactory;
import com.dragons.game.model.factories.PlayerFactory;
import com.dragons.game.model.factories.PowerUpFactory;
import com.dragons.game.model.players.NormalPlayer;
import com.dragons.game.model.players.PlayerType;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import java.util.ArrayList;

import static com.dragons.game.utilities.Constants.PPM;
import static com.dragons.game.utilities.Constants.VIRTUAL_HEIGHT;
import static com.dragons.game.utilities.Constants.VIRTUAL_WIDTH;

/**
 * The GameWorld class instantiates the world in which a single game will be played. The
 * class itself then works as a container for our game where every time-step is simulated with
 * the proper actions and interactions performed on and in between objects. After an object is
 * created, it therefore has to be added to the game-world.
 *
 * @author Eldar Sandanger
 * */

public class GameWorld {
    private ArrayList<GameObject> staticGameObjects;
    private ArrayList<GameObject> dynamicGameObjects;

    // Factories
    private final PlayerFactory playerFactory = PlayerFactory.getInstance();
    private final BombFactory bombFactory = BombFactory.getInstance();
    private final FireFactory fireFactory = FireFactory.getInstance();


    private final World world;
    private final GameMap map;
    private final AnnotationAssetManager assetManager;

    private final Box2DDebugRenderer b2dr;
    private final OrthographicCamera b2drCam;


    // https://box2d.org/documentation/md__d_1__git_hub_box2d_docs_hello.html#autotoc_md21
    // Info contact listener: https://www.iforce2d.net/b2dtut/collision-callbacks
    // Info player in box2d: https://www.gamedev.net/forums/topic/616398-controllable-player-character-with-box2d/

    public GameWorld(GameMap map, AnnotationAssetManager manager) {
        world = new World(new Vector2(0,0), true); // Initialize Box2D World. Set Gravity 0 and 'not simulate inactive objects' true
        this.assetManager = manager;
        world.setContactListener(new WorldContactListener());
        staticGameObjects = new ArrayList<GameObject>();
        dynamicGameObjects = new ArrayList<GameObject>();
        this.map = map;

        b2dr = new Box2DDebugRenderer();
        b2drCam = new OrthographicCamera(VIRTUAL_WIDTH / PPM, VIRTUAL_HEIGHT / PPM);
        b2drCam.position.set(map.getMapWidthInPixels() / 2f / PPM, map.getMapHeightInPixels() / 2f / PPM, 0);
        b2drCam.update();
    }

    // Update GameWorld with one time-step
    public void update(float delta) {
        // In step, VelocityIteration and PositionIteration values are just 'recommended'
        // Explanation gameWorld step: http://www.iforce2d.net/b2dtut/worlds
        world.step(delta, 6, 2);
        updateGameObjects(delta);
        b2dr.render(world, b2drCam.combined);


        // Make sure that the positions are automatically synchronized
        // Maybe put observers on the gameobjects that get updates when the objects in the world are updated?
    }


    private void addGameObject(IModel model){
        if (model.isStatic()) {
            addStaticObject(model);
        } else {
            addDynamicObject(model);
        }
    }

    // Add static object to GameObjects
    private void addStaticObject(IModel model) {
        GameObject newObject = new GameObject(model, world, assetManager);
        staticGameObjects.add(newObject);
    }

    private void addDynamicObject(IModel model) {
        GameObject newObject = new GameObject(model, world, assetManager);
        dynamicGameObjects.add(newObject);
    }


    public void generateMapBlocks() {
        Gdx.app.log("GameWorld", "Adding map blocks");
        for (int x = 0; x < map.getMapWidthInTiles(); x++){
            for (int y = 0; y < map.getMapHeightInTiles(); y++){
                for (IModel model : map.tileContainers.get(x,y)){
                    addGameObject(model);
                }
            }
        }
    }

    public void initializePlayers() {
        Gdx.app.log("GameWorld", "Initializing main player");
        Vector2 p1StartPos = map.tilePos(new Vector2(1,1));
        // TODO: why doesnt player get centered if scaled down?
        IModel p1 = playerFactory.createPlayer(1, p1StartPos, PlayerType.NORMALPLAYER,
                                            Color.RED, map.getTileWidth() * 0.9f, map.getTileHeight() * 0.9f);
        this.addGameObject(p1);
    }


    public void placeBomb(Vector2 position, BombType type, float range) {
        // TODO: why doesnt bomb get centered if scaled down?
        IModel bomb = bombFactory.createBomb(position, type, map.getTileWidth() * 0.8f, map.getTileHeight() * 0.8f, range);
        addGameObject(bomb);
    }

    public void spawnFire(ArrayList<Vector2> fireTiles, BombType type) {
        for (Vector2 firePos : fireTiles) {
            IModel newFire = fireFactory.createFire(firePos, type, map.getTileWidth(), map.getTileHeight());
            addGameObject(newFire);
        }
    }

    public void updateGameObjects(float delta) {
        for(GameObject dynamicGameObject : dynamicGameObjects) {
            dynamicGameObject.syncPosition();
            dynamicGameObject.update(delta);

            // TODO: remove this, only for testing velocity
            dynamicGameObject.getBody().setLinearVelocity(-5, 20);
        }
        for (GameObject staticObject : staticGameObjects){
            staticObject.update(delta);
        }

    }

    public ArrayList<GameObject> getStaticGameObjects() {
        return staticGameObjects;
    }

    public ArrayList<GameObject> getDynamicGameObjects() {
        return dynamicGameObjects;
    }

    public void cleanupDestroyedObjects(){
        for (GameObject obj : staticGameObjects) {
            if (obj.destroyObject == true) {
                obj.dispose();
                staticGameObjects.remove(obj);
                Runtime.getRuntime().gc(); // Call the garbage collector
            }
        }
        for (GameObject obj : dynamicGameObjects) {
            if (obj.destroyObject == true) {
                obj.dispose();
                dynamicGameObjects.remove(obj);
                Runtime.getRuntime().gc(); // Call the garbage collector
            }
        }
    }
}
