package com.dragons.game.view.modelViews.modelViewFactories;

import com.dragons.game.model.IModel;
import com.dragons.game.model.blocks.DestructibleBlock;
import com.dragons.game.model.blocks.WallBlock;
import com.dragons.game.model.powerUps.BombCapacity;
import com.dragons.game.model.powerUps.IncreaseRange;
import com.dragons.game.model.powerUps.IncreaseSpeed;
import com.dragons.game.view.modelViews.IModelView;
import com.dragons.game.view.modelViews.blocks.DestructibleBlockView;
import com.dragons.game.view.modelViews.powerUps.BombCapacityView;
import com.dragons.game.view.modelViews.powerUps.IncreaseRangeView;
import com.dragons.game.view.modelViews.powerUps.IncreaseSpeedView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

public final class PowerUpViewFactory implements IModelViewFactory {

    private static final PowerUpViewFactory INSTANCE = new PowerUpViewFactory();

    private PowerUpViewFactory() {
    }

    protected static IModelViewFactory getInstance(){
        return INSTANCE;
    }


    @Override
    public IModelView createModelView(IModel model, AnnotationAssetManager assetManager) {
        if      (model instanceof BombCapacity)    return new BombCapacityView(assetManager, (BombCapacity) model);
        else if (model instanceof IncreaseRange)    return new IncreaseRangeView(assetManager, (IncreaseRange) model);
        else if (model instanceof IncreaseSpeed)        return new IncreaseSpeedView(assetManager, (IncreaseSpeed) model);
        else return null;

        // TODO: Create PowerUpViewClasses
    }
}
