package com.dragons.game.components;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.dragons.game.utilities.Constants;

public class TileComponent {

    private float row, col; // maze indexes

    private int type; // block type

    private BombModel bomb; // if not null this cell contains a bomb

    private Body body; // The body block (SOLID or Destructible)

    private boolean explosion; // if not null, the cell contains an explosion

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
    }



}
