package com.dragons.game.components;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.dragons.game.utilities.Constants;

public enum Tile {
    FLOOR, // represents the floor on which the character can move and drop bombs
    INDESTRUCTABLEBLOCK, // represents the blocks that cannot be destroyed or walked over
    DESTRUCTABLEBLOCK  // represents the blocks that can be destroyed by bombs and potentially drop powerups
    }


    /*private float row, col; // maze indexes

    private int type; // block type

    private BombComponent bomb; // if not null this cell contains a bomb

    private Body body; // The body block (SOLID or Destructible)

    private boolean explosion; // if not null, the cell contains an explosion

    private Gameworld gameworld; // need this reference in order to create bodies

    private PowerUpComponent power_up; // if not null, the cell constains a power up

    public TileComponent(float row, float col, float width, float height, int type){
        this. row = row;
        this.col = col;
        this.type = type;
        bomb = null;
        explosion = false;
        power_up = null;

        if(type == Constants.SOLID_BLOCK || type == Constants.DESTRUCTIBLE_BLOCK) {
            Vector2 v = gameWorld.maze_to_world_coords(col, row);
            body = gameWorld.createWallBody(v.x, v.y, width, height);
        }else
            body = null;
    }*/
