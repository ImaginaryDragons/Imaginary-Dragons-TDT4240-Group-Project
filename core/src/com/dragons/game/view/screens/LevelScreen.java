package com.dragons.game.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dragons.game.DragonsGame;
import com.dragons.game.utilities.Constants;

import java.io.IOException;

public class LevelScreen extends ScreenAdapter {
    private final DragonsGame dragonsGame;
    private ShapeRenderer shapeRenderer;

    private Stage stage;
    private Skin skin;

    private TextButton lvl1, lvl2, lvl3, backBtn;

    private Image logo;

    int score;

    public LevelScreen(final DragonsGame dragonsGame){
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
    public void dispose() {
        stage.dispose();
        shapeRenderer.dispose();

    }


    private void initMenu(){
        Texture logoTex = dragonsGame.assets.get("components/logo.png", Texture.class);
        logo = new Image(logoTex);
        logo.setPosition(dragonsGame.camera.position.x - logo.getWidth() / 2, dragonsGame.camera.position.y - 70);

        lvl1 = new TextButton("Level 1", skin, "default");
        lvl1.setSize(250, 50);
        lvl1.setPosition(dragonsGame.camera.position.x - lvl1.getWidth() / 2, dragonsGame.camera.position.y - lvl1.getHeight());

        lvl2 = new TextButton("Level 2", skin, "default");
        lvl2.setSize(250, 50);
        lvl2.setPosition(dragonsGame.camera.position.x - lvl2.getWidth() / 2, dragonsGame.camera.position.y - lvl2.getHeight() - 70);


        lvl3 = new TextButton("Level 3", skin, "default");
        lvl3.setSize(250, 50);
        lvl3.setPosition(dragonsGame.camera.position.x - lvl3.getWidth() / 2, dragonsGame.camera.position.y - lvl3.getHeight() - 140);

        backBtn = new TextButton("Back", skin, "default");
        backBtn.setSize(100, 30);
        backBtn.setPosition(dragonsGame.camera.position.x / 7 , 2 * dragonsGame.camera.position.y - 2*backBtn.getHeight());


        lvl1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

                try {
                    dragonsGame.setScreen(new GameScreen(dragonsGame));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        backBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dragonsGame.setScreen(new MenuScreen(dragonsGame));
            }
        });




        stage.addActor(logo);
        stage.addActor(lvl1);
        stage.addActor(lvl2);
        stage.addActor(lvl3);
        stage.addActor(backBtn);

    }
}
