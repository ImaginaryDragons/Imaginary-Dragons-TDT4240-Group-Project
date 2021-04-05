package com.dragons.game.view.modelViews;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Rectangle;
import com.dragons.game.model.GameWorld.GameMap;
import com.dragons.game.model.bomb.Bomb;
import com.dragons.game.utilities.AssetLoader;
import com.dragons.game.utilities.Constants;

import net.dermetfan.gdx.assets.AnnotationAssetManager;


public class BombView {
    private Bomb bomb;
    private Rectangle fireball;
    private Rectangle explosion;
    private float loadingTime;
    private AnnotationAssetManager manager;
    public boolean bombExploded;
    private Rectangle fireInUse;
    private GameMap gameMap;

    public BombView(Bomb bomb, AnnotationAssetManager manager, int x, int y) {
        this.bomb = bomb;
        this.manager = manager;
        loadingTime = Constants.BombExplodeTime;
        this.fireball = manager.get("FIREBALL");
        this.explosion = manager.get("EXPLOSION");
        fireInUse = new Rectangle(x, y, gameMap.getTileWidth(), gameMap.getTileHeight());
        //bomb = new Texture("");
        //explosion = new Texture("");
        // while bombExplode == false
        // texture = bomb
        bombExploded = false;
        // texture = explosion
    }

    public void updateBomb() {
        //Miste en bombe når man legger den
        bomb.update(loadingTime); //timertask lager en thread som kjører synkront med andre
        if (!bomb.bombExploded) {
            fireInUse = fireball;
        }
        fireInUse = explosion;
        //        //fireInUse.remove(); Fjerne bomben så skjermen blir clear
        /*
         bombImg = AssetLoader.manager.get(AssetLoader.FIREBALL, Texture.class);
         explosion = AssetLoader.manager.get(AssetLoader.EXPLOSION, Texture.class);


         */

    }
}