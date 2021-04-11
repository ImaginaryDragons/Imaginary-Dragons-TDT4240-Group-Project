package com.dragons.game.view.modelViews;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Shape;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.EXPLOSION;

public class FireView implements ModelView {

    private Fire fire;
    private Shape shape;
    private Texture texture;
    private float height, width;


    public FireView(Fire fire, AnnotationAssetManager manager) {
        this.fire = fire;
        this.height = fire.getHeight();
        this.width = fire.getWidth();
        this.texture = manager.get(EXPLOSION, Texture.class);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.draw(texture, fire.getPosition().x, fire.getPosition().y, width, height);
    }
}
