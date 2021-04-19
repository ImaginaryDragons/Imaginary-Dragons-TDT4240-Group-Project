package com.dragons.game.view.modelViews.blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.blocks.DestructibleBlock;
import com.dragons.game.model.blocks.IBlock;
import com.dragons.game.view.modelViews.IModelView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.DESTRUCTIBLE_BLOCK;

public class DestructibleBlockView implements IModelView {

    private final Texture texture;
    private final IBlock block;

    public DestructibleBlockView(IModel model, AnnotationAssetManager manager) {
        this.block = (IBlock) model;

        texture = manager.get(DESTRUCTIBLE_BLOCK, Texture.class);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(SpriteBatch batch) {
        float x = block.getPosition().x;
        float y = block.getPosition().y;
        float width = block.getWidth();
        float height = block.getHeight();

        batch.draw(texture, x - width / 2f, y - height / 2f , width, height);
    }
}
