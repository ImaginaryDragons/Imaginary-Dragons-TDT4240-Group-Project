package com.dragons.game.view.modelViews.bombs.fires;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.IModel;
import com.dragons.game.view.modelViews.ModelView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.EXPLOSION1;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION2;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION3;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION4;
import static com.dragons.game.utilities.AssetLoader.EXPLOSION5;

public class NormalFireView extends ModelView {

    private final Animation<Texture> animation;

    public NormalFireView(IModel model, AnnotationAssetManager manager) {
        super(model);
        Texture[] textures = new Texture[]{
                manager.get(EXPLOSION1, Texture.class),
                manager.get(EXPLOSION2, Texture.class),
                manager.get(EXPLOSION3, Texture.class),
                manager.get(EXPLOSION4, Texture.class),
                manager.get(EXPLOSION5, Texture.class)
        };

        animation = new Animation<>(FRAME_DURATION/2f, textures);
        animation.setPlayMode(Animation.PlayMode.LOOP);



    }

    protected void draw(SpriteBatch batch, float x, float y, float width, float height, float state_time){
        final Texture current_frame = animation.getKeyFrame(state_time, true);
        batch.draw(current_frame, x - width / 2f, y - width / 2f, width, height);
    }

}
