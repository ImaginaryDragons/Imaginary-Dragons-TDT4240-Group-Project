package com.dragons.game.view.modelViews;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.player.Player;
import com.dragons.game.model.player.*;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import java.util.Objects;

import static com.dragons.game.utilities.AssetLoader.DRAGON_SLIM_RED;
import static java.util.Objects.isNull;

public class PlayerView implements ModelView {

    private Player player;
    private Texture texture;
    private AnnotationAssetManager manager;

    public PlayerView(Player player, AnnotationAssetManager manager) {
        this.player = player;
        this.manager = manager;

        // TODO: load the appropriate textures in constructor
        texture = manager.get(DRAGON_SLIM_RED, Texture.class);
        PlayerColor col = player.getCol();
        if (Color.RED.equals(col)) {

        } else if (Color.BLUE.equals(col)) {
            //texture = manager.get(DRAGON_SLIM_BLUE, Texture.class);
        }
    }


    @SuppressWarnings("NewApi")
    @Override
    public void render(SpriteBatch sb) {
        if (isNull(texture) ){
            System.out.println("Object is Null");
        } else {
            System.out.println("Not Null");

        }

        sb.draw(texture, player.getPosition().x, player.getPosition().y, 32, 32);
    }
}
