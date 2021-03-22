package com.dragons.game.model.powerUpFactory.PowerUps;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.powerUpFactory.PowerUpType;
import com.dragons.game.view.modelViews.IModelObserver;

public class IncreaseSpeed extends PowerUp{

    // TODO: ADD FIELDS
    // private Tile tile etc

    public IncreaseSpeed(IModelObserver observer, World world, PowerUpType type) {
        super(observer, world);
        this.type = type;
    }

    // TODO: IMPLEMENT METHODS

    @Override
    public void whenPickedUp() {

    }

}
