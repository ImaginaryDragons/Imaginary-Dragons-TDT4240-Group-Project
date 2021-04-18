package com.dragons.game.view.modelViews.powerUps;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.view.modelViews.IModelView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.SPEED_POWERUP;

public class PowerUpView implements IModelView {

    private Texture speed;
    private Texture capasity;
    private Texture range;
    private AnnotationAssetManager manager;

    public PowerUpView(AnnotationAssetManager manager) {
        this.manager = manager;
        speed = manager.get(SPEED_POWERUP, Texture.class);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(SpriteBatch sb) {

    }
}
