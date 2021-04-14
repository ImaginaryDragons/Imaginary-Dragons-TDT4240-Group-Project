package com.dragons.game.view.modelViews.blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.view.modelViews.IModelView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.DESTRUCTIBLE_BLOCK;

public class DestructibleBlockView implements IModelView {

    private final Texture texture;
    private final AnnotationAssetManager manager;
    private final float width, height;
    private final float x, y;

    public DestructibleBlockView(Vector2 position, float width, float height, AnnotationAssetManager manager) {
        x = position.x;
        y = position.y;
        this.width = width;
        this.height = height;
        this.manager = manager;


        texture = manager.get(DESTRUCTIBLE_BLOCK, Texture.class);
    }

    @Override
    public void update(float delta, Vector2 position) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.draw(texture, x - width / 2f, y - height / 2f , width, height);
    }
}
