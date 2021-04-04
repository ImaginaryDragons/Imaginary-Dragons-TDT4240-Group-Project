package com.dragons.game.model.blocks;


import com.badlogic.gdx.math.Vector2;


public class WallBlock extends Block{


    public WallBlock(Vector2 position, BlockType type, float width, float height) {
        super(position, type, width, height);
    }




    @Override
    public void handleHitByBomb() {
        // TODO: Implement or do nothing somehow
    }

}
