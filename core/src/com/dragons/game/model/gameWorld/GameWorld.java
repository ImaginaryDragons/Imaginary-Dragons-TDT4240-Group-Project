package com.dragons.game.model.gameWorld;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.IObject;
import com.dragons.game.model.bomb.Bomb;
import com.dragons.game.model.player.Player;

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
    private World world;
    private GameMap map;

    // https://box2d.org/documentation/md__d_1__git_hub_box2d_docs_hello.html#autotoc_md21
    // Info contact listener: https://www.iforce2d.net/b2dtut/collision-callbacks
    // Info player in box2d: https://www.gamedev.net/forums/topic/616398-controllable-player-character-with-box2d/

    public GameWorld(World world, GameMap map) {
        this.world = world;
        world.setContactListener(new WorldContactListener());
        gameObjects = new ArrayList<GameObject>();
        players = new ArrayList<GameObject>();
        bombs = new ArrayList<GameBomb>();
        this.map = map;
    }

    public void generateMapBlocks() {
        Gdx.app.log("GameWorld", "Adding map blocks");
        for (int x = 0; x < map.getMapWidthInTiles(); x++){
            for (int y = 0; y < map.getMapHeightInTiles(); y++){
                for (IObject obj : map.tileContainers.get(x,y)){
                    this.addObject(obj);
                }
            }
        }
        for (GameObject obj : gameObjects) { // TEST
            // TODO: Make these two synchronized!!
            System.out.println(obj.getBody().getPosition().toString());
            System.out.println(obj.getObject().getPosition().toString());
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

    // Add object to GameObjects
    public void addObject(IObject obj) {
        gameObjects.add(new GameObject(obj, world));
    }

    public void addPlayer(Player player) {
        // TODO: Add a game class that encapsulates a player with a controller (similar to the GameBomb class).
        players.add(new GameObject(player, world));
    }

    public void addBomb(Bomb bomb) {
        GameBomb b = new GameBomb(bomb, world);
        bombs.add(b);
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
            //bombView.updateBomb() er vel riktig her? Vi kaller bomb.update i bombview for å få mvc
            bomb.update(delta);
        }
    }

    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    public ArrayList<GameObject> getPlayers() {
        return players;
    }

    public ArrayList<GameBomb> getBombs() {
        return bombs;
    }
}
