package com.dragons.game.view.modelViews;

import com.badlogic.gdx.graphics.Texture;
import com.dragons.game.model.bomb.Bomb;
import com.dragons.game.utilities.AssetLoader;
import com.dragons.game.utilities.Constants;

import net.dermetfan.gdx.assets.AnnotationAssetManager;


public class BombView {
    private Bomb bomb;
    private Texture fireball;
    private Texture explosion;
    private float loadingTime;
    private AnnotationAssetManager manager;


    public BombView(Bomb bomb, AnnotationAssetManager manager){
        this.bomb = bomb;
        this.manager = manager;
        loadingTime = Constants.BombExplodeTime;
        this.fireball = manager.get("FIREBALL");
        this.explosion = manager.get("EXPLOSION");
        //bomb = new Texture("");
        //explosion = new Texture("");
        // while bombExplode == false
        // texture = bomb
        // bombExplode == false
        // texture = explosion
    }

    public void updateBomb() {
        /*
         bombImg = AssetLoader.manager.get(AssetLoader.FIREBALL, Texture.class);
         explosion = AssetLoader.manager.get(AssetLoader.EXPLOSION, Texture.class);
         bomb.update(loadingTime);

         */

    }

}
