package com.dragons.game.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.GameWorld.GameWorld;
import com.dragons.game.utilities.Constants;
import com.dragons.game.view.GameRenderer;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

public class MenuScreen implements Screen {
    private GameWorld gameWorld;
    private GameRenderer gameRenderer;
    private AnnotationAssetManager manager;
    private SpriteBatch spriteBatch;
    private OrthographicCamera camera;

    private Texture background;
    private Texture playbutton;

    public MenuScreen(){
        gameWorld = new GameWorld();
        manager = new AnnotationAssetManager();
        spriteBatch = new SpriteBatch();

        background = new Texture("grey_background.jpeg");
        playbutton = new Texture("playbutton.png");

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h);
        camera.update();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        gameWorld.update(delta);
        spriteBatch.begin();
        spriteBatch.draw(background,0,0, Constants.WIDTH,Constants.HEIGHT);
        spriteBatch.draw(playbutton, ((Constants.WIDTH / 2)-(playbutton.getWidth() / 2)),
                Constants.HEIGHT / 2);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}
