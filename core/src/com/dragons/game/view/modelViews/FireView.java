package com.dragons.game.view.modelViews;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Shape;
import com.dragons.game.model.bomb.Fire;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.EXPLOSION;

public class FireView implements IModelView {

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
        sb.draw(texture, fire.getPosition().x - width / 2f, fire.getPosition().y - width / 2f, width, height);
    }
}
