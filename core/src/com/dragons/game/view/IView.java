package com.dragons.game.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface IView {
    void update(float delta);

    void render(SpriteBatch sb);
}
