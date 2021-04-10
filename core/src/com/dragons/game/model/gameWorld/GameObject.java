package com.dragons.game.model.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.IModel;
import com.dragons.game.view.modelViews.ModelView;

import static java.util.Objects.isNull;


public class GameObject {

    // https://gamedev.stackexchange.com/questions/88455/how-can-i-attach-a-libgdx-actor-to-a-box2d-body

    private final IModel obj;
    private ModelView objView;
    private final Body body;
    private final World world;

    // TODO: Pass ModelView as a parameter?
    public GameObject(IModel obj, ModelView objView, World world) {
        Gdx.app.log("GameObject", "Creating game object");
        this.obj = obj;
        this.world = world;
        this.objView = objView;
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

    public void syncPosition() {
        Vector2 newPos = body.getPosition();
        obj.setPosition(newPos);
    }

    private void dispose() {
        world.destroyBody(body);
    }
}
