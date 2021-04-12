package com.dragons.game.view.modelViews;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.Model;
import com.dragons.game.model.player.Player;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.Text;

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

public class PlayerView implements ModelView {

    private Model player;

    private AnnotationAssetManager manager;
    private float height, width;
    private static float FRAME_DURATION = 0.1f;
    private Animation<Texture> dragon;
    private List<Texture> DragonTextures = new ArrayList<>();
    private Texture current_frame;
    private static float state_time;

    public PlayerView(Player player, AnnotationAssetManager manager) {
        this.player = player;
        this.manager = manager;
        height = player.getHeight();
        width = player.getWidth();

        // TODO: load the appropriate textures in constructor
        Color col = player.getCol();
        Texture texture1;
        Texture texture2;
        Texture texture3;
        if (Color.RED.equals(col)) {
            texture1 = manager.get(DRAGON_SLIM_RED, Texture.class);
            texture2 = manager.get(DRAGON_MIDDLE_RED, Texture.class);
            texture3 = manager.get(DRAGON_WIDE_RED, Texture.class);

        } else if (Color.BLUE.equals(col)) {
            texture1 = manager.get(DRAGON_SLIM_BLUE, Texture.class);
            texture2 = manager.get(DRAGON_MIDDLE_BLUE, Texture.class);
            texture3 = manager.get(DRAGON_WIDE_BLUE, Texture.class);

        } else if (Color.GREEN.equals(col)) {
            texture1 = manager.get(DRAGON_SLIM_GREEN, Texture.class);
            texture2 = manager.get(DRAGON_MIDDLE_GREEN, Texture.class);
            texture3 = manager.get(DRAGON_WIDE_GREEN, Texture.class);

        } else if (Color.YELLOW.equals(col)) {
            texture1 = manager.get(DRAGON_SLIM_YELLOW, Texture.class);
            texture2 = manager.get(DRAGON_MIDDLE_YELLOW, Texture.class);
            texture3 = manager.get(DRAGON_WIDE_YELLOW, Texture.class);
        } else {
            texture1 = new Texture("");
            texture2 = new Texture("");
            texture3 = new Texture("");

        }
        DragonTextures.add(texture1);
        DragonTextures.add(texture2);
        DragonTextures.add(texture3);
        dragon = new Animation<Texture>(FRAME_DURATION, (Texture) DragonTextures);
        dragon.setPlayMode(Animation.PlayMode.LOOP);
        state_time = 0f;

    }

    @Override
    public void update(float delta){
        state_time +=  delta;
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        current_frame = dragon.getKeyFrame(state_time, true);
        sb.draw(current_frame, player.getPosition().x - width / 2f, player.getPosition().y - height / 2f , width, height);
        sb.end();
    }
}
