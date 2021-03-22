package com.dragons.game.model.blockFactory.blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.Subject;
import com.dragons.game.utilities.IModelType;
import com.dragons.game.view.modelViews.IModelObserver;

public abstract class Block extends Subject {

    // TODO: correct fields? TILE INSTEAD OF X, Y, WIDTH, HEIGHT?
    protected float x, y, width, height;
    protected Body body;
    protected IModelType type;


    public Block(IModelObserver observer) {
        super(observer);

    }


    public abstract void handleHitByBomb();


    public Body getBody() {
        return body;
    }

    // TODO: Check if this is the right/good implementation
    // Use the type to determine which texture to load
    public IModelType getType() {
        return type;
    }
}
