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
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dragons.game.utilities.Constants;

public class LevelScreen extends ScreenAdapter {
    private Stage stage;
    private Skin skin;
    private TextButton lvl1, lvl2, lvl3, backBtn;
    private Image logo;
    private final AssetManager assetManager;
    private final OrthographicCamera camera;
    private final BitmapFont font;

    public LevelScreen(AssetManager assetManager, OrthographicCamera camera, BitmapFont font){
        this.assetManager = assetManager;
        this.camera = camera;
        this.font = font;
        this.stage = new Stage(new StretchViewport(Constants.WorldWidth, Constants.WorldHeight, camera));
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


    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }


    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();

    }


    private void initMenu(){
        Texture logoTex = assetManager.get("components/logo.png", Texture.class);
        logo = new Image(logoTex);
        logo.setPosition(camera.position.x - logo.getWidth() / 2, camera.position.y - 70);

        lvl1 = new TextButton("Level 1", skin, "default");
        lvl1.setSize(250, 50);
        lvl1.setPosition(camera.position.x - lvl1.getWidth() / 2, camera.position.y - lvl1.getHeight());

        lvl2 = new TextButton("Level 2", skin, "default");
        lvl2.setSize(250, 50);
        lvl2.setPosition(camera.position.x - lvl2.getWidth() / 2, camera.position.y - lvl2.getHeight() - 70);


        lvl3 = new TextButton("Level 3", skin, "default");
        lvl3.setSize(250, 50);
        lvl3.setPosition(camera.position.x - lvl3.getWidth() / 2, camera.position.y - lvl3.getHeight() - 140);

        backBtn = new TextButton("Back", skin, "default");
        backBtn.setSize(100, 30);
        backBtn.setPosition(camera.position.x / 7 , 2 * camera.position.y - 2*backBtn.getHeight());


        lvl1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

                ScreenManager.getInstance().setGameScreen(Constants.level1MapName, Constants.level1MapTxtFile);
            }
        });

        lvl2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

                ScreenManager.getInstance().setGameScreen(Constants.level2MapName, Constants.level2MapTxtFile);
            }
        });

        lvl3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

                ScreenManager.getInstance().setGameScreen(Constants.level3MapName, Constants.level3MapTxtFile);
            }
        });

        backBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ScreenManager.getInstance().setMenuScreen();
            }
        });




        stage.addActor(logo);
        stage.addActor(lvl1);
        stage.addActor(lvl2);
        stage.addActor(lvl3);
        stage.addActor(backBtn);

    }
}
