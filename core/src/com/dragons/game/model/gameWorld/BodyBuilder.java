package com.dragons.game.model.gameWorld;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.IModelType;
import com.dragons.game.model.IObject;

import static com.dragons.game.utilities.Constants.PPM;

public final class BodyBuilder {



    // Create a body and a fixture for the object and place it in world!

    public static Body createBody(World world, IObject object) {

        boolean isStatic = object.isStatic();
        boolean isSensor = object.isSensor();
        Vector2 position = object.getPosition();
        Shape shape = object.getShape();
        IModelType modelType = object.getType();



        BodyDef bodyDef = new BodyDef();
        bodyDef.type = isStatic ? BodyDef.BodyType.StaticBody : BodyDef.BodyType.DynamicBody;
        bodyDef.fixedRotation = true;


        // World units = meters
        // From world to screen -> Divide by Pixel Per Meter
        bodyDef.position.set(position.x / PPM, position.y / PPM);
        Body body = world.createBody(bodyDef);



        // TODO: FIX FILTERING FOR THE BODIES, EXAMPLE => players shouldnt collide with eachother
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.isSensor = isSensor;
        //TODO: Find real density! We might not need to have different densities
        fixtureDef.density = 1;

        // This is for the contactListener
        body.createFixture(fixtureDef).setUserData(modelType);
        shape.dispose();

        return body;
    }
}