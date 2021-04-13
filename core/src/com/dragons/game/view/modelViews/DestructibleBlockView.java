package com.dragons.game.view.modelViews;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.Model;
import com.dragons.game.model.blocks.DestructibleBlock;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.DESTRUCTIBLE_BLOCK;

public class DestructibleBlockView implements IModelView {

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
    public void update(float delta) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.draw(texture, destructibleBlock.getPosition().x - width / 2f, destructibleBlock.getPosition().y - height / 2f , width, height);
    }
}
