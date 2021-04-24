package com.dragons.game.view.modelViews;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.IModel;
import com.dragons.game.utilities.Constants;
import com.dragons.game.view.IView;


public abstract class ModelView implements IModelView{
    protected static final float FRAME_DURATION = Constants.FRAME_DURATION;
    private static float state_time = 0;
    private final IModel model;

    // Helper method
    protected abstract void draw(SpriteBatch batch, float x, float y, float width, float height, float state_time);

    public ModelView(IModel model) {
        this.model =  model;

    }

    @Override
    public void update(float delta) {
        state_time += delta;
    }

    // Template Method
    @Override
    public void render(SpriteBatch batch) {
        float x = model.getPosition().x;
        float y = model.getPosition().y;
        float width = model.getWidth();
        float height = model.getHeight();

        draw(batch, x, y, width, height, state_time);

    }
}
