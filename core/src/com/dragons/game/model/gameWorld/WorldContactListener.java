package com.dragons.game.model.gameWorld;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.dragons.game.model.IModelType;
import com.dragons.game.model.PowerUps.PowerUpType;
import com.dragons.game.model.blocks.BlockType;

public class WorldContactListener implements ContactListener {


    @Override
    public void beginContact(Contact contact) {

        //TODO: fixtures might not be needed, only the type?
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();

        IModelType aType = (IModelType) fixtureA.getUserData();
        IModelType bType = (IModelType) fixtureB.getUserData();

        boolean oneIsPowerUp = oneIsPowerUp(aType, bType);
        boolean oneIsBlock = oneIsBlock(aType, bType);
        //TODO: oneIsPlayer, oneIsBomb, and full implementation


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

    private static boolean oneIsPowerUp(IModelType aType, IModelType bType) {
        for (IModelType type : PowerUpType.values()) {
            if (type == aType || type == bType) {
                return true;
            }

        }
        return false;
    }

    private static boolean oneIsBlock(IModelType aType, IModelType bType) {
        for (IModelType type : BlockType.values()) {
            if (type == aType || type == bType) {
                return true;
            }
        }
        return false;
    }
}