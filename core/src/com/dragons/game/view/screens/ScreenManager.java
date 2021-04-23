package com.dragons.game.view.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.dragons.game.utilities.Constants;

import java.io.IOException;


public class ScreenManager {

    private Game game;
    private Screen menuScreen;
    private Screen levelScreen;
    private final AssetManager assetManager = new AssetManager();
    private final OrthographicCamera camera = new OrthographicCamera();
    private final BitmapFont font;

    private static final ScreenManager INSTANCE = new ScreenManager();

    public static ScreenManager getInstance(){
        return INSTANCE;
    }

    private ScreenManager() {
        font = initFonts();
        camera.setToOrtho(false, Constants.WorldWidth, Constants.WorldHeight);
    }

    //This is called by Game from inside the "create()" method.
    public void initialize(Game game)  {
        this.game = game;
        menuScreen = new MenuScreen(assetManager, camera, font);
        levelScreen = new LevelScreen(assetManager, camera, font);

    }

    public void setLoadingScreen(){
        game.setScreen(new LoadingScreen(assetManager, camera));
    }

    public void setMenuScreen() {
        game.setScreen(menuScreen);
    }

    public void setLevelScreen(){
        game.setScreen(levelScreen);
    }

    public void setGameScreen()  {
        game.setScreen(new GameScreen(assetManager));
    }

    public void setGameOverScreen(int score){
        game.setScreen(new GameOverScreen(score, assetManager, camera, font));
    }

    public void setHighScoreScreen(){
        game.setScreen(new HighScoreScreen(assetManager, camera, font));
    }

    private BitmapFont initFonts(){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Arcon.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();

        params.size = 24;
        params.color = Color.WHITE;
        return generator.generateFont(params);
    }
}