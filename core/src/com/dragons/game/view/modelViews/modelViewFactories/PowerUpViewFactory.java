package com.dragons.game.view.modelViews.modelViewFactories;

import com.dragons.game.model.IModel;
import com.dragons.game.model.powerUps.BombCapacity;
import com.dragons.game.model.powerUps.IncreaseRange;
import com.dragons.game.model.powerUps.IncreaseSpeed;
import com.dragons.game.model.powerUps.NewPowerUpTemplate;
import com.dragons.game.view.IView;
import com.dragons.game.view.modelViews.powerUps.BombCapacityView;
import com.dragons.game.view.modelViews.powerUps.IncreaseRangeView;
import com.dragons.game.view.modelViews.powerUps.IncreaseSpeedView;
import com.dragons.game.view.modelViews.powerUps.NewPowerUpTemplateView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

public final class PowerUpViewFactory implements IModelViewFactory {

    private static final PowerUpViewFactory INSTANCE = new PowerUpViewFactory();

    private PowerUpViewFactory() {
    }

    protected static IModelViewFactory getInstance(){
        return INSTANCE;
    }

    @Override
    public IView createModelView(IModel model, AnnotationAssetManager assetManager) {
        // Add different views if needed here
        if      (model instanceof IncreaseSpeed)        return new IncreaseSpeedView(model, assetManager);
        else if (model instanceof BombCapacity)         return new BombCapacityView(model, assetManager);
        else if (model instanceof IncreaseRange)        return new IncreaseRangeView(model, assetManager);
        else if (model instanceof NewPowerUpTemplate)   return new NewPowerUpTemplateView(model, assetManager);

        else throw new IllegalArgumentException("The view for this model has not been put in its factory");

    }
}
