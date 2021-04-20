package com.dragons.game.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dragons.game.DragonsGame;
import com.dragons.game.utilities.Constants;

import java.io.IOException;

public class MenuScreen implements Screen {
    private final DragonsGame dragonsGame;
    private ShapeRenderer shapeRenderer;

    private Stage stage;
    private Skin skin;

    private TextField nameField;
    private TextButton startButton, joinButton;

    private Image logo;

    int score;

    public MenuScreen(final DragonsGame dragonsGame){
        this.dragonsGame = dragonsGame;
        this.stage = new Stage(new StretchViewport(Constants.WorldWidth, Constants.WorldHeight, dragonsGame.camera));
        this.shapeRenderer = new ShapeRenderer();
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        stage.clear();

        this.skin = new Skin();
        this.skin.addRegions(dragonsGame.assets.get("uiskin.atlas", TextureAtlas.class));
        this.skin.add("default-font", dragonsGame.font);
        this.skin.load(Gdx.files.internal("uiskin.json"));


        initMenu();
    }

    private void update(float delta) {
      stage.act(delta);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        stage.draw();

        /*dragonsGame.batch.begin();
        dragonsGame.font.draw(dragonsGame.batch, "Screen: Main Menu", 20, 20);
        dragonsGame.batch.end();*/


    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
        stage.dispose();
        shapeRenderer.dispose();

    }


    private void initMenu(){
        Texture logoTex = dragonsGame.assets.get("components/logo.png", Texture.class);
        logo = new Image(logoTex);
        logo.setPosition(dragonsGame.camera.position.x - logo.getWidth() / 2, dragonsGame.camera.position.y - 70);

        startButton = new TextButton("Play", skin, "default");
        startButton.setSize(250, 50);
        startButton.setPosition(dragonsGame.camera.position.x - startButton.getWidth() / 2, dragonsGame.camera.position.y - startButton.getHeight());

        joinButton = new TextButton("GAME OVER", skin, "default");
        joinButton.setSize(250, 50);
        joinButton.setPosition(dragonsGame.camera.position.x - startButton.getWidth() / 2, dragonsGame.camera.position.y - startButton.getHeight() - 70);


        startButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                try {
                    dragonsGame.setScreen(new GameScreen(dragonsGame));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        joinButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dragonsGame.setScreen(new GameOverScreen(dragonsGame, score));
            }
        });


        stage.addActor(logo);
        stage.addActor(startButton);
        stage.addActor(joinButton);

    }
}
