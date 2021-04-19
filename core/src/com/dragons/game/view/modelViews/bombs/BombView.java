package com.dragons.game.view.modelViews.bombs;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.IModel;
import com.dragons.game.view.modelViews.IModelView;

public abstract class BombView implements IModelView {

    protected static final float FRAME_DURATION = 0.1f;
    private Animation<Texture> bombAnimation;
    private static float state_time = 0;
    private final IModel bomb;

    public BombView(IModel model) {
        bomb = model;
    }

    protected void setBombAnimation(Animation<Texture> animation){
        bombAnimation = animation;
    }

    @Override
    public void update(float delta) {
        state_time += delta;
    }

    @Override
    public void render(SpriteBatch batch) {
        final Texture current_frame = bombAnimation.getKeyFrame(state_time, true);
        float x = bomb.getPosition().x;
        float y = bomb.getPosition().y;
        float width = bomb.getWidth();
        float height = bomb.getHeight();

        batch.draw(current_frame, x - height / 2f, y - height / 2f , width, height);
    }
}
