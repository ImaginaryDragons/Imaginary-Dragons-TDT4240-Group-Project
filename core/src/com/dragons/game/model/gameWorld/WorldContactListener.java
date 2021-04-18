package com.dragons.game.model.gameWorld;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.dragons.game.model.IModel;
import com.dragons.game.model.blocks.DestructibleBlock;
import com.dragons.game.model.blocks.IBlock;
import com.dragons.game.model.bombs.IBomb;
import com.dragons.game.model.bombs.fires.IFire;
import com.dragons.game.model.players.IPlayer;
import com.dragons.game.model.powerUps.IPowerUp;
import com.dragons.game.model.players.NormalPlayer;

public class WorldContactListener implements ContactListener {

    private ContactController contactController;

    public WorldContactListener() {
        contactController = new ContactController();
    }

    @Override
    public void beginContact(Contact contact) {

        GameObject gameObjectA = (GameObject) contact.getFixtureA().getUserData();
        GameObject gameObjectB = (GameObject) contact.getFixtureB().getUserData();

        contactController.handleContact(gameObjectA.getObject(), gameObjectB.getObject());
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