package com.dragons.game.view.modelViews;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.gameWorld.GameMap;
import com.dragons.game.model.players.NormalPlayer;
import com.dragons.game.utilities.Constants;
import com.dragons.game.view.Observer;


import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.EMPTY_HEALTH;
import static com.dragons.game.utilities.AssetLoader.FULL_HEALTH;

public class LifeDisplayView implements IModelView, Observer {

    private NormalPlayer player;
    private AnnotationAssetManager manager;
    private Texture lifeDisplay;
    private Texture emptyLife;
    private GameMap map;
    private Vector2 position;
    private int initialPlayerLives;
    private int lives;



    public LifeDisplayView(NormalPlayer player, AnnotationAssetManager manager, GameMap map, Vector2 position) {
        this.player = player;
        player.registerObserver(this);
        initialPlayerLives = player.getLives();
        lives = player.getLives();
        this.manager = manager;
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
            if (i < lives){
                sb.draw(lifeDisplay, x - width / 2f, y - height / 2f, width, height);
            }
            else sb.draw(emptyLife, x - width / 2f, y - height / 2f, width, height);

            x += 32f;
        }

    }

    @Override
    public void update() {
        if (lives > 0) lives -= 1;
    }
}
