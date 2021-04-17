package com.dragons.game.view.modelViews;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public interface IModelView {

    void update(float delta);

    void render(SpriteBatch sb);
}
