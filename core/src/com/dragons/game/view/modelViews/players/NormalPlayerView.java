package com.dragons.game.view.modelViews.players;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.dragons.game.model.IModel;
import com.dragons.game.model.players.IPlayer;

import net.dermetfan.gdx.assets.AnnotationAssetManager;


import static com.dragons.game.utilities.AssetLoader.DRAGON_MIDDLE_BLUE;
import static com.dragons.game.utilities.AssetLoader.DRAGON_MIDDLE_GREEN;
import static com.dragons.game.utilities.AssetLoader.DRAGON_MIDDLE_RED;
import static com.dragons.game.utilities.AssetLoader.DRAGON_MIDDLE_YELLOW;
import static com.dragons.game.utilities.AssetLoader.DRAGON_SLIM_BLUE;
import static com.dragons.game.utilities.AssetLoader.DRAGON_SLIM_GREEN;
import static com.dragons.game.utilities.AssetLoader.DRAGON_SLIM_RED;
import static com.dragons.game.utilities.AssetLoader.DRAGON_SLIM_YELLOW;
import static com.dragons.game.utilities.AssetLoader.DRAGON_WIDE_BLUE;
import static com.dragons.game.utilities.AssetLoader.DRAGON_WIDE_GREEN;
import static com.dragons.game.utilities.AssetLoader.DRAGON_WIDE_RED;
import static com.dragons.game.utilities.AssetLoader.DRAGON_WIDE_YELLOW;

public class NormalPlayerView extends PlayerView {


    public NormalPlayerView(IModel model, AnnotationAssetManager manager) {
        super(model);
        IPlayer player = (IPlayer) model;
        final Color color = player.getColor();
        Texture[] textures = getTextures(color, manager);

        Animation<Texture> animation = new Animation<>(FRAME_DURATION, textures);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        super.setAnimation(animation);

    }

    private Texture[] getTextures(Color color, AnnotationAssetManager manager){
        Texture[] textures;
        if (Color.RED.equals(color)) {
            textures = new Texture[]{
                manager.get(DRAGON_SLIM_RED, Texture.class),
                manager.get(DRAGON_MIDDLE_RED, Texture.class),
                manager.get(DRAGON_WIDE_RED, Texture.class),
                manager.get(DRAGON_MIDDLE_RED, Texture.class)
            };

        } else if (Color.BLUE.equals(color)) {
            textures = new Texture[]{
                    manager.get(DRAGON_SLIM_BLUE, Texture.class),
                    manager.get(DRAGON_MIDDLE_BLUE, Texture.class),
                    manager.get(DRAGON_WIDE_BLUE, Texture.class),
                    manager.get(DRAGON_MIDDLE_BLUE, Texture.class),
            };

        } else if (Color.GREEN.equals(color)) {
            textures = new Texture[]{
                    manager.get(DRAGON_SLIM_GREEN, Texture.class),
                    manager.get(DRAGON_MIDDLE_GREEN, Texture.class),
                    manager.get(DRAGON_WIDE_GREEN, Texture.class),
                    manager.get(DRAGON_MIDDLE_GREEN, Texture.class),
            };

        } else if (Color.YELLOW.equals(color)) {
            textures = new Texture[]{
                    manager.get(DRAGON_SLIM_YELLOW, Texture.class),
                    manager.get(DRAGON_MIDDLE_YELLOW, Texture.class),
                    manager.get(DRAGON_WIDE_YELLOW, Texture.class),
                    manager.get(DRAGON_MIDDLE_YELLOW, Texture.class)
            };

        } else {
            throw new IllegalArgumentException("Wrong Color in PlayerView");
        }
        return textures;
    }




}
