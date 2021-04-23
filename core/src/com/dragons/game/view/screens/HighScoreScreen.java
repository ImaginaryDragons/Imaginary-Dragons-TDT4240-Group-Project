package com.dragons.game.view.screens;

import com.badlogic.gdx.Gdx;
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
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dragons.game.networking.FirebasePlayer;
import com.dragons.game.utilities.Constants;
import com.dragons.game.view.componentViews.TimerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class HighScoreScreen extends ScreenAdapter {


    private ShapeRenderer shapeRenderer;
    private final AssetManager assetManager;
    private final OrthographicCamera camera;
    private final BitmapFont font;

    private Stage stage;
    private Skin skin;

    private Image highscoreImg;
    private TextButton exitBtn;

    public HighScoreScreen(AssetManager assetManager, OrthographicCamera camera, BitmapFont font) {
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
    public void dispose() {
        stage.dispose();
        shapeRenderer.dispose();

    }

    private void initScreen() {
        Texture gameOverTex = assetManager.get("components/highscores.png", Texture.class);
        highscoreImg = new Image(gameOverTex);
        highscoreImg.setPosition(camera.position.x - highscoreImg.getWidth() / 2, camera.position.y + 70);

        exitBtn = new TextButton("Exit", skin, "default");
        exitBtn.setSize(150, 40);
        exitBtn.setPosition(camera.position.x - exitBtn.getWidth() / 2, camera.position.y - exitBtn.getHeight() - 130);

        Container<Table> tableContainer = new Container<Table>();

        //float sw = Constants.WorldWidth;
        //float sh = Constants.WorldHeight;

        //float cw = sw * 0.7f;
        //float ch = sh * 0.5f;

        tableContainer.setSize(250, 150);
        tableContainer.setPosition(camera.position.x - tableContainer.getWidth() / 2, camera.position.y + 50);
        tableContainer.fillX();

        Table table = new Table(skin);
        Label name = new Label("NAME", skin);
        Label score = new Label("TIME", skin);

        table.add(name).expandX().fillX();
        table.add(score).expandX().fillX();
        table.row().expandX().fillX();

        for (Map.Entry<String, Integer> pair : FirebasePlayer.getScores().entrySet()) {
            table.add(new Label(pair.getKey(), skin)).uniform();
            table.add(new Label(String.valueOf(pair.getValue()), skin));
            table.row();
        }

        tableContainer.setActor(table);
        stage.addActor(highscoreImg);
        stage.addActor(tableContainer);


        exitBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ScreenManager.getInstance().setMenuScreen();
            }
        });


        stage.addActor(exitBtn);

    }
}
