package com.dragons.game.controller.gameWorld;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.dragons.game.controller.ContactController;


public class WorldContactListener implements ContactListener {

    private final ContactController contactController;

    public WorldContactListener() {
        contactController = new ContactController();
    }

    @Override
    public void beginContact(Contact contact) {

        GameObject gameObjectA = (GameObject) contact.getFixtureA().getUserData();
        GameObject gameObjectB = (GameObject) contact.getFixtureB().getUserData();

        contactController.handleContact(gameObjectA.getModel(), gameObjectB.getModel());
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