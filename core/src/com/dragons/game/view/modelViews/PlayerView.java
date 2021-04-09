package com.dragons.game.view.modelViews;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.player.Player;
import com.dragons.game.model.player.*;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.DRAGON_SLIM_RED;

public class PlayerView implements ModelView {

    private Player player;
    private Texture texture;
    private AnnotationAssetManager manager;

    public PlayerView(Player player, AnnotationAssetManager manager) {
        this.player = player;
        this.manager = manager;

        // TODO: load the appropriate textures in constructor
        Color col = player.getCol();
        if (Color.RED.equals(col)) {
            texture = manager.get(DRAGON_SLIM_RED, Texture.class);
        } else if (Color.BLUE.equals(col)) {
            //texture = manager.get(DRAGON_SLIM_BLUE, Texture.class);
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.draw(texture, player.getPosition().x, player.getPosition().y, 32, 32);
    }
}
