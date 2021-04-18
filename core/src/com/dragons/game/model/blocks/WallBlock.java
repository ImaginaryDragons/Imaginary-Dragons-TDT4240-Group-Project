package com.dragons.game.model.blocks;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.dragons.game.model.Model;

public class WallBlock extends Model implements IBlock {

    private static final boolean isStatic = true;
    private static final boolean isSensor = false;


    public WallBlock(Vector2 position, BlockType type, float width, float height) {
        super(position, width, height, isStatic, isSensor);



    }

    @Override
    public void handleHitByBomb() {
        // TODO: Implement or do nothing somehow (Strategy pattern maybe?)
    }

}
