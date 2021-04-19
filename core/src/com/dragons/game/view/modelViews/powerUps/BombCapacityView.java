package com.dragons.game.view.modelViews.powerUps;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.powerUps.BombCapacity;
import com.dragons.game.utilities.Constants;
import com.dragons.game.view.modelViews.IModelView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.BOMB_CAP_POWERUP;

public class BombCapacityView implements IModelView {

    private final Texture capacity;
    private final BombCapacity bombCap;

    public BombCapacityView(AnnotationAssetManager manager, BombCapacity bombCap) {
        capacity = manager.get(BOMB_CAP_POWERUP, Texture.class);
        this.bombCap = bombCap;
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(capacity, bombCap.getPosition().x - bombCap.getWidth()* Constants.PowerUpScaleFactor/2f, bombCap.getPosition().y - bombCap.getHeight()*Constants.PowerUpScaleFactor/2f, bombCap.getWidth()* Constants.PowerUpScaleFactor, bombCap.getHeight()*Constants.PowerUpScaleFactor);
    }
}
