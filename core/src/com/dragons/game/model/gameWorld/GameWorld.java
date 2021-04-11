package com.dragons.game.model.gameWorld;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.IModel;
import com.dragons.game.model.PowerUps.IPowerUp;
import com.dragons.game.model.blocks.DestructibleBlock;
import com.dragons.game.model.bomb.Bomb;
import com.dragons.game.model.bomb.Fire;
import com.dragons.game.model.bomb.FireType;
import com.dragons.game.model.player.Player;
import com.dragons.game.model.player.PlayerColor;
import com.dragons.game.view.modelViews.BombView;
import com.dragons.game.view.modelViews.DestructibleBlockView;
import com.dragons.game.view.modelViews.FireView;
import com.dragons.game.view.modelViews.ModelView;
import com.dragons.game.view.modelViews.PlayerView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import java.util.ArrayList;

/**
 * The GameWorld class instantiates the world in which a single game will be played. The
 * class itself then works as a container for our game where every time-step is simulated with
 * the proper actions and interactions performed on and in between objects. After an object is
 * created, it therefore has to be added to the game-world.
 *
 * @author Eldar Sandanger
 * */

public class GameWorld {
    private ArrayList<GameObject> gameObjects;
    private ArrayList<GameObject> players;
    private ArrayList<GameBomb> bombs;
    private ArrayList<GameObject> fires;
    private World world;
    private GameMap map;
    private Player player;
    private AnnotationAssetManager assetManager;


    // https://box2d.org/documentation/md__d_1__git_hub_box2d_docs_hello.html#autotoc_md21
    // Info contact listener: https://www.iforce2d.net/b2dtut/collision-callbacks
    // Info player in box2d: https://www.gamedev.net/forums/topic/616398-controllable-player-character-with-box2d/

    public GameWorld(World world, GameMap map, AnnotationAssetManager manager) {
        this.world = world;
        this.assetManager = manager;
        world.setContactListener(new WorldContactListener());
        gameObjects = new ArrayList<GameObject>();
        players = new ArrayList<GameObject>();
        bombs = new ArrayList<GameBomb>();
        this.map = map;
    }

    // Add object to GameObjects
    public void addObject(IModel obj, ModelView objView, boolean isStatic, boolean isSensor) {
        GameObject newObject = new GameObject(obj, objView, world);
        newObject.isStatic = isStatic;
        newObject.isSensor = isSensor;
        newObject.createBody();
        gameObjects.add(newObject);
    }

    // Add player to the game
    public void addPlayer(Player player, PlayerView playerView) {
        // TODO: Add a game class that encapsulates a player with a controller (similar to the GameBomb class).
        GameObject newObject = new GameObject(player, playerView, world);
        newObject.isSensor = false;
        newObject.isStatic = false;
        newObject.createBody();
        players.add(newObject);
    }

    public void generateMapBlocks() {
        Gdx.app.log("GameWorld", "Adding map blocks");
        for (int x = 0; x < map.getMapWidthInTiles(); x++){
            for (int y = 0; y < map.getMapHeightInTiles(); y++){
                for (IModel obj : map.tileContainers.get(x,y)){
                    if (obj instanceof IPowerUp) {
                        Gdx.app.log("GameWorld/GenerateMapBlocks", "Generating power-up");
                    } else if (obj instanceof DestructibleBlock){
                        Gdx.app.log("GameWorld/GenerateMapBlocks", "Generating destructible block");
                        DestructibleBlockView view = new DestructibleBlockView((DestructibleBlock) obj, assetManager);
                        this.addObject(obj, view, true, false);
                    }else {
                        this.addObject(obj, null, true, false);
                    }
                }
            }
        }
    }

    public void initializePlayers() {
        Gdx.app.log("GameWorld", "Initializing main player");
        Vector2 p1StartPos = map.tilePos(new Vector2(1,1));
        Player p1 = new Player(1, p1StartPos, Color.RED, map.getTileWidth(), map.getTileHeight());
        PlayerView p1v = new PlayerView(p1, assetManager);
        this.addPlayer(p1, p1v);
    }

    public void spawnFire(ArrayList<Vector2> fireTiles) {
        for (Vector2 firePos : fireTiles) {
            Fire newFire = new Fire(firePos, FireType.NORMALFIRE, map.getTileWidth(), map.getTileHeight());
            FireView newFireView = new FireView(newFire, assetManager);
            this.addObject(newFire, newFireView, true, true);
        }
    }

    // Update GameWorld with one time-step
    public void update(float delta) {
        // In step, VelocityIteration and PositionIteration values are just 'recommended'
        // Explanation gameWorld step: http://www.iforce2d.net/b2dtut/worlds
        updateBombs(delta);
        world.step(delta, 6, 2);
        updatePlayerPositions();

        // TODO: Get contact list and deal with every contact

        // Make sure that the positions are automatically synchronized
        // Maybe put observers on the gameobjects that get updates when the objects in the world are updated?
    }

    public void placeBomb(Vector2 position, float timer, float range) {
        Bomb bomb = new Bomb(position, map.getTileWidth() / 2, timer, range);
        BombView bombView = new BombView(bomb, assetManager, position);
        GameBomb newBomb = new GameBomb(bomb, bombView, world);
        newBomb.isSensor = false;
        newBomb.isStatic = false;
        newBomb.createBody();
        bombs.add(newBomb);
        gameObjects.add(newBomb);
    }

    /*Due to the players always moving, it is beneficial to always check for positional updates
    * for every frame iteration*/
    public void updatePlayerPositions() {
        for(GameObject obj : players)
        {
            obj.syncPosition();
        }
    }

    // TODO: Update player with timestep delta to simulate the correct velocity

    // Update the bomb time-step to ensure countdown
    public void updateBombs(float delta) {
        for(GameBomb bomb : bombs)
        {
            bomb.update(delta);
        }
    }

    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    public ArrayList<GameObject> getPlayers() {
        return players;
    }

    public ArrayList<GameObject> getFires() {
        return fires;
    }

    public ArrayList<GameBomb> getBombs() {
        return bombs;
    }
}
