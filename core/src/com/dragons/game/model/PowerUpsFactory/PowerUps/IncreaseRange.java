package com.dragons.game.model.PowerUpsFactory.PowerUps;

import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;

public class IncreaseRange extends PowerUp{

    // TODO: ADD FIELDS
    private Tile tile;
    private Bomb bomb;

    @Override
    public void whenPickedUp() {
        // TODO: IMPLEMENT METHOD
        /*
        The bomb range will increase, but it will increase in all directions
         */
    }
    @Override
    public void setPosition(Vector2 pos) {

    }
    @Override
    public Vector2 getPosition() {
        return null;
    }

    @Override
    public void setShape(Shape2D shape) {

    }
    @Override
    public Shape2D getShape() {
        return null;
    }
}
