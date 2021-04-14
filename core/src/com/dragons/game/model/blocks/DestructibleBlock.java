package com.dragons.game.model.blocks;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.Model;

public class DestructibleBlock extends Model implements IBlock {

    private static final boolean isStatic = true;
    private static final boolean isSensor = false;

    public DestructibleBlock(Vector2 position, BlockType type, float width, float height) {
        super(position, type, width, height, isStatic, isSensor);

    }

    @Override
    public void handleHitByBomb() {
        // TODO: IMPLEMENT METHOD
    }
}
