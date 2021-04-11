package com.dragons.game.view.modelViews;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.Model;
import com.dragons.game.model.player.Player;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.DRAGON_SLIM_RED;

public class PlayerView implements ModelView {

    private Model player;
    private Texture texture;
    private AnnotationAssetManager manager;
    private float height, width;

    public PlayerView(Player player, AnnotationAssetManager manager) {
        this.player = player;
        this.manager = manager;
        height = player.getHeight();
        width = player.getWidth();

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
       // sb.draw(texture, player.getPosition().x - width / 2f, player.getPosition().y - height / 2f , width, height);
        sb.draw(texture, player.getPosition().x, player.getPosition().y, width*100, height*100);
    }
}
