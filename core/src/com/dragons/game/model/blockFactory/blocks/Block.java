package com.dragons.game.model.blockFactory.blocks;

import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.Subject;

/**
 * @author Jakob Eikeland and Elise Bø
 * */

public abstract class Block extends Subject {

    private Vector2 pos;
    private Shape2D shape; // Also contains position!

    public Block() {
        super();
    }

    public abstract void handleHitByBomb();
}
