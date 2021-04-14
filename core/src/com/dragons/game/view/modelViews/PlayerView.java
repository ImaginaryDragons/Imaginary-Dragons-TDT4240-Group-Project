package com.dragons.game.view.modelViews;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.player.Player;
import com.dragons.game.utilities.Direction;

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

    private Player player;

    private float height, width;
    private static float FRAME_DURATION = 0.1f;
    private Animation<Texture> dragon;
    private Texture[] DragonTextures;
    private Texture current_frame;
    private static float state_time;
    private Direction direction;

    public PlayerView(Player player, AnnotationAssetManager manager) {
        this.player = player;
        height = player.getHeight();
        width = player.getWidth();
        this.direction = direction;
        Color col = player.getColor();
        Texture texture1;
        Texture texture2;
        Texture texture3;
        if (Color.RED.equals(col)) {
            DragonTextures = new Texture[]{
                    texture1 = manager.get(DRAGON_SLIM_RED, Texture.class),
                    texture2 = manager.get(DRAGON_MIDDLE_RED, Texture.class),
                    texture3 = manager.get(DRAGON_WIDE_RED, Texture.class)
            };

        } else if (Color.BLUE.equals(col)) {
            DragonTextures = new Texture[]{
                    texture1 = manager.get(DRAGON_SLIM_BLUE, Texture.class),
                    texture2 = manager.get(DRAGON_MIDDLE_BLUE, Texture.class),
                    texture3 = manager.get(DRAGON_WIDE_BLUE, Texture.class)
            };

        } else if (Color.GREEN.equals(col)) {
            DragonTextures = new Texture[]{
                    texture1 = manager.get(DRAGON_SLIM_GREEN, Texture.class),
                    texture2 = manager.get(DRAGON_MIDDLE_GREEN, Texture.class),
                    texture3 = manager.get(DRAGON_WIDE_GREEN, Texture.class)
            };

        } else if (Color.YELLOW.equals(col)) {
            DragonTextures = new Texture[]{
                    texture1 = manager.get(DRAGON_SLIM_YELLOW, Texture.class),
                    texture2 = manager.get(DRAGON_MIDDLE_YELLOW, Texture.class),
                    texture3 = manager.get(DRAGON_WIDE_YELLOW, Texture.class)
            };

        } else {
            DragonTextures = new Texture[]{
                    texture1 = new Texture(""),
                    texture2 = new Texture(""),
                    texture3 = new Texture("")
            };
        }
        dragon = new Animation<Texture>(FRAME_DURATION, DragonTextures);
        dragon.setPlayMode(Animation.PlayMode.LOOP);
        state_time = 0f;

    }

    @Override
    public void update(float delta){
        state_time +=  delta;
    }


    @Override
    public void render(SpriteBatch sb) {
        current_frame = dragon.getKeyFrame(state_time, true);

        if (player.getOrientation() == Direction.UP){
            sb.draw(current_frame, player.getPosition().x - width / 2f, player.getPosition().y - height / 2f, width * 0.5f,
                    height * 0.5f, width, height, 1, 1, 0, 1, 1, current_frame.getWidth(), current_frame.getHeight(), false, false);
        } else if (player.getOrientation() == Direction.DOWN){
            sb.draw(current_frame, player.getPosition().x - width / 2f, player.getPosition().y - height / 2f, width * 0.5f,
                    height * 0.5f, width, height, 1, 1, 180, 1, 1, current_frame.getWidth(), current_frame.getHeight(), false, false);
        } else if (player.getOrientation() == Direction.LEFT){
            sb.draw(current_frame, player.getPosition().x - width / 2f, player.getPosition().y - height / 2f, width * 0.5f,
                    height * 0.5f, width, height, 1, 1, 90, 1, 1, current_frame.getWidth(), current_frame.getHeight(), false, false);
        } else if (player.getOrientation() == Direction.RIGHT){
            sb.draw(current_frame, player.getPosition().x - width / 2f, player.getPosition().y - height / 2f, width * 0.5f,
                    height * 0.5f, width, height, 1, 1, 270, 1, 1, current_frame.getWidth(), current_frame.getHeight(), false, false);
        }
    }
}
