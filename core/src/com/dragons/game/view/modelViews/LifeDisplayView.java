package com.dragons.game.view.modelViews;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.gameWorld.GameMap;
import com.dragons.game.model.players.NormalPlayer;
import com.dragons.game.utilities.Constants;


import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.EMPTY_HEALTH;
import static com.dragons.game.utilities.AssetLoader.FULL_HEALTH;

public class LifeDisplayView implements IModelView{

    private NormalPlayer player;
    private AnnotationAssetManager manager;
    private Texture lifeDisplay;
    private Texture emptyLife;
    private GameMap map;
    private float posx1;
    private float posy;
    private float posx2;
    private float posx3;



    public LifeDisplayView(NormalPlayer player, AnnotationAssetManager manager, GameMap map, Vector2 tile) {
        this.player = player;
        this.manager = manager;
        lifeDisplay = manager.get(FULL_HEALTH, Texture.class);
        emptyLife = manager.get(EMPTY_HEALTH, Texture.class);
        this.map = map;
        this.posx1 = tile.x;
        this.posy = tile.y;
        posx2 = posx1 + 32;
        posx3 = posx2 + 32;


    }


    @Override
    public void update(float delta) {


    }

    @Override
    public void render(SpriteBatch sb) {
        if(player.getLives() == 3){
            sb.draw(lifeDisplay, posx1 - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);
            sb.draw(lifeDisplay, posx2 - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);
            sb.draw(lifeDisplay, posx3 - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);

        } else if (player.getLives() == 2){
            sb.draw(lifeDisplay, posx1 - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);
            sb.draw(lifeDisplay, posx2 - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);
            sb.draw(emptyLife, posx3 - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);

        } else if (player.getLives() == 1){
            sb.draw(lifeDisplay, posx1 - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);
            sb.draw(emptyLife, posx2 - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);
            sb.draw(emptyLife, posx3 - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);
        }
    }
}
