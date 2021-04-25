package com.dragons.game.model.bombs.hitByFireStrategies;

import com.dragons.game.model.bombs.Bomb;

public class Explode implements IHitByFireStrategy {
    @Override
    public void handleHitByFire(Bomb bomb) {
        bomb.detonateBomb();
    }
}
