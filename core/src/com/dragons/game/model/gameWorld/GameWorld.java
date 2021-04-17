package com.dragons.game.model.gameWorld;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.IModel;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.model.modelFactories.BombFactory;
import com.dragons.game.model.modelFactories.FireFactory;
import com.dragons.game.model.modelFactories.PlayerFactory;
import com.dragons.game.model.players.NormalPlayer;
import com.dragons.game.model.players.PlayerType;
import com.dragons.game.model.playerController.PlayerController;
import com.dragons.game.utilities.Constants;
import com.dragons.game.view.modelViews.LifeDisplayView;
import com.dragons.game.view.modelViews.PlayerView;


import net.dermetfan.gdx.assets.AnnotationAssetManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

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
    private ArrayList<IGameObjectController> actionControllers;
    private ArrayList<IGameObjectController> tempControllerContainer; // This is a workaround from a problem with adding to actionControllers while iterating through it!
    private ArrayList<LifeDisplayView> lifeDisplay;

    // Factories
    private final PlayerFactory playerFactory = PlayerFactory.getInstance();
    private final BombFactory bombFactory = BombFactory.getInstance();
    private final FireFactory fireFactory = FireFactory.getInstance();

    private final World world;
    private final GameMap map;
    private final AnnotationAssetManager assetManager;
    private final Box2DDebugRenderer b2dr;
    private final OrthographicCamera b2drCam;

    private final PlayerController playerController;

    private int cleanupCounter;


    // https://box2d.org/documentation/md__d_1__git_hub_box2d_docs_hello.html#autotoc_md21
    // Info contact listener: https://www.iforce2d.net/b2dtut/collision-callbacks
    // Info player in box2d: https://www.gamedev.net/forums/topic/616398-controllable-player-character-with-box2d/
    public GameWorld(GameMap map, AnnotationAssetManager manager, OrthographicCamera camera) {
        world = new World(new Vector2(0,0), true); // Initialize Box2D World. Set Gravity 0 and 'not simulate inactive objects' true
        this.assetManager = manager;
        world.setContactListener(new WorldContactListener());
        staticGameObjects = new ArrayList<GameObject>();
        dynamicGameObjects = new ArrayList<GameObject>();
        actionControllers = new ArrayList<IGameObjectController>();
        tempControllerContainer = new ArrayList<IGameObjectController>();
        lifeDisplay = new ArrayList<LifeDisplayView>();
        this.map = map;

        b2dr = new Box2DDebugRenderer();
        b2drCam = new OrthographicCamera(VIRTUAL_WIDTH / PPM, VIRTUAL_HEIGHT / PPM);
        b2drCam.position.set(map.getMapWidthInPixels() / 2f / PPM, map.getMapHeightInPixels() / 2f / PPM, 0);
        b2drCam.update();

        playerController = new PlayerController(camera, manager, this);

        this.cleanupCounter = 0;
    }

    // Update GameWorld with one time-step
    public void update(float delta) {
        // In step, VelocityIteration and PositionIteration values are just 'recommended'
        // Explanation gameWorld step: http://www.iforce2d.net/b2dtut/worlds
        world.step(delta, 6, 2);
        updateGameObjects(delta);
        b2dr.render(world, b2drCam.combined);

        // Cleanup unused objects in some iterations
        if (cleanupCounter > 20) {
            cleanupDestroyedObjects();
            this.cleanupCounter = 0;
        }
        this.cleanupCounter++;
    }

    public void addGameObject(IModel model){
        GameObject newObject = new GameObject(model, world, assetManager);
        if (model.isStatic()) {
            staticGameObjects.add(newObject);
        } else {
            dynamicGameObjects.add(newObject);
        }

        // If newObject is NORMALPLAYER and main player -> playerController.addPlayer(newObject)
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
      
        Vector2 p1StartPos = map.tilePosCenter(new Vector2(1,1));
        IModel p1 = playerFactory.createPlayer(1, p1StartPos, PlayerType.NORMALPLAYER, Color.RED, map.getTileWidth() * Constants.PlayerScaleFactor, map.getTileHeight() * Constants.PlayerScaleFactor); // TODO: Remove magic numbers
        GameObject player1 = new GameObject(p1, world, assetManager);
        playerController.addPlayer(player1);
        dynamicGameObjects.add(player1);
        LifeDisplayView healthView = new LifeDisplayView((NormalPlayer)p1, assetManager, map, map.tilePosCenter(new Vector2(1,10)));
        lifeDisplay.add(healthView);

        Gdx.app.log("GameWorld", "Initializing secondary player");
        Vector2 p2StartPos = map.tilePosCenter(new Vector2(13,9));
        IModel p2 = playerFactory.createPlayer(2, p2StartPos, PlayerType.NORMALPLAYER, Color.BLUE, map.getTileWidth() * Constants.PlayerScaleFactor, map.getTileHeight() * Constants.PlayerScaleFactor);
        GameObject player2 = new GameObject(p2, world, assetManager);
        dynamicGameObjects.add(player2);
    }


    public void placeBomb(Vector2 centerPos, BombType type, float range) {
        IModel bomb = bombFactory.createBomb(centerPos, type, map.getTileWidth() * Constants.BombScaleFactor, map.getTileHeight() * Constants.BombScaleFactor, range); // TODO: Remove magic numbers
        GameObject newBomb = new GameObject(bomb, world, assetManager);
        BombController newBombCtr = new BombController(newBomb);
        this.dynamicGameObjects.add(newBomb);
        this.actionControllers.add(newBombCtr);
    }

    public void spawnFire(ArrayList<Vector2> fireTiles, BombType type) {
        Gdx.app.log("GameWorld", "Spawning fire");
        for (Vector2 firePos : fireTiles) {
            IModel fire = fireFactory.createFire(firePos, type, map.getTileWidth() * Constants.FireScaleFactor, map.getTileHeight() * Constants.FireScaleFactor);
            GameObject newFire = new GameObject(fire,world,assetManager);
            FireController newFireCtr = new FireController(newFire);
            this.staticGameObjects.add(newFire);
            this.tempControllerContainer.add(newFireCtr);
        }
    }

    public void updateGameObjects(float delta) {
        for(GameObject dynamicGameObject : dynamicGameObjects) {
            dynamicGameObject.syncPosition();
            dynamicGameObject.update(delta);
        }
        for (GameObject staticObject : staticGameObjects){
            staticObject.update(delta);
        }

        // Iterate through the controllers and perform actions
        // We have to use an iterator to remove them correctly
        // REMOVING FIX: https://stackoverflow.com/questions/10033025/crash-when-trying-to-remove-object-from-arraylist
        Iterator<IGameObjectController> it = actionControllers.iterator();
        IGameObjectController ctr;
        while(it.hasNext()){
            ctr = it.next();
            ctr.controllerAction(this);
            if (ctr.remove()) {
                System.out.println(actionControllers.toString());
                System.out.println(it.toString());
                it.remove();
            }
        }
        // This step has to be performed due to limitations on how iterators work. We can't add to the same list we try to iterate through.
        // Therefore we store new controllers in a temporary list and add them afterwards
        actionControllers.addAll(tempControllerContainer);
        tempControllerContainer.clear();
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

    public ArrayList<IGameObjectController> getActionControllers() {
        return actionControllers;
    }

    public GameMap getMap() {
        return map;
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

    public ArrayList<LifeDisplayView> getLifeDisplay() {
        return lifeDisplay;
    }
}
