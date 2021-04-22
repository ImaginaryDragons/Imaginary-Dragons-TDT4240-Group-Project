package com.dragons.game.view.modelViews;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.IModel;
import com.dragons.game.utilities.Constants;
import com.google.errorprone.annotations.RequiredModifiers;

public abstract class ModelView implements IModelView{
    protected static final float FRAME_DURATION = Constants.FRAME_DURATION;
    private Animation<Texture> animation;
    private static float state_time = 0;
    private final IModel model;


    public ModelView(IModel model) {
        this.model =  model;

    }

    public void setAnimation(final Animation<Texture> animation){
        this.animation = animation;
    }

    @Override
    public void update(float delta) {
        state_time += delta;

    }


    @Override
    public void render(SpriteBatch batch) {
        final Texture current_frame = animation.getKeyFrame(state_time, true);
        float x = model.getPosition().x;
        float y = model.getPosition().y;
        float width = model.getWidth();
        float height = model.getHeight();

        batch.draw(current_frame, x - width / 2f, y - width / 2f, width, height);
    }
}
