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
 * This class is used as a container and mediator for the models, views, and Box2D objects to decrease dependancies.
 * The class is used in combination with the GameWorld class to encapsulate the physics engine to the
 * GameWorld package and decouple the models and the views.
 */
public class GameObject {

    private IModel model;
    private IModelView modelView;
    private Body body;

    public GameObject(IModel model, World world, AnnotationAssetManager assetManager) {
        this.model = model;
        this.modelView = ModelViewFactory.getInstance().createModelView(model, assetManager);
        this.body = BodyBuilder.getInstance().createBody(world, this);
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
        this.model = null;
        this.modelView = null;
        this.body = null;

    }


    public void setLinearVelocity(float x, float y){
        body.setLinearVelocity(x, y);
    }

    public Body getBody() {
        return body;
    }

    public IModel getModel() {
        return model;
    }

    public boolean isDisposable(){
        return model.isDisposed();
    }

}
