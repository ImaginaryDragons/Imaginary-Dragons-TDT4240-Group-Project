package com.dragons.game.model.bombs.hitByFireStrategies;

import com.dragons.game.model.bombs.Bomb;

public class DoNothing implements IHitByFireStrategy {
    @Override
    public void handleHitByFire(Bomb bomb) {
        // do nothing
    }
}
