package com.dragons.game.model.blockFactory.blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.dragons.game.model.Subject;
import com.dragons.game.view.modelViews.IModelObserver;

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
