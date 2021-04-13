package com.dragons.game.view.modelViews;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface IModelView {

    public void update(float delta);

    public void render(SpriteBatch sb);
}
