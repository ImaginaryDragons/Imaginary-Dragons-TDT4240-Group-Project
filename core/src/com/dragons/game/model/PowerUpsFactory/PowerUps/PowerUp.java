package com.dragons.game.model.PowerUpsFactory.PowerUps;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class PowerUp {

    // TODO: add fields
    private float x, y;
    private Body body;
    private Texture texture;

    public abstract void whenPickedUp();
}
