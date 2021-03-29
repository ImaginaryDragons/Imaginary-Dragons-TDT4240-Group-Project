package com.dragons.game.model.blockFactory.blocks;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.view.modelViews.IModelObserver;

/**
 * @author Jakob Eikeland and Elise Bø
 * */

public class DestructibleBlock extends Block{

    private Vector2 pos;
    private Rectangle bounds;

    public DestructibleBlock(Vector2 pos, float width, float height) {
        this.pos = pos;
        bounds.set(pos.x, pos.y, width, height);
    }

    /**NOTE: All of the classes below are pretty much similar to in WallBlock. Maybe it
     * would be nice to implement them in abstract block instead?**/

    @Override
    public void setPosition(Vector2 pos) {
        bounds.setPosition(pos.x, pos.y);
    }

    @Override
    public Vector2 getPosition() {
        return bounds.getPosition(pos);
    }

    @Override
    public void setShape(Shape2D rectBounds) {
        bounds.set((Rectangle)rectBounds);
    }

    @Override
    public Rectangle getShape() {
        return bounds;
    }


    @Override
    public void handleHitByBomb() {
        // TODO: Implement method
    }
}
