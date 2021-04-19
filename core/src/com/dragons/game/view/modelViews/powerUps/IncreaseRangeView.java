package com.dragons.game.view.modelViews.powerUps;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.gameWorld.GameMap;
import com.dragons.game.model.powerUps.IncreaseRange;
import com.dragons.game.utilities.Constants;
import com.dragons.game.view.modelViews.IModelView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.RANGE_POWERUP;

public class IncreaseRangeView implements IModelView {

    private Texture range;
    private IncreaseRange bombRange;

    public IncreaseRangeView(AnnotationAssetManager manager, IncreaseRange bombRange) {
        this.bombRange = bombRange;
        range = manager.get(RANGE_POWERUP, Texture.class);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.draw(range, bombRange.getPosition().x - bombRange.getWidth()* Constants.PowerUpScaleFactor/2f, bombRange.getPosition().y - bombRange.getHeight()*Constants.PowerUpScaleFactor/2f, bombRange.getWidth()* Constants.PowerUpScaleFactor, bombRange.getHeight() *Constants.PowerUpScaleFactor);
    }
}
