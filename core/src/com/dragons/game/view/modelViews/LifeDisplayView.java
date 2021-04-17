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
    private Texture lifeDisplay1;
    private Texture lifeDisplay2;
    private Texture lifeDisplay3;
    private Texture emptyLife1;
    private Texture emptyLife2;
    private GameMap map;
    private float posx1;
    private float posy;
    private float posx2;
    private float posx3;



    public LifeDisplayView(NormalPlayer player, AnnotationAssetManager manager, GameMap map, Vector2 tile) {
        this.player = player;
        this.manager = manager;
        lifeDisplay1 = manager.get(FULL_HEALTH, Texture.class);
        lifeDisplay2 = manager.get(FULL_HEALTH, Texture.class);
        lifeDisplay3 = manager.get(FULL_HEALTH, Texture.class);
        emptyLife1 = manager.get(EMPTY_HEALTH, Texture.class);
        emptyLife2 = manager.get(EMPTY_HEALTH, Texture.class);
        this.map = map;
        this.posx1 = tile.x;
        this.posy = tile.y;
        posx2 = posx1++;
        posx3 = posx2++;


    }


    @Override
    public void update(float delta) {


    }

    @Override
    public void render(SpriteBatch sb) {
        if(player.getLives() == 3){
            sb.draw(lifeDisplay1, posx1 - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);
            sb.draw(lifeDisplay2, posx2 - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);
            sb.draw(lifeDisplay3, posx3 - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);

            /*for (int i = 0; i < 2; i++){
                sb.draw(lifeDisplay, posx - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);
                posx = posx +1;
            }
            sb.draw(lifeDisplay, posx - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);
            */
        } else if (player.getLives() == 2){
            sb.draw(lifeDisplay1, posx1 - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);
            sb.draw(lifeDisplay2, posx2 - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);
            sb.draw(emptyLife1, posx3 - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);

            /*for (int i = 0; i < 1; i++){
                sb.draw(lifeDisplay, posx - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);
                posx++;
            }
            sb.draw(lifeDisplay, posx - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);
            sb.draw(emptyLife, posx - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);
            */

        } else if (player.getLives() == 1){
            sb.draw(lifeDisplay1, posx1 - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);
            sb.draw(emptyLife2, posx2 - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);
            sb.draw(emptyLife1, posx3 - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);

            /*sb.draw(lifeDisplay, posx - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);
            posx++;
            for (int i = 0; i < 1; i++){
                sb.draw(emptyLife, posx - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);
                posx++;
            }
            sb.draw(emptyLife, posx - map.getTileWidth()*Constants.HealthScaleFactor/2f, posy - map.getTileHeight()*Constants.HealthScaleFactor/2f, map.getTileWidth()* Constants.HealthScaleFactor, map.getTileHeight() *Constants.HealthScaleFactor);
            */
        }

    }
}
