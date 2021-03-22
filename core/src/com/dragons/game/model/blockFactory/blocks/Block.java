package com.dragons.game.model.blockFactory.blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class Block {

    // TODO: correct fields?
    private float x, y;
    private Body body;
    private Texture texture;


    abstract void whenHitByBomb();
}
