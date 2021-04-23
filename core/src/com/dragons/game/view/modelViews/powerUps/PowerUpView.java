package com.dragons.game.view.modelViews.powerUps;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.dragons.game.model.IModel;
import com.dragons.game.model.bombs.NewBombTemplate;
import com.dragons.game.model.bombs.NormalBomb;
import com.dragons.game.model.powerUps.BombCapacity;
import com.dragons.game.model.powerUps.IncreaseRange;
import com.dragons.game.model.powerUps.IncreaseSpeed;
import com.dragons.game.model.powerUps.NewPowerUpTemplate;
import com.dragons.game.view.modelViews.ModelView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.BOMB_CAP_POWERUP;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION1;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION2;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION3;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION4;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION5;
import static com.dragons.game.utilities.AssetLoader.NEW_POWERUP_TEMPLATE;
import static com.dragons.game.utilities.AssetLoader.RANGE_POWERUP;
import static com.dragons.game.utilities.AssetLoader.SPEED_POWERUP;

public class PowerUpView extends ModelView {

    public PowerUpView(IModel model, AnnotationAssetManager manager) {
        super(model);
        Animation<Texture> animation = new Animation<>(FRAME_DURATION, getTextures(model, manager));
        animation.setPlayMode(Animation.PlayMode.LOOP);
        super.setAnimation(animation);

    }

    private Texture[] getTextures(IModel model, AnnotationAssetManager manager){
 
        if (model instanceof BombCapacity) {
            return new Texture[]{
                    manager.get(BOMB_CAP_POWERUP, Texture.class),
            };
        }
        else if (model instanceof IncreaseRange){
            return new Texture[]{
                    manager.get(RANGE_POWERUP, Texture.class),
            };
        }
        else if (model instanceof IncreaseSpeed){
            return new Texture[]{
                    manager.get(SPEED_POWERUP, Texture.class),
            };
        }

        else if (model instanceof NewPowerUpTemplate){
            return new Texture[]{
                    manager.get(NEW_POWERUP_TEMPLATE, Texture.class),
            };
        }

        else{
            throw new IllegalArgumentException("Textures havent been initialized for this PowerUp");
        }

    }
}
