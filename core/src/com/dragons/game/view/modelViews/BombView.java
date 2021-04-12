package com.dragons.game.view.modelViews;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.bomb.Bomb;
import com.dragons.game.utilities.Constants;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.BOMB;


public class BombView implements IModelView {

    private Bomb bomb;
    private float loadingTime;
    private AnnotationAssetManager manager;
    public boolean bombExploded;
    private Texture texture;

    public BombView(Bomb bomb, AnnotationAssetManager manager, Vector2 pos) {
        this.bomb = bomb;
        this.manager = manager;
        loadingTime = Constants.BombExplodeTime;
        this.texture = manager.get(BOMB, Texture.class);

        bombExploded = false;
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.draw(texture, bomb.getPosition().x - bomb.getWidth() / 2f, bomb.getPosition().y - bomb.getHeight() / 2f , bomb.getWidth(), bomb.getHeight());
    }
}