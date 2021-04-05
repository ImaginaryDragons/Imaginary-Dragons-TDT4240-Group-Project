package com.dragons.game.model.blocks;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import java.awt.Shape;

public class DestructibleBlock extends Block{

    public DestructibleBlock(Vector2 position, BlockType type, float width, float height) {
        super(position, type, width, height);

    }

    @Override
    public void handleHitByBomb() {
        // TODO: IMPLEMENT METHOD
    }
}
