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


    @Override
    public void beginContact(Contact contact) {

        GameObject gameObjectA = (GameObject) contact.getFixtureA().getUserData();
        GameObject gameObjectB = (GameObject) contact.getFixtureB().getUserData();

        IModel objA = gameObjectA.getObject();
        IModel objB = gameObjectB.getObject();


        //TODO: oneIsPlayer, oneIsBomb, and full implementation
        boolean oneIsBlock = objA instanceof IBlock || objB instanceof IBlock;
        boolean oneIsPowerUp = objA instanceof IPowerUp || objB instanceof IPowerUp;

        boolean oneIsPlayer = objA instanceof IPlayer || objB instanceof NormalPlayer;
        boolean oneIsBomb = objA instanceof IBomb || objB instanceof IBomb;
        boolean oneIsFire = objA instanceof IFire || objB instanceof IFire;
        boolean oneIsDesBlock = objA instanceof DestructibleBlock || objB instanceof DestructibleBlock;

        if (oneIsBlock && oneIsPowerUp) System.out.println("Collision block and powerup");
        if (oneIsBlock && oneIsPlayer) System.out.println("Collision block and player");
        if (oneIsBlock && oneIsFire) System.out.println("Collision fire and block");

        if (oneIsPlayer && oneIsPowerUp){
            System.out.println("Collision PowerUp and NormalPlayer");
            if (objA instanceof IPowerUp){
                ((IPowerUp) objA).handlePickedUp(objB);
            }
            else ((IPowerUp) objB).handlePickedUp(objA);
        }

        if (oneIsBomb && oneIsPlayer){
            System.out.println("Collision NormalPlayer and NormalBomb");
        }

        if (oneIsPlayer && oneIsFire){
            System.out.println("Collision player and NormalFire");
        }

        if (oneIsFire && oneIsDesBlock){
            System.out.println("Collision fire and destructible block");
            if(objA instanceof DestructibleBlock){
                ((IBlock) objA).handleHitByBomb();
            } else {
                ((IBlock) objB).handleHitByBomb();
            }
        }

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