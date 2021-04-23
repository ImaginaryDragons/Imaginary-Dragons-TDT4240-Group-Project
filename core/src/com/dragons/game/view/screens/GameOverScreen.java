package com.dragons.game.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dragons.game.DragonsGame;
import com.dragons.game.utilities.Constants;


public class GameOverScreen extends ScreenAdapter {
    private final ShapeRenderer shapeRenderer;
    private final AssetManager assets;
    private final OrthographicCamera camera;
    private final BitmapFont font;

    private final Stage stage;
    private Skin skin;

    private Image gameOver;
    private Label scoreLabel;
    private Label nameFieldLabel;
    private TextField nameField;
    private TextButton saveScoreBtn, exitBtn;


    private final int score;


    public GameOverScreen(int score, AssetManager assetManager, OrthographicCamera camera, BitmapFont font) {
        this.score = score;
        this.assets = assetManager;
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
        this.skin.addRegions(assets.get("uiskin.atlas", TextureAtlas.class));
        this.skin.add("default-font", font);
        this.skin.load(Gdx.files.internal("uiskin.json"));

        initScreen();
    }

    private void update(float delta) {
        stage.act(delta);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        stage.draw();
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

    private void initScreen() {
        Texture gameOverTex = assets.get("components/over.png", Texture.class);
        gameOver = new Image(gameOverTex);
        gameOver.setSize(250, 70);
        gameOver.setPosition(camera.position.x - gameOver.getWidth() / 2, camera.position.y + 70);

        scoreLabel = new Label("Score: "  + score, skin);
        scoreLabel.setSize(250, 20);
        scoreLabel.setPosition(camera.position.x - scoreLabel.getWidth() / 2, camera.position.y + 30);

        nameFieldLabel = new Label("Your name: ", skin);
        nameFieldLabel.setSize(250, 20);
        nameFieldLabel.setPosition(camera.position.x - nameFieldLabel.getWidth() / 2, camera.position.y - 10);

        nameField = new TextField("", skin);
        nameField.setSize(250, 30);
        //nameField.setAlignment(Align.center);
        nameField.setPosition(camera.position.x - nameField.getWidth() / 2, camera.position.y - 40);

        saveScoreBtn = new TextButton("Save Score", skin, "default");
        saveScoreBtn.setSize(250, 50);
        saveScoreBtn.setPosition(camera.position.x - saveScoreBtn.getWidth() / 2, camera.position.y - saveScoreBtn.getHeight() - 55);

        exitBtn = new TextButton("Exit", skin, "default");
        exitBtn.setSize(150, 40);
        exitBtn.setPosition(camera.position.x - exitBtn.getWidth() / 2, camera.position.y - exitBtn.getHeight() - 130);


        saveScoreBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ScreenManager.getInstance().setHighScoreScreen();
            }
        });
        exitBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ScreenManager.getInstance().setMenuScreen();
            }
        });

        stage.addActor(gameOver);
        stage.addActor(scoreLabel);
        stage.addActor(nameFieldLabel);
        stage.addActor(nameField);
        stage.addActor(saveScoreBtn);
        stage.addActor(exitBtn);

    }
}
