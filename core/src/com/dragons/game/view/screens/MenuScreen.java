package com.dragons.game.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.dragons.game.model.gameWorld.GameWorld;
import com.dragons.game.utilities.Constants;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

public class MenuScreen extends DefaultScreen {
    private GameWorld gameWorld;
    private AnnotationAssetManager manager;
    private SpriteBatch spriteBatch;
    private OrthographicCamera camera;
    private Stage stage;

    private Texture background;
    private Texture startbtn;
    private Texture joinbtn;
    private Texture logo;

    private InputMultiplexer inputMultiplexer;


    public MenuScreen() {
        gameWorld = new GameWorld();
        manager = new AnnotationAssetManager();
        spriteBatch = new SpriteBatch();

        background = new Texture("grey_background.jpeg");
        startbtn = new Texture("start_game.jpeg");
        joinbtn = new Texture("join_game.jpeg");
        logo = new Texture("logo.png");

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Constants.WIDTH / 2, Constants.HEIGHT / 2);
    }


   @Override
    public void show() {
        // FRA BOMBERMAN GITHUB
        //stage = new Stage(new StretchViewport(Constants.WIDTH, Constants.HEIGHT));
        //InputMultiplexer inputMultiplexer = new InputMultiplexer();
        //inputMultiplexer.addProcessor(stage);

    }


    @Override
    public void render(float delta) {
        gameWorld.update(delta);
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(background,0,0);
        spriteBatch.draw(logo,camera.position.x - logo.getWidth() / 2, camera.position.y);
        spriteBatch.draw(startbtn, camera.position.x - startbtn.getWidth() / 2, camera.position.y - startbtn.getHeight());
        spriteBatch.draw(joinbtn, camera.position.x - joinbtn.getWidth() / 2, camera.position.y - (startbtn.getHeight() * 3));
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

    @Override
    public InputProcessor getInputProcessor() {
        return null;
    }

}
