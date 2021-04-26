package com.dragons.game.controller.gameWorld;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.controller.bombController.BombController;
import com.dragons.game.controller.bombController.FireController;
import com.dragons.game.controller.IGameObjectController;
import com.dragons.game.model.IModel;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.model.bombs.IBomb;
import com.dragons.game.model.maps.GameMap;
import com.dragons.game.model.modelFactories.BombFactory;
import com.dragons.game.model.modelFactories.FireFactory;
import com.dragons.game.model.modelFactories.PlayerFactory;
import com.dragons.game.controller.playerController.InputHandler;
import com.dragons.game.model.players.playerEnums.PlayerType;
import com.dragons.game.utilities.Constants;
import com.dragons.game.view.UIViews.LifeDisplayView;


import net.dermetfan.gdx.assets.AnnotationAssetManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static com.dragons.game.utilities.Constants.PPM;
import static com.dragons.game.utilities.Constants.VIEWPORT_HEIGHT;
import static com.dragons.game.utilities.Constants.VIEWPORT_WIDTH;

/**
 * The GameWorld class instantiates the world in which a single game will be played. The
 * class itself then works as a container for our game where every time-step is simulated with
 * the proper actions and interactions performed on and in between objects. After an object is
 * created, it therefore has to be added to the game-world.
 *
 * */

public class GameWorld {

    private final List<GameObject> staticGameObjects = new LinkedList<>();
    private final List<GameObject> dynamicGameObjects = new LinkedList<>();
    private final List<IGameObjectController> actionControllers = new LinkedList<>();
    private final List<IGameObjectController> tempControllerContainer = new LinkedList<>();
    private final ArrayList<LifeDisplayView> lifeDisplay = new ArrayList<>();

    // Factories
    private final PlayerFactory playerFactory = PlayerFactory.getInstance();
    private final BombFactory bombFactory = BombFactory.getInstance();
    private final FireFactory fireFactory = FireFactory.getInstance();

    private final World world;
    private final GameMap map;
    private final AnnotationAssetManager assetManager;
    private final Box2DDebugRenderer b2dr;
    private final OrthographicCamera b2drCam;

    private final InputHandler inputHandler;

    private int cleanupCounter;
    private final DeathDetector deathDetector;


    public GameWorld(GameMap map, AnnotationAssetManager manager, OrthographicCamera camera) {
        this.assetManager = manager;
        this.map = map;

        // Initialize Box2D World. Set Gravity 0 and 'not simulate inactive objects' true
        world = new World(new Vector2(0,0), true);
        world.setContactListener(new WorldContactListener());

        // Initializes the debugrenderer => used for rendering the world bodies in the view for debugging
        b2dr = new Box2DDebugRenderer();
        b2drCam = new OrthographicCamera(VIEWPORT_WIDTH / PPM, VIEWPORT_HEIGHT / PPM);
        b2drCam.position.set(map.getMapWidthInPixels() / 2f / PPM, map.getMapHeightInPixels() / 2f / PPM, 0);
        b2drCam.update();

        deathDetector = new DeathDetector();
        inputHandler = new InputHandler(camera, manager, this);

        this.cleanupCounter = 0;
    }

    // Update GameWorld with a time-step
    public void update(float delta) {
        world.step(delta, 6, 2);
        updateGameObjects(delta);
        updateActionControllers();

        // Uncomment this for debugrenderer
        //b2dr.render(world, b2drCam.combined);

        // Cleanup unused objects in some iterations using garbage collector
        if (cleanupCounter > Constants.CleanupCounterLimit) {
            Runtime.getRuntime().gc();
            this.cleanupCounter = 0;
        }
        this.cleanupCounter++;


    }

    public void addGameObject(GameObject newObject){
        if (newObject.getModel().isStatic()) {
            staticGameObjects.add(newObject);
        } else {
            dynamicGameObjects.add(newObject);
        }
    }

    public void generateMapBlocks() {
        Gdx.app.log("GameWorld", "Adding map blocks");
        for (int x = 0; x < map.getMapWidthInTiles(); x++){
            for (int y = 0; y < map.getMapHeightInTiles(); y++){
                for (IModel model : map.getTileContent(x,y)){
                    GameObject newObject = new GameObject(model, world, assetManager);
                    addGameObject(newObject);
                }
            }
        }
    }

