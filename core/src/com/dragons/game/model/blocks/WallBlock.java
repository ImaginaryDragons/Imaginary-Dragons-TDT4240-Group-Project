package com.dragons.game.model.blocks;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.dragons.game.model.Object;

import static com.dragons.game.utilities.Constants.PPM;


public class WallBlock extends Object implements IBlock {


    private static final boolean isStatic = true;
    private static final boolean isSensor = false;

    public WallBlock(Vector2 position, BlockType type, float width, float height) {
        super(position, type, width, height, isStatic, isSensor);
        final PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2 / PPM, height / 2 / PPM);
        super.setShape(shape);

    }


    @Override
    public void handleHitByBomb() {
        // TODO: Implement or do nothing somehow (Strategy pattern maybe?)
    }

}
