package com.dragons.game.view.modelViews;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.IModel;
import com.dragons.game.model.Model;
import com.dragons.game.model.blocks.DestructibleBlock;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.DESTRUCTIBLE_BLOCK;
import static com.dragons.game.utilities.AssetLoader.DRAGON_SLIM_RED;

public class DestructibleBlockView implements ModelView {

    private Model destructibleBlock;
    private Texture texture;
    private AnnotationAssetManager manager;
    private float height, width;

    public DestructibleBlockView(DestructibleBlock desBlock, AnnotationAssetManager manager) {
        destructibleBlock = desBlock;
        this.manager = manager;

        height = desBlock.getHeight();
        width = desBlock.getWidth();

        texture = manager.get(DESTRUCTIBLE_BLOCK, Texture.class);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.draw(texture, destructibleBlock.getPosition().x - width / 2f, destructibleBlock.getPosition().y - height / 2f , width, height);
    }
}
