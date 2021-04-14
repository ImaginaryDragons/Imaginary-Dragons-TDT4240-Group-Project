package com.dragons.game.model.gameWorld;

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
import com.dragons.game.model.blocks.BlockType;
import com.dragons.game.model.blocks.IBlock;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.model.bombs.IBomb;
import com.dragons.game.model.bombs.fires.IFire;
import com.dragons.game.model.players.IPlayer;
import com.dragons.game.model.players.PlayerType;
import com.dragons.game.model.powerUps.IPowerUp;
import com.dragons.game.model.powerUps.PowerUpType;

import org.jetbrains.annotations.NotNull;

import static com.dragons.game.utilities.Constants.PPM;

public final class BodyBuilder {

    private BodyBuilder() {
    }

    // Create a body and a fixture for the object and place it in world!

    public static Body createBody(World world, GameObject gameObject) {
        IModel model = gameObject.getObject();
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
        //fixtureDef.friction = 0;

        // This is for the contactListener
        body.createFixture(fixtureDef).setUserData(gameObject);
        shape.dispose();

        return body;
    }

    private static Shape getShape(@NotNull IModel iModel){
        Model model = (Model) iModel;
        if      (model instanceof IPowerUp) return getPowerUpShape(model);
        else if (model instanceof IBlock)   return getBlockShape(model);
        else if (model instanceof IPlayer)  return getPlayerShape(model);
        else if (model instanceof IBomb)    return getBombShape(model);
        else if (model instanceof IFire)    return getFireShape(model);
        else throw new IllegalArgumentException("Wrong IModel type as argument");
    }

    private static Shape getPowerUpShape(Model model){
        PowerUpType type = (PowerUpType) model.getType(); // Use for case statement if necessary
        final PolygonShape shape = new PolygonShape();
        shape.setAsBox(model.getWidth() / 2 / PPM, model.getHeight() / 2 / PPM);
        return shape;
    }

    private static Shape getBlockShape(Model model){
        BlockType type = (BlockType) model.getType(); // Use for case statement if necessary
        final PolygonShape shape = new PolygonShape();
        shape.setAsBox(model.getWidth() / 2 / PPM, model.getHeight() / 2 / PPM);
        return shape;
    }

    private static Shape getPlayerShape(Model model){
        PlayerType type = (PlayerType) model.getType();

        switch (type){
            case NORMALPLAYER:
                final PolygonShape normalPlayerShape = new PolygonShape();
                normalPlayerShape.setAsBox(model.getWidth() / 2 / PPM, model.getHeight() / 2 / PPM);
                return normalPlayerShape;

            default:
                throw new IllegalArgumentException("Wrong type");
        }
    }

    private static Shape getBombShape(Model model){
        BombType type = (BombType) model.getType();

        switch (type){
            case NORMALBOMB:
                final CircleShape normalBomb = new CircleShape();
                normalBomb.setRadius(model.getHeight() / 2 / PPM);
                return normalBomb;

            default:
                throw new IllegalArgumentException("Wrong type");
        }
    }

    private static Shape getFireShape(Model model){
        BombType type = (BombType) model.getType();
        switch (type){
            case NORMALBOMB:
                final PolygonShape normalFireShape = new PolygonShape();
                normalFireShape.setAsBox(model.getWidth() / 2 / PPM, model.getHeight() / 2 / PPM);
                return normalFireShape;

            default:
                throw new IllegalArgumentException("Wrong type");
        }
    }

}