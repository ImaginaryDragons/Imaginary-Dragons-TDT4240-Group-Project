package com.dragons.game.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dragons.game.utilities.Constants;

public class MenuScreen extends ScreenAdapter {
    private final ShapeRenderer shapeRenderer;
    private final Stage stage;
    private Skin skin;
    private TextButton startButton, highScoresButton;
    private final BitmapFont font;
    private Image logo;
    private final OrthographicCamera camera;
    private final AssetManager assetManager;

    int score;

    public MenuScreen(AssetManager assetManager, OrthographicCamera camera, BitmapFont font){
        this.assetManager = assetManager;
        this.camera = camera;
        this.font = font;
        this.stage = new Stage(new StretchViewport(Constants.WorldWidth, Constants.WorldHeight, camera));
        this.shapeRenderer = new ShapeRenderer();
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        stage.clear();

        this.skin = new Skin();
        this.skin.addRegions(assetManager.get("uiskin.atlas", TextureAtlas.class));
        this.skin.add("default-font", font);
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
    public void dispose() {
        stage.dispose();
        shapeRenderer.dispose();
        skin.dispose();

    }


    private void initMenu(){
        Texture logoTex = assetManager.get("components/logo.png", Texture.class);
        logo = new Image(logoTex);
        logo.setPosition(camera.position.x - logo.getWidth() / 2, camera.position.y - 70);

        startButton = new TextButton("Play", skin, "default");
        startButton.setSize(250, 50);
        startButton.setPosition(camera.position.x - startButton.getWidth() / 2, camera.position.y - startButton.getHeight());

        highScoresButton = new TextButton("High Scores", skin, "default");
        highScoresButton.setSize(250, 50);
        highScoresButton.setPosition(camera.position.x - startButton.getWidth() / 2, camera.position.y - startButton.getHeight() - 70);


        startButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ScreenManager.getInstance().setLevelScreen();

            }
        });
        highScoresButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ScreenManager.getInstance().setHighScoreScreen();
            }
        });


        stage.addActor(logo);
        stage.addActor(startButton);
        stage.addActor(highScoresButton);

    }


}
