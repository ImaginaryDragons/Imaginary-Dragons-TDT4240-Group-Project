package com.dragons.game.model.players;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.bombs.BombType;

import com.dragons.game.utilities.Constants;

import java.util.LinkedList;



/**
 * Instantiates player. Has to be tied to playerController to control.
 */



public class NormalPlayer extends Player {

    private static final BombType startingBomb = BombType.NORMALBOMB;

    public NormalPlayer(final int ID, final Vector2 startPos, final Color color, float width, float height) {
        super(startPos, width, height);
        super.ID = ID;
        super.color = color;
        lives = Constants.InitPlayerHealth;
        speed = Constants.PlayerSpeed;
        bombCapacity = Constants.InitBombCap;
        hitProtectionTime = Constants.FireDisplayTime + 1f; // TODO: magic number
        for (int i = 0; i < bombCapacity; i++) {
            bombInventory.add(super.createBomb(startPos, startingBomb, width, height, extraBombRange));
        }

    }

    @Override
    public void handleHitByBomb() {
        if (!hitProtectionMode){
            lives -= 1;
            hitProtectionMode = true;
        }
    }

}
