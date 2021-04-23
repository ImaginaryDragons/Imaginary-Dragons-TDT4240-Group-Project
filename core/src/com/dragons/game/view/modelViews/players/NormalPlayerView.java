package com.dragons.game.view.modelViews.players;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.IModel;
import com.dragons.game.model.players.IPlayer;
import com.dragons.game.view.modelViews.ModelView;

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

public class NormalPlayerView extends ModelView {
    private final Animation<Texture> animation;

    IPlayer player;

    public NormalPlayerView(IModel model, AnnotationAssetManager manager) {
        super(model);
        player = (IPlayer) model;
        Texture[] textures = getTextures(player.getColor(), manager);
        animation = new Animation<>(FRAME_DURATION, textures);
        animation.setPlayMode(Animation.PlayMode.LOOP);

    }

    @Override
    protected void draw(SpriteBatch batch, float x, float y, float width, float height, float state_time) {
        final Texture current_frame = animation.getKeyFrame(state_time, true);

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

    private Texture[] getTextures(Color color, AnnotationAssetManager manager){
        Texture[] textures;
        if (Color.RED.equals(color)) {
            textures = new Texture[]{
                manager.get(DRAGON_SLIM_RED, Texture.class),
                manager.get(DRAGON_MIDDLE_RED, Texture.class),
                manager.get(DRAGON_WIDE_RED, Texture.class),
                manager.get(DRAGON_MIDDLE_RED, Texture.class)
            };

        } else if (Color.BLUE.equals(color)) {
            textures = new Texture[]{
                    manager.get(DRAGON_SLIM_BLUE, Texture.class),
                    manager.get(DRAGON_MIDDLE_BLUE, Texture.class),
                    manager.get(DRAGON_WIDE_BLUE, Texture.class),
                    manager.get(DRAGON_MIDDLE_BLUE, Texture.class),
            };

        } else if (Color.GREEN.equals(color)) {
            textures = new Texture[]{
                    manager.get(DRAGON_SLIM_GREEN, Texture.class),
                    manager.get(DRAGON_MIDDLE_GREEN, Texture.class),
                    manager.get(DRAGON_WIDE_GREEN, Texture.class),
                    manager.get(DRAGON_MIDDLE_GREEN, Texture.class),
            };

        } else if (Color.YELLOW.equals(color)) {
            textures = new Texture[]{
                    manager.get(DRAGON_SLIM_YELLOW, Texture.class),
                    manager.get(DRAGON_MIDDLE_YELLOW, Texture.class),
                    manager.get(DRAGON_WIDE_YELLOW, Texture.class),
                    manager.get(DRAGON_MIDDLE_YELLOW, Texture.class)
            };

        } else {
            throw new IllegalArgumentException("Wrong Color in PlayerView");
        }
        return textures;
    }



}
