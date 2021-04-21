package com.dragons.game.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
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
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dragons.game.DragonsGame;
import com.dragons.game.FirebasePlayer;
import com.dragons.game.utilities.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HighScoreScreen implements Screen {
    private final DragonsGame dragonsGame;
    private FirebasePlayer firebasePlayer;
    private ShapeRenderer shapeRenderer;

    private Stage stage;
    private Skin skin;

    private Image highscoreImg;
    private Label posLabel;
    private Label scoreLabel;
    private Label nameLabel;
    private TextButton exitBtn;
    private String name;

    private int score;

    private Map<String, Integer> scores = new LinkedHashMap<>();

    public HighScoreScreen(DragonsGame dragonsGame, int score) {
        this.dragonsGame = dragonsGame;
        this.score = score;
        this.stage = new Stage(new StretchViewport(Constants.WorldWidth, Constants.WorldHeight, dragonsGame.camera));
        this.shapeRenderer = new ShapeRenderer();
        firebasePlayer = new FirebasePlayer(name, score);

    }



    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        stage.clear();

        this.skin = new Skin();
        this.skin.addRegions(dragonsGame.assets.get("uiskin.atlas", TextureAtlas.class));
        this.skin.add("default-font", dragonsGame.font);
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
        scores = FirebasePlayer.getScores();

        Texture gameOverTex = dragonsGame.assets.get("components/highscores.png", Texture.class);
        highscoreImg = new Image(gameOverTex);
        highscoreImg.setPosition(dragonsGame.camera.position.x - highscoreImg.getWidth() / 2, dragonsGame.camera.position.y + 70);

        exitBtn = new TextButton("Exit", skin, "default");
        exitBtn.setSize(150, 40);
        exitBtn.setPosition(dragonsGame.camera.position.x - exitBtn.getWidth() / 2, dragonsGame.camera.position.y - exitBtn.getHeight() - 130);

        Container<Table> tableContainer = new Container<Table>();

        float sw = Constants.WorldWidth;
        float sh = Constants.WorldHeight;

        float cw = sw * 0.7f;
        float ch = sh * 0.5f;

        tableContainer.setSize(cw, ch);
        tableContainer.setPosition((sw-cw), (sh-ch));
        tableContainer.fillX();

        Table table = new Table(skin);
        Label name = new Label("NAME", skin);
        Label score = new Label("TIME", skin);

        table.add(name).expandX().fillX();
        table.add(score).expandX().fillX();
        table.row().expandX().fillX();

        for (int i = 0; i < scores.size(); i++) {
            table.add(new Label(firebasePlayer.getName(), skin)).uniform(); //firebasePlayer.scores.getKey()
        }
        table.row();

        for (int i = 0; i < scores.size(); i++) {
            //for (int j = 0; j < scores.size(); j++) {
               table.add(new Label(String.valueOf(firebasePlayer.getScore()), skin));
            //}
            table.row();
        }


        tableContainer.setActor(table);
        stage.addActor(highscoreImg);
        stage.addActor(tableContainer);


        exitBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dragonsGame.setScreen(new MenuScreen(dragonsGame));
            }
        });


        stage.addActor(exitBtn);

    }
}
