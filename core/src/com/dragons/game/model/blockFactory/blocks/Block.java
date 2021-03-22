package com.dragons.game.model.blockFactory.blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.dragons.game.model.Subject;
import com.dragons.game.view.modelViews.IModelObserver;

public abstract class Block extends Subject {

    // TODO: correct fields?
    private float x, y;
    private Body body;
    private Texture texture;

    public Block(IModelObserver observer) {
        super(observer);
    }


    public abstract void handleHitByBomb();
}
