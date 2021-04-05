package com.dragons.game.model.gameWorld;

import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.bomb.Bomb;

public class GameBomb extends GameObject {

    private Bomb bomb;

    public GameBomb(Bomb bomb, World world) {
        super(bomb, world); // Is it static? It is the same every time at least.
        this.bomb = bomb;
        // TODO: Tell world to ignore GameBomb somehow so that it doesn't interact with other objects
        // Only the flame should interact with others
    }

    public void update(float delta) {
        bomb.update(delta);
    }
}
