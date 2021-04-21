package com.dragons.game.model.players;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.model.bombs.IBomb;
import com.dragons.game.model.modelFactories.BombFactory;
import com.dragons.game.model.players.playerEnums.Direction;
import com.dragons.game.utilities.Constants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * Instantiates a player. Has to be tied to a controller to control.
 * int ID, Vector2 startPos, Color color
 *
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

        bombRange = Constants.InitBombRange;
        hitProtectionTime = Constants.FireDisplayTime + 1f; // TODO: magic number
        bombInventory = new LinkedList<>();
        for (int i = 0; i < bombCapacity; i++) {
            bombInventory.add(super.createBomb(startPos, startingBomb, width, height, bombRange));
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
