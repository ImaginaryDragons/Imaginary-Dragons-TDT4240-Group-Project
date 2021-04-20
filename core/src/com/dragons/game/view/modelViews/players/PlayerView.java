package com.dragons.game.view.modelViews.players;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.IModel;
import com.dragons.game.model.players.IPlayer;
import com.dragons.game.utilities.Constants;
import com.dragons.game.view.modelViews.IModelView;


public abstract class PlayerView implements IModelView {
    protected static final float FRAME_DURATION = Constants.FRAME_DURATION;
    private  Animation<Texture> animation;
    private static float state_time = 0;
    private final IPlayer player;


    public PlayerView(IModel model) {
        player = (IPlayer) model;
    }

    @Override
    public void update(float delta){
        state_time +=  delta;
    }

    @Override
    public void setAnimation(Animation<Texture> animation) {
        this.animation = animation;
    }


    @Override
    public void render(SpriteBatch batch) {
        final Texture current_frame = animation.getKeyFrame(state_time, true);
        float x = player.getPosition().x;
        float y = player.getPosition().y;
        float width = player.getWidth();
        float height = player.getHeight();
        final int rotation;

        switch (player.getOrientation()){
            case UP:
                rotation = 0;
                break;
            case LEFT:
                rotation = 90;
                break;
            case DOWN:
                rotation = 180;
                break;
            case RIGHT:
                rotation = 270;
                break;
            default:
                throw new IllegalArgumentException("Wrong direction in PlayerView");
        }

        batch.draw(current_frame, x - width / 2f, y - height / 2f, width / 2f,
                height / 2f, width, height, 1, 1, rotation, 1,
                1, current_frame.getWidth(), current_frame.getHeight(), false, false);

    }
}
