package com.dragons.game.view.modelViews;

import com.badlogic.gdx.graphics.Texture;
import com.dragons.game.model.bomb.Bomb;
import com.dragons.game.utilities.AssetLoader;
import com.dragons.game.utilities.Constants;

public class BombView {
    private Bomb bomb;
    private Texture bombImg;
    private Texture explosion;
    private float loadingTime;

    public BombView (){
        //bomb = new Texture("");
        //explosion = new Texture("");
        // while bombExplode == false
        // texture = bomb
        // bombExplode == false
        // texture = explosion
        loadingTime = Constants.BombExplodeTime;
    }

    public void updateBomb() {
         bombImg = AssetLoader.manager.get(AssetLoader.FIREBALL, Texture.class);
         explosion = AssetLoader.manager.get(AssetLoader.EXPLOSION, Texture.class);
         bomb.update(loadingTime);

    }

}
