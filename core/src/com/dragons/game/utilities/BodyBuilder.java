package com.dragons.game.utilities;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import static com.dragons.game.utilities.Constants.PPM;

public final class BodyBuilder {

    public static Body createBoxBody(float x, float y, float width, float height, World world,
                                  boolean isStatic, ContactType contactType, float density){

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = isStatic ? BodyDef.BodyType.StaticBody : BodyDef.BodyType.DynamicBody;
        bodyDef.fixedRotation = true;

        // World units = meters
        // From world to screen -> Divide by Pixel Per Meter
        bodyDef.position.set(x / PPM, y / PPM);
        Body body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2 / PPM, height / 2 / PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = density;

        // This is for the contactListener
        body.createFixture(fixtureDef).setUserData(contactType);
        shape.dispose();

        return body;
    }
}
