package com.dragons.game.controller.gameWorld;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.IModel;
import com.dragons.game.model.Model;
import com.dragons.game.model.blocks.IBlock;
import com.dragons.game.model.bombs.IBomb;
import com.dragons.game.model.bombs.fires.IFire;
import com.dragons.game.model.players.IPlayer;
import com.dragons.game.model.powerUps.IPowerUp;


import org.jetbrains.annotations.NotNull;

import static com.dragons.game.utilities.Constants.PPM;

public final class BodyBuilder {

    private BodyBuilder() {
    }

    // Create IView body and IView fixture for the object and place it in world!

    public static Body createBody(World world, GameObject gameObject) {
        IModel model = gameObject.getModel();
        Vector2 position = model.getPosition();
        Shape shape = getShape(model);
        boolean isStatic = model.isStatic();
        boolean isSensor = model.isSensor();

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
        fixtureDef.friction = 0;
        //fixtureDef.restitution = 0.01f;

        // This is for the contactListener
        body.createFixture(fixtureDef).setUserData(gameObject);
        shape.dispose();

        return body;
    }
    // The shape to each concrete class is not stored in the classes to decouple box2d from the concrete classes
    private static Shape getShape(@NotNull IModel iModel){
        Model model = (Model) iModel;
        if      (model instanceof IPowerUp) return getPowerUpShape(model);
        else if (model instanceof IBlock)   return getBlockShape(model);
        else if (model instanceof IPlayer)  return getPlayerShape(model);
        else if (model instanceof IBomb)    return getBombShape(model);
        else if (model instanceof IFire)    return getFireShape(model);
        else throw new IllegalArgumentException("Wrong IModel type as argument");
    }

    private static Shape getPowerUpShape(IModel model){
        /* Template to add a new shape:
         * if (model instanceof someNewPowerUp){
         *      final SomeShape someNewPowerShape = new SomeShape();
                    shape.setAsBox(model.getWidth() / 2 / PPM, model.getHeight() / 2 / PPM);
                    * or
                    shape.setRadius(model.getHeight() / 2 / PPM)
                    return newPowerUpShape;
         * }
           else*/if (model instanceof IPowerUp){
                    final PolygonShape shape = new PolygonShape();
                    shape.setAsBox(model.getWidth() / 2 / PPM, model.getHeight() / 2 / PPM);
                    return shape;
                  }

        else throw new IllegalArgumentException("Instance of model hasnt been given a shape yet");

    }

    private static Shape getBlockShape(IModel model){
        final PolygonShape shape = new PolygonShape();
        shape.setAsBox(model.getWidth() / 2 / PPM, model.getHeight() / 2 / PPM);
        return shape;
    }
    private static Shape getPlayerShape(IModel model){
        if (model instanceof IPlayer){
            final CircleShape normalPlayerShape = new CircleShape();
            normalPlayerShape.setRadius(model.getHeight() / 2 / PPM);
            return normalPlayerShape;
        }
        else throw new IllegalArgumentException("Instance of model hasnt been given a shape yet");
    }

    private static Shape getBombShape(IModel model){
        if (model instanceof IBomb){
            final CircleShape normalBomb = new CircleShape();
            normalBomb.setRadius(model.getHeight() / 2 / PPM);
            return normalBomb;
        }
        else throw new IllegalArgumentException("Instance of model hasnt been given a shape yet");
    }

    private static Shape getFireShape(IModel model){
        if (model instanceof IFire){
            final PolygonShape normalFireShape = new PolygonShape();
            normalFireShape.setAsBox(model.getWidth() / 2 / PPM, model.getHeight() / 2 / PPM);
            return normalFireShape;
        }
        else throw new IllegalArgumentException("Instance of model hasnt been given a shape yet");
    }

}