    /**
     * Initialize two players and adds them to to the list of gameobjects, the input handler, and
     * Connects the players to their own lifeDisplay
     */
    public void initializePlayers() {

        // Initialize player 1
        Vector2 p1StartPos = map.tilePosCenter(new Vector2(1,1));
        IModel p1 = playerFactory.createPlayer(1, p1StartPos, PlayerType.NORMALPLAYER, Color.RED,
                map.getTileWidth() * Constants.PlayerScaleFactor, map.getTileHeight() * Constants.PlayerScaleFactor);

        GameObject player1 = new GameObject(p1, world, assetManager);
        addGameObject(player1);
        inputHandler.addPlayer(player1, true);
        deathDetector.addPlayer(player1);

        LifeDisplayView healthView1 = new LifeDisplayView(p1, assetManager, map, map.tilePosCenter(new Vector2(3,10)));
        lifeDisplay.add(healthView1);

        // Initialize player 2
        Vector2 p2StartPos = map.tilePosCenter(new Vector2(13,9));
        IModel p2 = playerFactory.createPlayer(2, p2StartPos, PlayerType.NORMALPLAYER, Color.BLUE,
                map.getTileWidth() * Constants.PlayerScaleFactor, map.getTileHeight() * Constants.PlayerScaleFactor);

        GameObject player2 = new GameObject(p2, world, assetManager);
        addGameObject(player2);
        inputHandler.addPlayer(player2, false);
        deathDetector.addPlayer(player2);

        LifeDisplayView healthView2 = new LifeDisplayView(p2, assetManager, map, map.tilePosCenter(new Vector2(9,10)));
        lifeDisplay.add(healthView2);


    }

    public void placeBomb(Vector2 centerPos, BombType type, int extraRange) {
        IModel bomb = bombFactory.createBomb(centerPos, type, map.getTileWidth() * Constants.BombScaleFactor, map.getTileHeight() * Constants.BombScaleFactor, extraRange);
        GameObject newBomb = new GameObject(bomb, world, assetManager);
        BombController newBombCtr = new BombController(newBomb);
        addGameObject(newBomb);
        this.actionControllers.add(newBombCtr);
    }

    public void spawnFire(ArrayList<Vector2> fireTiles, IBomb bomb) {
        //Gdx.app.log("GameWorld", "Spawning fire");
        for (Vector2 firePos : fireTiles) {
            IModel fire = fireFactory.createFire(firePos, bomb.getType(), map.getTileWidth() * Constants.FireScaleFactor, map.getTileHeight() * Constants.FireScaleFactor);
            GameObject newFire = new GameObject(fire,world,assetManager);
            FireController newFireCtr = new FireController(newFire);
            this.staticGameObjects.add(newFire); // Add to staticObjects since the position is always static
            this.tempControllerContainer.add(newFireCtr);
        }
    }

    public void updateGameObjects(float delta) {
        // Have to use Iterator in this method since we're modifying the lists while iterating
        Iterator<GameObject> iterator = dynamicGameObjects.iterator();
        GameObject dynamicObj;
        while(iterator.hasNext()) {
            dynamicObj = iterator.next();
            if (dynamicObj.isDisposable()){
                world.destroyBody(dynamicObj.getBody());
                dynamicObj.dispose();
                iterator.remove();
            }
            else {
                dynamicObj.syncPosition();
                dynamicObj.update(delta);
            }
        }
        iterator = staticGameObjects.iterator();
        GameObject staticObj;
        while(iterator.hasNext()){
            staticObj = iterator.next();
            if (staticObj.isDisposable()){
                world.destroyBody(staticObj.getBody());
                staticObj.dispose();
                iterator.remove();
            }
            else{
                staticObj.update(delta);
            }
        }
    }


    /**
     * Iterate through the controllers and perform actions
     */
    public void updateActionControllers(){
        // Iterate through the controllers and perform actions
        // We have to use an iterator to remove them correctly
        // REMOVING FIX: https://stackoverflow.com/questions/10033025/crash-when-trying-to-remove-object-from-arraylist
        Iterator<IGameObjectController> iterator = actionControllers.iterator();
        IGameObjectController controller;
        while(iterator.hasNext()){
            controller = iterator.next();
            controller.controllerAction(this);
            if (controller.remove()) {
                iterator.remove();
            }
        }
        // This step has to be performed due to limitations on how iterators work. We can't add to the same list we try to iterate through.
        // Therefore we store new controllers in IView temporary list and add them afterwards
        actionControllers.addAll(tempControllerContainer);
        tempControllerContainer.clear();
    }

    public void dispose(){
        world.dispose();
        b2dr.dispose();
    }

    public List<GameObject> getStaticGameObjects() {
        return staticGameObjects;
    }

    public List<GameObject> getDynamicGameObjects() {
        return dynamicGameObjects;
    }

    public GameMap getMap() {
        return map;
    }

    public DeathDetector getDeathDetector(){
        return deathDetector;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public ArrayList<LifeDisplayView> getLifeDisplay() {
        return lifeDisplay;
    }



}
