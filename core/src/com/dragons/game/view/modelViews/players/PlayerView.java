package com.dragons.game.view.modelViews.players;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
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

public class PlayerView implements IModelView {

    private float x, y;
    private final float height, width;
    private static final float FRAME_DURATION = 0.1f;
    private Animation<Texture> dragon;
    private Texture[] DragonTextures;
    private Texture current_frame;
    private static float state_time;
    private Direction direction;

    public PlayerView(Vector2 position, float width, float height, Color col, AnnotationAssetManager manager) {
        x = position.x;
        y = position.y;
        this.width = width;
        this.height = height;
        this.direction = Direction.UP;
        if (Color.RED.equals(col)) {
            DragonTextures = new Texture[]{
                    manager.get(DRAGON_SLIM_RED, Texture.class),
                    manager.get(DRAGON_MIDDLE_RED, Texture.class),
                    manager.get(DRAGON_WIDE_RED, Texture.class)
            };

        } else if (Color.BLUE.equals(col)) {
            DragonTextures = new Texture[]{
                    manager.get(DRAGON_SLIM_BLUE, Texture.class),
                    manager.get(DRAGON_MIDDLE_BLUE, Texture.class),
                    manager.get(DRAGON_WIDE_BLUE, Texture.class)
            };

        } else if (Color.GREEN.equals(col)) {
            DragonTextures = new Texture[]{
                    manager.get(DRAGON_SLIM_GREEN, Texture.class),
                    manager.get(DRAGON_MIDDLE_GREEN, Texture.class),
                    manager.get(DRAGON_WIDE_GREEN, Texture.class)
            };

        } else if (Color.YELLOW.equals(col)) {
            DragonTextures = new Texture[]{
                    manager.get(DRAGON_SLIM_YELLOW, Texture.class),
                    manager.get(DRAGON_MIDDLE_YELLOW, Texture.class),
                    manager.get(DRAGON_WIDE_YELLOW, Texture.class)
            };

        } else {
            DragonTextures = new Texture[]{
                    new Texture(""),
                    new Texture(""),
                    new Texture("")
            };
        }
        dragon = new Animation<Texture>(FRAME_DURATION, DragonTextures);
        dragon.setPlayMode(Animation.PlayMode.LOOP);
        state_time = 0f;

    }

    @Override
    public void update(float delta, Vector2 position){
        state_time +=  delta;
        x = position.x;
        y = position.y;
    }



    @Override
    public void render(SpriteBatch batch) {
        current_frame = dragon.getKeyFrame(state_time, true);

        switch (direction){
            case UP:
                batch.draw(current_frame, x - width / 2f, y - height / 2f, width * 0.5f,
                        height * 0.5f, width, height, 1, 1, 0, 1,
                        1, current_frame.getWidth(), current_frame.getHeight(), false, false);
                break;
            case DOWN:
                batch.draw(current_frame, x - width / 2f, y - height / 2f, width * 0.5f,
                        height * 0.5f, width, height, 1, 1, 180, 1,
                        1, current_frame.getWidth(), current_frame.getHeight(), false, false);
                break;
            case LEFT:
                batch.draw(current_frame, x - width / 2f, y - height / 2f, width * 0.5f,
                        height * 0.5f, width, height, 1, 1, 90, 1,
                        1, current_frame.getWidth(), current_frame.getHeight(), false, false);
                break;
            case RIGHT:
                batch.draw(current_frame, x - width / 2f, y - height / 2f, width * 0.5f,
                        height * 0.5f, width, height, 1, 1, 270, 1,
                        1, current_frame.getWidth(), current_frame.getHeight(), false, false);
                break;
            default:
                throw new IllegalArgumentException("Wrong direction in PlayerView");

        }

    }
}
