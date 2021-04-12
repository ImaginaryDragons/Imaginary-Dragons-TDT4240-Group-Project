package com.dragons.game.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dragons.game.DragonsGame;
import com.dragons.game.utilities.Constants;

public class TestMenuScreen implements Screen {
    private final DragonsGame dragonsGame;
    private ShapeRenderer shapeRenderer;

    private Stage stage;
    private Skin skin;

    private TextButton startButton, joinButton;

    public TestMenuScreen(final DragonsGame dragonsGame){
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

        initButtons();
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

    private void initButtons(){
        //Create table
        Table mainTable = new Table();
        //Set table to fill stage
        mainTable.setFillParent(true);
        //Set alignment of contents in the table.
        mainTable.top();
        startButton = new TextButton("Start game", skin, "default");
        startButton.setPosition(110, 260);
        startButton.setSize(280, 60);

        joinButton = new TextButton("Join game", skin, "default");

        startButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dragonsGame.setScreen(dragonsGame.gameScreen);
            }
        });
        joinButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dragonsGame.setScreen(dragonsGame.gameScreen);
            }
        });

        mainTable.add(startButton);
        mainTable.row();
        mainTable.add(joinButton);
        mainTable.row();

        stage.addActor(mainTable);

    }
}
