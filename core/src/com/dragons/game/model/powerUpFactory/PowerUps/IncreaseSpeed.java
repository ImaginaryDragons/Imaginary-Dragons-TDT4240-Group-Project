package com.dragons.game.model.powerUpFactory.PowerUps;

import com.badlogic.gdx.graphics.Texture;
import com.dragons.game.view.modelViews.IModelObserver;

public class IncreaseSpeed extends PowerUp{

    // TODO: ADD FIELDS
    // private Tile tile etc

    public IncreaseSpeed(IModelObserver observer) {
        super(observer);
        texture = new Texture("");
    }

    // TODO: IMPLEMENT METHODS

    @Override
    public void whenPickedUp() {

    }

}
