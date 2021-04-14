package com.dragons.game.model.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.IModel;
import com.dragons.game.model.blocks.IBlock;
import com.dragons.game.model.player.PlayerType;
import com.dragons.game.view.modelViews.IModelView;
import com.dragons.game.view.modelViews.ModelViewFactory;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.Constants.PPM;


public class GameObject {

    // https://gamedev.stackexchange.com/questions/88455/how-can-i-attach-a-libgdx-actor-to-a-box2d-body

    private final IModel model;
    private final IModelView modelView;
    private final Body body;
    private final World world;



    public GameObject(IModel model, World world, AnnotationAssetManager assetManager) {
        Gdx.app.log("GameObject", "Creating game object");
        this.model = model;
        this.world = world;
        this.modelView = ModelViewFactory.getInstance().createModelView(model, assetManager);
        this.body = BodyBuilder.createBody(world, this);

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
            Vector2 bodyPosition = body.getPosition();
            // Multiply by PPM since world position is in meters
            Vector2 newPos = new Vector2(bodyPosition.x * PPM, bodyPosition.y * PPM);
            model.setPosition(newPos);

        }
    }
    // TODO: remove need for position as argument, encapsulate in controller instead
    public void update(float delta){
        if (modelView != null) modelView.update(delta);
    }




    private void dispose() {
        world.destroyBody(body);


    }
}
