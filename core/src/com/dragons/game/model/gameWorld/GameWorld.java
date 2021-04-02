package com.dragons.game.model.gameWorld;


import com.badlogic.gdx.math.Vector2;
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

    //https://box2d.org/documentation/md__d_1__git_hub_box2d_docs_hello.html#autotoc_md21
    // Info contact listener: https://www.iforce2d.net/b2dtut/collision-callbacks
    // Info player in box2d: https://www.gamedev.net/forums/topic/616398-controllable-player-character-with-box2d/

    public GameWorld() {
        // TODO: doSleep = true or false?
        world = new World(new Vector2(0,0), true);  // Initialize Box2D World. Set Gravity 0 and 'not simulate inactive objects' true
        gameObjects = new ArrayList<GameObject>();
        players = new ArrayList<GameObject>();
        bombs = new ArrayList<GameBomb>();
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
    public void addObject(IObject obj, boolean isStatic) {
        gameObjects.add(new GameObject(obj, world, isStatic));
    }

    public void addPlayer(Player player) {
        // TODO: Add a game class that encapsulates a player with a controller (similar to the GameBomb class).
        players.add(new GameObject(player, world, false)); //TODO: IS FALSE CORRECT?
    }

    public void addBomb(Bomb bomb) {
        GameBomb b = new GameBomb(bomb, world);
        bombs.add(b);
    }

    /*Due to the players always moving, it is beneficial to always check for positional updates
    * for every frame iteration*/
    private void updatePlayerPositions() {
        for(GameObject obj : players)
        {
            obj.syncPosition();
        }
    }

    // Update the bomb time-step to ensure countdown
    private void updateBombs(float delta) {
        for(GameBomb bomb : bombs)
        {
            bomb.update(delta);
        }
    }

}
