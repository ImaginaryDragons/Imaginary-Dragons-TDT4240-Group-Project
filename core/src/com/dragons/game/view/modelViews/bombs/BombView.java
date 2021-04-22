package com.dragons.game.view.modelViews.bombs;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.dragons.game.model.IModel;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.model.bombs.IBomb;
import com.dragons.game.view.modelViews.ModelView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.BOMB1;
import static com.dragons.game.utilities.AssetLoader.BOMB2;
import static com.dragons.game.utilities.AssetLoader.BOMB3;
import static com.dragons.game.utilities.AssetLoader.BOMB4;
import static com.dragons.game.utilities.AssetLoader.TESTBOMB;


public class BombView extends ModelView {

    public BombView(IModel model, AnnotationAssetManager manager) {
        super(model);
        Animation<Texture> animation = new Animation<>(FRAME_DURATION, getTextures(model, manager));
        animation.setPlayMode(Animation.PlayMode.LOOP);
        super.setAnimation(animation);



    }

    private Texture[] getTextures(IModel model, AnnotationAssetManager manager){
        BombType type = ((IBomb) model).getType();
        /*
         * Add the textures for the animation
         * Only one texture => static image
         * The textures is the only thing differentiating the BombViews
         */
        switch (type) {
            case NORMALBOMB:
                return new Texture[]{
                        manager.get(BOMB1, Texture.class),
                        manager.get(BOMB2, Texture.class),
                        manager.get(BOMB3, Texture.class),
                        manager.get(BOMB4, Texture.class),
                };
            case NEW_TEST_BOMB:
                return new Texture[]{
                        manager.get(TESTBOMB, Texture.class),
                };
            default:
                throw new IllegalArgumentException("Textures havent been initialized for this BombType");
        }
    }


}