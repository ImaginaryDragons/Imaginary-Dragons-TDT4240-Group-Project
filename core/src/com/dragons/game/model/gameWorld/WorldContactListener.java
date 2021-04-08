package com.dragons.game.model.gameWorld;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.dragons.game.model.IModelType;
import com.dragons.game.model.IObject;
import com.dragons.game.model.PowerUps.BombCapacity;
import com.dragons.game.model.PowerUps.IPowerUp;
import com.dragons.game.model.PowerUps.PowerUpType;
import com.dragons.game.model.blocks.BlockType;
import com.dragons.game.model.blocks.DestructibleBlock;
import com.dragons.game.model.blocks.IBlock;
import com.dragons.game.model.blocks.WallBlock;

public class WorldContactListener implements ContactListener {


    @Override
    public void beginContact(Contact contact) {

        GameObject gameObjectA = (GameObject) contact.getFixtureA().getUserData();
        GameObject gameObjectB = (GameObject) contact.getFixtureB().getUserData();

        IObject objA = gameObjectA.getObject();
        IObject objB = gameObjectB.getObject();

        System.out.println("Collision");


        //TODO: oneIsPlayer, oneIsBomb, and full implementation
        boolean oneIsBlock = objA instanceof IBlock || objB instanceof IBlock;
        boolean oneIsPowerUp = objA instanceof IPowerUp || objB instanceof IPowerUp;

        if (oneIsBlock && oneIsPowerUp) System.out.println("Collision block and powerup");


    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }


}