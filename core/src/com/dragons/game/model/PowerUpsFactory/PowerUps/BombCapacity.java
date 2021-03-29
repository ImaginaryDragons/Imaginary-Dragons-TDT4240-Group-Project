package com.dragons.game.model.PowerUpsFactory.PowerUps;

import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;

public class BombCapacity extends PowerUp{

    public Player player;

    @Override
    public void whenPickedUp() {
        player.bombCapacity += 1;
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
