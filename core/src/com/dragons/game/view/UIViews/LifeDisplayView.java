package com.dragons.game.view.UIViews;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModel;
import com.dragons.game.model.maps.GameMap;
import com.dragons.game.model.players.IPlayer;
import com.dragons.game.utilities.Constants;
import com.dragons.game.view.IView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.EMPTY_HEALTH;
import static com.dragons.game.utilities.AssetLoader.FULL_HEALTH;

public class LifeDisplayView implements IView {

    private final IPlayer player;
    private final Texture lifeDisplay;
    private final Texture emptyLife;
    private final GameMap map;
    private final Vector2 position;
    private final int initialPlayerLives;



    public LifeDisplayView(IModel player, AnnotationAssetManager manager, GameMap map, Vector2 position) {
        this.player = (IPlayer) player;
        initialPlayerLives = this.player.getLives();
        lifeDisplay = manager.get(FULL_HEALTH, Texture.class);
        emptyLife = manager.get(EMPTY_HEALTH, Texture.class);
        this.map = map;
        this.position = position;

    }


    @Override
    public void render(SpriteBatch batch) {
        float x = position.x;
        float y = position.y;
        float height = map.getTileHeight()*Constants.HealthScaleFactor;
        float width = map.getTileWidth()* Constants.HealthScaleFactor;

        for (int i = 0; i < initialPlayerLives; i++) {
            if (i < player.getLives()){
                batch.draw(lifeDisplay, x - width / 2f, y - height / 2f, width, height);
            }
            else batch.draw(emptyLife, x - width / 2f, y - height / 2f, width, height);

            x += 32f;
        }

    }



}
