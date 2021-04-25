package com.dragons.game.controller.gameWorld;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.IModel;
import com.dragons.game.view.modelViews.IModelView;
import com.dragons.game.view.modelViews.modelViewFactories.ModelViewFactory;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.Constants.PPM;

/**
 * This class is the Mediator which is used as a container for the models, views, and Box2D objects.
 * The class is used in combination with the GameWorld class to encapsulate the physics engine to the
 * GameWorld package and decouple the models and the views.
 */
public class GameObject {

    private IModel model;
    private IModelView modelView;
    private final Body body;
    private final World world;
    public boolean destroyObject;

    public GameObject(IModel model, World world, AnnotationAssetManager assetManager) {
        this.model = model;
        this.world = world;
        this.modelView = ModelViewFactory.getInstance().createModelView(model, assetManager);
        this.body = BodyBuilder.getInstance().createBody(world, this);
        this.destroyObject = false;
    }


    public void syncPosition() {
        if (body != null) {
            // Multiply by Pixel Per Meter since world position is in meters
            float x = body.getPosition().x * PPM;
            float y = body.getPosition().y * PPM;
            model.setPosition(x, y);
        }
    }

    public void update(float delta){
        model.update(delta);
        if (modelView != null) modelView.update(delta);
    }

    public void render(SpriteBatch batch){
        if (modelView != null) modelView.render(batch);
    }

    public void dispose() {
        world.destroyBody(body);
        this.model = null;
        this.modelView = null;
    }

    public void setLinearVelocity(float x, float y){
        body.setLinearVelocity(x, y);
    }


    public IModel getModel() {
        return model;
    }

    public boolean isDisposable(){
        return model.isDisposed();
    }

}
