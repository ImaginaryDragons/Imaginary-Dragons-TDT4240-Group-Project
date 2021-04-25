package com.dragons.game.model.players.hitByBombStrategies;

import com.dragons.game.model.players.Player;

public class LoseOneLifeAndGetProtection implements IHitByBombStrategy{
    @Override
    public void handleHitByBomb(Player player) {
        if (!player.hitProtectionMode()){
            player.decreaseLife(1);
            player.setHitProtectionMode(true);
        }
    }
}
