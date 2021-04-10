package com.dragons.game.view.modelViews;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.gameWorld.GameMap;
import com.dragons.game.model.bomb.Bomb;
import com.dragons.game.utilities.Constants;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.BOMB;


public class BombView implements ModelView {
    private Bomb bomb;
    private Rectangle fireball;
    private Rectangle explosion;
    private float loadingTime;
    private AnnotationAssetManager manager;
    public boolean bombExploded;
    private Rectangle fireInUse;
    private GameMap gameMap;
    private Texture texture;

    public BombView(Bomb bomb, AnnotationAssetManager manager, Vector2 pos) {
        this.bomb = bomb;
        this.manager = manager;
        loadingTime = Constants.BombExplodeTime;
        //this.fireball = manager.get("FIREBALL");
        //this.explosion = manager.get("EXPLOSION");
        //fireInUse = new Rectangle(pos.x, pos.y, gameMap.getTileWidth(), gameMap.getTileHeight());
        this.texture = manager.get(BOMB, Texture.class);
        //bomb = new Texture("");
        //explosion = new Texture("");
        // while bombExplode == false
        // texture = bomb
        bombExploded = false;
        // texture = explosion
    }

    public void updateBomb(float delta) {
        //Miste en bombe når man legger den
        //bomb.update(delta); //timertask lager en thread som kjører synkront med andre TODO: FIX THIS!
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

    @Override
    public void render(SpriteBatch sb) {
        sb.draw(texture, bomb.getPosition().x - bomb.getWidth() / 2f, bomb.getPosition().y - bomb.getHeight() / 2f , bomb.getWidth(), bomb.getHeight());
    }
}