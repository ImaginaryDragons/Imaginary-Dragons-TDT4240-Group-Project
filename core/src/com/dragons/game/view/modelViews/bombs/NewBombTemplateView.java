package com.dragons.game.view.modelViews.bombs;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.IModel;
import com.dragons.game.view.modelViews.ModelView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.BOMB1;
import static com.dragons.game.utilities.AssetLoader.BOMB2;
import static com.dragons.game.utilities.AssetLoader.BOMB3;
import static com.dragons.game.utilities.AssetLoader.BOMB4;
import static com.dragons.game.utilities.AssetLoader.TESTBOMB;

public class NewBombTemplateView extends ModelView {
    private final Animation<Texture> animation;

    public NewBombTemplateView(IModel model, AnnotationAssetManager manager) {
        super(model);
        Texture[] textures = new Texture[]{
                manager.get(TESTBOMB, Texture.class) // Add the textures here
        };

        animation = new Animation<>(FRAME_DURATION, textures);
        animation.setPlayMode(Animation.PlayMode.LOOP);



    }

    protected void draw(SpriteBatch batch, float x, float y, float width, float height, float state_time){
        final Texture current_frame = animation.getKeyFrame(state_time, true);
        batch.draw(current_frame, x - width / 2f, y - width / 2f, width, height);
    }
}
