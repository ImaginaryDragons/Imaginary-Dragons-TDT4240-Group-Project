package com.dragons.game.model.gameWorld;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.IModel;
import com.dragons.game.model.bomb.Bomb;
import com.dragons.game.model.bomb.Fire;
import com.dragons.game.model.bomb.FireType;
import com.dragons.game.model.player.Player;

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

    private World world;
    private GameMap map;
    private AnnotationAssetManager assetManager;

    private Box2DDebugRenderer b2dr;
    private OrthographicCamera b2drCam;


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
                    addStaticObject(model);
                }
            }
        }
    }

    public void initializePlayers() {
        Gdx.app.log("GameWorld", "Initializing main player");
        Vector2 p1StartPos = map.tilePos(new Vector2(1,1));
        IModel p1 = new Player(1, p1StartPos, Color.RED, map.getTileWidth(), map.getTileHeight());
        this.addGameObject(p1);
    }


    public void placeBomb(Vector2 position, float timer, float range) {
        IModel bomb = new Bomb(position, map.getTileWidth(), range);
        addGameObject(bomb);
    }

    public void spawnFire(ArrayList<Vector2> fireTiles) {
        for (Vector2 firePos : fireTiles) {
            IModel newFire = new Fire(firePos, FireType.NORMALFIRE, map.getTileWidth(), map.getTileHeight());
            addGameObject(newFire);
        }
    }

    public void updateGameObjects(float delta) {
        for(GameObject object : dynamicGameObjects) {
            object.syncPosition();
            object.update(delta);

            // TODO: remove this, only for testing velocity
            object.getBody().setLinearVelocity(0, -20);
        }
        for (GameObject object : staticGameObjects){
            object.update(delta);
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
