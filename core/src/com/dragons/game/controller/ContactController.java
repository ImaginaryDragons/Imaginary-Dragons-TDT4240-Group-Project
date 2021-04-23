package com.dragons.game.controller;

import com.dragons.game.model.IModel;
import com.dragons.game.model.blocks.IBlock;
import com.dragons.game.model.bombs.IBomb;
import com.dragons.game.model.bombs.fires.IFire;
import com.dragons.game.model.players.IPlayer;
import com.dragons.game.model.players.NormalPlayer;
import com.dragons.game.model.powerUps.IPowerUp;

public class ContactController {

    public void handleContact(IModel objA, IModel objB){

        // Identify what kind of objects are in contact
        boolean oneIsBlock =    objA instanceof IBlock   || objB instanceof IBlock;
        boolean oneIsPowerUp =  objA instanceof IPowerUp || objB instanceof IPowerUp;
        boolean oneIsPlayer =   objA instanceof IPlayer  || objB instanceof IPlayer;
        boolean oneIsBomb =     objA instanceof IBomb    || objB instanceof IBomb;
        boolean oneIsFire =     objA instanceof IFire    || objB instanceof IFire;


        // Call the objects action based on interaction type

        if (oneIsPlayer && oneIsPowerUp){
            //System.out.println("Collision PowerUp and Player");
            if (objA instanceof IPowerUp){
                ((IPowerUp) objA).handlePickedUp(objB);
            }
            else ((IPowerUp) objB).handlePickedUp(objA);
        }

        if (oneIsBomb && oneIsPlayer){
            //System.out.println("Collision Player and Bomb");

        }

        if (oneIsPlayer && oneIsFire){
            //System.out.println("Collision Player and Fire");
            if (objA instanceof IPlayer){
                ((IPlayer) objA).handleHitByBomb();
            } else {
                ((IPlayer) objB).handleHitByBomb();
            }
        }

        if (oneIsFire && oneIsBlock){
            if(objA instanceof IBlock){
                ((IBlock) objA).handleHitByBomb();
            } else {
                ((IBlock) objB).handleHitByBomb();
            }
        }

        if (oneIsFire && oneIsBomb){
            //System.out.println("Collision fire and bomb");
            if(objA instanceof IBomb){
                ((IBomb) objA).hitByFire();
            }
            else {
                ((IBomb) objB).hitByFire();
            }
        }
    }

}
