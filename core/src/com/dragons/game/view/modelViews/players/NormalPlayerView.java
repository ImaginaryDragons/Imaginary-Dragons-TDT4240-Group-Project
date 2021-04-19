package com.dragons.game.view.modelViews.players;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.IModel;
import com.dragons.game.model.players.IPlayer;
import com.dragons.game.model.players.NormalPlayer;
import com.dragons.game.utilities.Direction;
import com.dragons.game.view.modelViews.IModelView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;


import static com.dragons.game.utilities.AssetLoader.DRAGON_MIDDLE_BLUE;
import static com.dragons.game.utilities.AssetLoader.DRAGON_MIDDLE_GREEN;
import static com.dragons.game.utilities.AssetLoader.DRAGON_MIDDLE_RED;
import static com.dragons.game.utilities.AssetLoader.DRAGON_MIDDLE_YELLOW;
import static com.dragons.game.utilities.AssetLoader.DRAGON_SLIM_BLUE;
import static com.dragons.game.utilities.AssetLoader.DRAGON_SLIM_GREEN;
import static com.dragons.game.utilities.AssetLoader.DRAGON_SLIM_RED;
import static com.dragons.game.utilities.AssetLoader.DRAGON_SLIM_YELLOW;
import static com.dragons.game.utilities.AssetLoader.DRAGON_WIDE_BLUE;
import static com.dragons.game.utilities.AssetLoader.DRAGON_WIDE_GREEN;
import static com.dragons.game.utilities.AssetLoader.DRAGON_WIDE_RED;
import static com.dragons.game.utilities.AssetLoader.DRAGON_WIDE_YELLOW;

public class NormalPlayerView implements IModelView {

    private static final float FRAME_DURATION = 0.1f;
    private final Animation<Texture> dragon;
    private static float state_time;
    private final IPlayer player;


    public NormalPlayerView(IModel model, AnnotationAssetManager manager) {
        player = (NormalPlayer) model;
        final Color col = player.getColor();
        Texture[] dragonTextures;
        if (Color.RED.equals(col)) {
            dragonTextures = new Texture[]{
                    manager.get(DRAGON_SLIM_RED, Texture.class),
                    manager.get(DRAGON_MIDDLE_RED, Texture.class),
                    manager.get(DRAGON_WIDE_RED, Texture.class),
                    manager.get(DRAGON_MIDDLE_RED, Texture.class)
            };

        } else if (Color.BLUE.equals(col)) {
            dragonTextures = new Texture[]{
                    manager.get(DRAGON_SLIM_BLUE, Texture.class),
                    manager.get(DRAGON_MIDDLE_BLUE, Texture.class),
                    manager.get(DRAGON_WIDE_BLUE, Texture.class),
                    manager.get(DRAGON_MIDDLE_BLUE, Texture.class),
            };

        } else if (Color.GREEN.equals(col)) {
            dragonTextures = new Texture[]{
                    manager.get(DRAGON_SLIM_GREEN, Texture.class),
                    manager.get(DRAGON_MIDDLE_GREEN, Texture.class),
                    manager.get(DRAGON_WIDE_GREEN, Texture.class),
                    manager.get(DRAGON_MIDDLE_GREEN, Texture.class),
            };

        } else if (Color.YELLOW.equals(col)) {
            dragonTextures = new Texture[]{
                    manager.get(DRAGON_SLIM_YELLOW, Texture.class),
                    manager.get(DRAGON_MIDDLE_YELLOW, Texture.class),
                    manager.get(DRAGON_WIDE_YELLOW, Texture.class),
                    manager.get(DRAGON_MIDDLE_YELLOW, Texture.class)
            };

        } else {
            throw new IllegalArgumentException("Wrong Color in PlayerView");
        }
        dragon = new Animation<>(FRAME_DURATION, dragonTextures);
        dragon.setPlayMode(Animation.PlayMode.LOOP);
        state_time = 0f;

    }

    @Override
    public void update(float delta){
        state_time +=  delta;
    }



    @Override
    public void render(SpriteBatch batch) {
        final Texture current_frame = dragon.getKeyFrame(state_time, true);
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
                throw new IllegalArgumentException("Wrong direction in NormalPlayerView");
        }

        batch.draw(current_frame, x - width / 2f, y - height / 2f, width / 2f,
                height / 2f, width, height, 1, 1, rotation, 1,
                1, current_frame.getWidth(), current_frame.getHeight(), false, false);

    }
}
