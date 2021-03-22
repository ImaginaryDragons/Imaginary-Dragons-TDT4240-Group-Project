package com.dragons.game.model.blockFactory.blocks;

import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.blockFactory.BlockType;
import com.dragons.game.utilities.BodyBuilder;
import com.dragons.game.view.modelViews.IModelObserver;

import static com.dragons.game.utilities.ContactType.WALL;

public class WallBlock extends Block{

    // TODO: ADD TILE TO FIELD

    public WallBlock(IModelObserver observer, World world, BlockType type) {
        super(observer);
        body = BodyBuilder.createBoxBody(x, y, width, height, world, true, WALL, 0f);
        this.type = type;
    }

    @Override
    public void handleHitByBomb() {
        // TODO: IMPLEMENT METHOD
    }

}
