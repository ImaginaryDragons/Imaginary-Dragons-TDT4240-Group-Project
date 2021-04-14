package com.dragons.game.model.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.IModel;
import com.dragons.game.view.modelViews.IModelView;

import static com.dragons.game.utilities.Constants.PPM;


public class GameObject {

    // https://gamedev.stackexchange.com/questions/88455/how-can-i-attach-a-libgdx-actor-to-a-box2d-body

    private final IModel obj;
    private IModelView objView;
    private Body body;
    private final World world;
    public boolean isStatic;
    public boolean isSensor;
    public boolean destroyObject;

    // TODO: Pass IModelView as a parameter?
    public GameObject(IModel obj, IModelView objView, World world) {
        Gdx.app.log("GameObject", "Creating game object");
        this.obj = obj;
        this.world = world;
        this.objView = objView;
        this.isStatic = false;
        this.isSensor = false;
        this.destroyObject = false;
        this.body = null;
    }



    public void createBody() {
        this.body = BodyBuilder.createBody(world, this);
    }

    public IModelView getModelView() {
        return objView;
    }

    public IModel getObject() {
        return obj;
    }

    public Body getBody() {
        return body;
    }

    public void syncPosition() {
        if (body != null) {
            Vector2 bodyPosition = body.getPosition();
            // Multiply by PPM since world position is in meters
            Vector2 newPos = new Vector2(bodyPosition.x * PPM, bodyPosition.y * PPM);
            obj.setPosition(newPos);
        }
    }

    public void dispose() {
        world.destroyBody(body);
    }
}
