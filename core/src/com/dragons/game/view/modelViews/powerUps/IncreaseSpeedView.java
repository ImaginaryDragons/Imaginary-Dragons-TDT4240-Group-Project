package com.dragons.game.view.modelViews.powerUps;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.gameWorld.GameMap;
import com.dragons.game.model.powerUps.IncreaseSpeed;
import com.dragons.game.utilities.Constants;
import com.dragons.game.view.modelViews.IModelView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.SPEED_POWERUP;

public class IncreaseSpeedView implements IModelView {
    private Texture speed;
    private IncreaseSpeed bombSpeed;

    public IncreaseSpeedView(AnnotationAssetManager manager, IncreaseSpeed bombSpeed) {
        this.bombSpeed = bombSpeed;
        speed = manager.get(SPEED_POWERUP, Texture.class);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.draw(speed, bombSpeed.getPosition().x - bombSpeed.getWidth()* Constants.PowerUpScaleFactor/2f, bombSpeed.getPosition().y - bombSpeed.getHeight()*Constants.PowerUpScaleFactor/2f, bombSpeed.getWidth()* Constants.PowerUpScaleFactor, bombSpeed.getHeight() *Constants.PowerUpScaleFactor);
    }
}
