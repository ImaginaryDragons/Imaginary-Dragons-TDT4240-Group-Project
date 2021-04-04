package com.dragons.game.model.gameWorld;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.IObject;
import com.dragons.game.view.modelViews.ModelView;


public class GameObject {

    // https://gamedev.stackexchange.com/questions/88455/how-can-i-attach-a-libgdx-actor-to-a-box2d-body

    private final IObject obj;
    private ModelView objView;
    private final Body body;
    private final World world;

    // TODO: Pass ModelView as a parameter?
    public GameObject(IObject obj, World world) {
        this.obj = obj;
        this.body = BodyBuilder.createBody(world, obj);
        this.world = world;
    }

    public IObject getObject() {
        return obj;
    }

    public Body getBody() {
        return body;
    }

    public void syncPosition() {
        Vector2 newPos = body.getPosition();
        obj.setPosition(newPos);
    }





    private void dispose() {
        world.destroyBody(body);
    }
}
