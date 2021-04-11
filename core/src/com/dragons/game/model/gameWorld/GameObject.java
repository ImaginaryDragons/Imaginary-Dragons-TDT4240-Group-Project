package com.dragons.game.model.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.IModel;
import com.dragons.game.view.modelViews.ModelView;

import static com.dragons.game.utilities.Constants.PPM;
import static java.util.Objects.isNull;


public class GameObject {

    // https://gamedev.stackexchange.com/questions/88455/how-can-i-attach-a-libgdx-actor-to-a-box2d-body

    private final IModel obj;
    private ModelView objView;
    private Body body;
    private final World world;
    public boolean isStatic;
    public boolean isSensor;

    // TODO: Pass ModelView as a parameter?
    public GameObject(IModel obj, ModelView objView, World world) {
        Gdx.app.log("GameObject", "Creating game object");
        this.obj = obj;
        this.world = world;
        this.objView = objView;
        this.isStatic = false;
        this.isSensor = false;
        this.body = null;
        //this.body = BodyBuilder.createBody(world, this);
    }

    public void createBody() {
        this.body = BodyBuilder.createBody(world, this);
    }

    public void setModelView(ModelView view) {
        this.objView = view;
    }

    public ModelView getModelView() {
        return objView;
    }

    public IModel getObject() {
        return obj;
    }

    public Body getBody() {
        return body;
    }

    // TODO: FIX VIBRATING PLAYERS, velocity is 0 but bodyposition is changing?
    public void syncPosition() {
        //boolean haveVelocity = body.getLinearVelocity().x != 0 && body.getLinearVelocity().y != 0;
        //Gdx.app.log(body.getLinearVelocity().toString(), "linear Velocity");
        //System.out.println(body.getPosition().toString());
        if (body != null) {
            Vector2 newPos = body.getPosition();
            // Multiply by PPM since world position is in meters
            newPos.x *= PPM;
            newPos.y *= PPM;
            obj.setPosition(newPos);
        }
    }

    private void dispose() {
        world.destroyBody(body);

    }
}
