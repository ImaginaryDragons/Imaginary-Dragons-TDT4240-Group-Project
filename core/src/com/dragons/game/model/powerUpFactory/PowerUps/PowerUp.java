package com.dragons.game.model.powerUpFactory.PowerUps;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.Subject;
import com.dragons.game.utilities.BodyBuilder;
import com.dragons.game.utilities.IModelType;
import com.dragons.game.view.modelViews.IModelObserver;

import static com.dragons.game.utilities.ContactType.POWERUP;


public abstract class PowerUp extends Subject {

    // TODO: add/modify fields, get x, y, width, height from Tile
    protected float x, y, width, height;
    protected Body body;
    protected IModelType type;

    public PowerUp(IModelObserver observer, World world) {
        super(observer);
        // TODO: CHECK COMMENT
        /* Body here is okay if every future powerup will have the same contact behavior
         * If not this has to be moved into each class
         */
        body = BodyBuilder.createBoxBody(x, y, width, height, world, true, POWERUP, 0f);
    }

    public abstract void whenPickedUp();

    public Body getBody() {
        return body;
    }

    // TODO: Check if this is the right/good implementation
    // Use the type to determine which texture to load
    public IModelType getType() {
        return type;
    }
}
