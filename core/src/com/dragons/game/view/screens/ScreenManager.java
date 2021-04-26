package com.dragons.game.view.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.dragons.game.networking.FireBaseInterface;
import com.dragons.game.networking.FirebasePlayer;
import com.dragons.game.utilities.Constants;


public class ScreenManager {

    private Game game;
    private final AssetManager assetManager = new AssetManager();
    private final OrthographicCamera camera = new OrthographicCamera();
    private final BitmapFont font;
    private FireBaseInterface _FBIC;
    private final FirebasePlayer firebasePlayer = new FirebasePlayer();

    private static final ScreenManager INSTANCE = new ScreenManager();
    public static ScreenManager getInstance(){
        return INSTANCE;
    }

    private ScreenManager() {
        font = initFonts();
        camera.setToOrtho(false, Constants.WorldWidth, Constants.WorldHeight);
    }

    //This is called by Game from inside the "create()" method.
    public void initialize(Game game, FireBaseInterface _FBIC)  {
        this.game = game;
        this._FBIC = _FBIC;
        //_FBIC.SetOnValueChangedListener(firebasePlayer);

    }

    public void setLoadingScreen(){
        game.setScreen(new LoadingScreen(assetManager, camera));
    }

    public void setMenuScreen() {
        //_FBIC.SetOnValueChangedListener(firebasePlayer);
        game.setScreen(new MenuScreen(assetManager, camera, font));
    }

    public void setLevelScreen(){
        game.setScreen(new LevelScreen(assetManager, camera, font));
    }

    public void setGameScreen(String mapName, String mapTxtFile)  {
        game.setScreen(new GameScreen(assetManager, font, mapName, mapTxtFile));
    }

    public void setGameOverScreen(int score){
        game.setScreen(new GameOverScreen(score, assetManager, camera, font, _FBIC));
    }

    public void setHighScoreScreen() {
        _FBIC.SetOnValueChangedListener(firebasePlayer);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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