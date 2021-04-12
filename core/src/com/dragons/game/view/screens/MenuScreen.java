package com.dragons.game.view.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dragons.game.DragonsGame;
import com.dragons.game.utilities.Constants;

import java.io.IOException;

import static com.badlogic.gdx.Gdx.app;

public class MenuScreen implements Screen {
    //private SpriteBatch spriteBatch;
    //private Texture background;
    //private Texture startbtn;
    //private Texture joinbtn;
    //private Texture logo;

    //private Viewport viewport;
    //private TextureRegion startTextureRegion;
    //private TextureRegionDrawable startRegionDrawable;
    //private ImageButton start;
    private TextureAtlas atlas;
    //private InputMultiplexer inputMultiplexer;

    private OrthographicCamera camera;
    protected Stage stage;

    private TextField name_field;

    protected Skin skin;

    private final DragonsGame dragonsGame;


    public MenuScreen(final DragonsGame dragonsGame) {
        this.dragonsGame = dragonsGame;

        /*spriteBatch = new SpriteBatch();

        background = new Texture("grey_background.jpeg");
        startbtn = new Texture("start_game.jpeg");
        joinbtn = new Texture("join_game.jpeg");
        logo = new Texture("logo.png");*/


        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();


       /*viewport = new FitViewport(Constants.WorldWidth, Constants.WorldHeight, camera);
                viewport.apply();

        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);

        camera.update();     */

        stage = new Stage(new StretchViewport(Constants.WorldWidth, Constants.WorldHeight));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, camera.viewportWidth / 2, camera.viewportHeight / 2);
    }


   @Override
    public void show() {

        Gdx.input.setInputProcessor(stage);
        stage.clear();

       /*this.skin = new Skin();
       this.skin.addRegions(dragonsGame.assets.get("uiskin.atlas", TextureAtlas.class));
       this.skin.load(Gdx.files.internal("uiskin.json"));*/

       atlas = new TextureAtlas("uiskin.atlas");
       skin = new Skin(Gdx.files.internal("uiskin.json"), atlas);

       initButtons();
    }

   /*private void drawUI(){
    TextField usernameTextField = new TextField("", );
    usernameTextField.setPosition(24,73);;
    usernameTextField.setSize(88, 14); */

    private void update(float delta){
        stage.act(delta);
    }

    @Override
    public void render(float delta) {
        app.log("MenuScreen", "render");
        /*spriteBatch.begin();
        spriteBatch.draw(background,0,0);
        spriteBatch.draw(logo,camera.position.x - logo.getWidth() / 2, camera.position.y);   spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.draw(startbtn, camera.position.x - startbtn.getWidth() / 2, camera.position.y - startbtn.getHeight() * 2);
        spriteBatch.draw(joinbtn, camera.position.x - joinbtn.getWidth() / 2, camera.position.y - (startbtn.getHeight() * 4));
        spriteBatch.end();*/

        Gdx.gl.glClearColor(.1f, .14f, .12f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        stage.act();
        stage.draw();

    }



    @Override
    public void resize(int width, int height) {
        /*viewport.update(width, height);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();*/
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
    }

    private void initButtons(){
        //Create Table
        Table mainTable = new Table();
        //Set table to fill stage
        mainTable.setFillParent(true);
        //Set alignment of contents in the table.
        mainTable.top();

        name_field = new TextField("Joshua", skin, "default");
        name_field.setMessageText("Your Name");
        name_field.setColor(1.0f, 1.0f, 0.0f, 0.8f);
        name_field.setSize(280, 60);
        name_field.getStyle().fontColor = Color.WHITE;

        //Create buttons
        TextButton playButton = new TextButton("Start game", skin, "default");
        TextButton joinButton = new TextButton("Join game", skin, "default");

        playButton.setPosition(110, 260);
        playButton.setSize(280, 60);

       /*startTextureRegion = new TextureRegion(startbtn);
       startRegionDrawable = new TextureRegionDrawable(startTextureRegion);
       start = new ImageButton(startRegionDrawable);*/

        //Add listeners to buttons
        playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                try {
                    ((Game) app.getApplicationListener()).setScreen(new GameScreen());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        joinButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                try {
                    ((Game) app.getApplicationListener()).setScreen(new GameScreen());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //Add buttons to table
        mainTable.add(new Label("Name: ", skin, "default")).colspan(2).pad(10);
        mainTable.add(name_field).colspan(2).pad(10, 0f, 10, 10f);
        mainTable.add(playButton);
        mainTable.row();
        mainTable.add(joinButton);
        mainTable.row();
        //mainTable.add(start);

        //Add table to stage
        stage.addActor(mainTable);


    }


}
