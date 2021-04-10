package com.dragons.game.model.gameWorld;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.dragons.game.model.IModel;
import com.dragons.game.model.PowerUps.IPowerUp;
import com.dragons.game.model.blocks.IBlock;

public class WorldContactListener implements ContactListener {


    @Override
    public void beginContact(Contact contact) {

        GameObject gameObjectA = (GameObject) contact.getFixtureA().getUserData();
        GameObject gameObjectB = (GameObject) contact.getFixtureB().getUserData();

        IModel objA = gameObjectA.getObject();
        IModel objB = gameObjectB.getObject();

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