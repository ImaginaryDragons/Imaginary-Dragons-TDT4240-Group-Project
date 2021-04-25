package com.dragons.game.model.blocks;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.Model;

public class DestructibleBlock extends Model implements IBlock {

    private static final boolean isStatic = true; // Is the model stationary or dynamic?
    private static final boolean isSensor = false; // Is the model a sensor that doesnt have IView physical body in the gameworld?

    public DestructibleBlock(Vector2 position, float width, float height) {
        super(position, width, height, isStatic, isSensor);
    }

    @Override
    public void handleHitByBomb() {
        super.dispose();  // Disposes itself from the gameworld if hit by IView bomb
    }
}
