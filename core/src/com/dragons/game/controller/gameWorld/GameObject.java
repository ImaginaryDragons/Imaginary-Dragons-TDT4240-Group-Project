package com.dragons.game.controller.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.IModel;
import com.dragons.game.view.modelViews.IModelView;
import com.dragons.game.view.modelViews.modelViewFactories.ModelViewFactory;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.Constants.PPM;


public class GameObject {

    // https://gamedev.stackexchange.com/questions/88455/how-can-i-attach-a-libgdx-actor-to-a-box2d-body

    private IModel model;
    private IModelView modelView;
    private final Body body;
    private final World world;
    public boolean destroyObject;

    public GameObject(IModel model, World world, AnnotationAssetManager assetManager) {
        Gdx.app.log("GameObject", "Creating game object");
        this.model = model;
        this.world = world;
        this.modelView = ModelViewFactory.getInstance().createModelView(model, assetManager);
        this.body = BodyBuilder.createBody(world, this);
        this.destroyObject = false;
    }


    public IModelView getModelView() {
        return modelView;
    }

    public IModel getObject() {
        return model;
    }

    public Body getBody() {
        return body;
    }

    public void syncPosition() {
        if (body != null) {

            // Multiply by PPM since world position is in meters
            float x = body.getPosition().x * PPM;
            float y = body.getPosition().y * PPM;
            model.getPosition().set(x, y);
        }
    }

    // TODO: remove need for position as argument, encapsulate in controller instead
    public void update(float delta){
        model.update(delta);
        if (modelView != null) modelView.update(delta);
    }

    public void dispose() {
        world.destroyBody(body);
        this.model = null;
        this.modelView = null;
    }
}
