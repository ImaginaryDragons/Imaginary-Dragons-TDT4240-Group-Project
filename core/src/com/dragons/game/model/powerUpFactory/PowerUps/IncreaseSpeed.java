package com.dragons.game.model.powerUpFactory.PowerUps;

import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.player.Player;

public class IncreaseSpeed extends PowerUp{

    // TODO: ADD FIELDS
    // private Tile tile etc
    private Player player;

    public IncreaseSpeed(Player player) {
        super();
        this.player = player;
    }

    // TODO: IMPLEMENT METHODS

    @Override
    public void whenPickedUp() {
        player.speed += 2;
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
