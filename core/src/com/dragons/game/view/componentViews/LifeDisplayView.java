package com.dragons.game.view.componentViews;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.controller.gameWorld.GameMap;
import com.dragons.game.model.players.IPlayer;
import com.dragons.game.utilities.Constants;
import com.dragons.game.view.IView;


import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.EMPTY_HEALTH;
import static com.dragons.game.utilities.AssetLoader.FULL_HEALTH;

public class LifeDisplayView implements IView {

    private IPlayer player;
    private Texture lifeDisplay;
    private Texture emptyLife;
    private GameMap map;
    private Vector2 position;
    private int initialPlayerLives;



    public LifeDisplayView(IPlayer player, AnnotationAssetManager manager, GameMap map, Vector2 position) {
        this.player = player;
        initialPlayerLives = player.getLives();
        lifeDisplay = manager.get(FULL_HEALTH, Texture.class);
        emptyLife = manager.get(EMPTY_HEALTH, Texture.class);
        this.map = map;
        this.position = position;

    }


    @Override
    public void update(float delta) {


    }

    @Override
    public void render(SpriteBatch sb) {
        float x = position.x;
        float y = position.y;
        float height = map.getTileHeight()*Constants.HealthScaleFactor;
        float width = map.getTileWidth()* Constants.HealthScaleFactor;

        for (int i = 0; i < initialPlayerLives; i++) {
            if (i < player.getLives()){
                sb.draw(lifeDisplay, x - width / 2f, y - height / 2f, width, height);
            }
            else sb.draw(emptyLife, x - width / 2f, y - height / 2f, width, height);

            x += 32f;
        }

    }



}
