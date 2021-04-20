package com.dragons.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.dragons.game.utilities.Constants;
import com.dragons.game.view.modelViews.timer.TimerView;
import com.dragons.game.view.screens.GameOverScreen;
import com.dragons.game.view.screens.LoadingScreen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.maps.GameMap;
import com.dragons.game.controller.gameWorld.GameWorld;
import com.dragons.game.model.players.NormalPlayer;

import com.dragons.game.view.screens.GameScreen;

import java.io.IOException;

public class DragonsGame extends Game {
    SpriteBatch batch;
    Texture img;
    FireBaseInterface _FBIC;
    NormalPlayer player;
    GameMap map;
    GameScreen gameScreen;
    GameWorld gameWorld;
    FirebasePlayer firebasePlayer;
	private GameOverScreen gameOver; // = new GameOverScreen(firebasePlayer, float score);
	private TimerView timerView;

	public AssetManager assets;
	public BitmapFont font;
	String name;
	double score;

	public OrthographicCamera camera;

	//public LoadingScreen loadingScreen;
	//public TestMenuScreen testMenuScreen;
	//public GameScreen gameScreen;
	//public GameOverScreen gameOverScreen;

    public DragonsGame(FireBaseInterface FBIC) throws IOException {
        _FBIC = FBIC;

    }

	// TODO: Find out how to structure screen management for dynamically changing between them
	/*How do we treat e.g. being in a lobby, creating a game, setting the screen for the game,
	* leaving, then joining a new lobby and initializing a new game again?
	* */

	@Override
	public void create () {
		assets = new AssetManager();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Constants.WorldWidth, Constants.WorldHeight);
		batch = new SpriteBatch();
		firebasePlayer = new FirebasePlayer(name, score);

        _FBIC.SetOnValueChangedListener(firebasePlayer);
		//_FBIC.writeHighscoreToFB("Nora", 1.5);
		//_FBIC.writeHighscoreToFB("Eldar", 6.5);
		//_FBIC.writeHighscoreToFB("Jakob", 2.7);
		_FBIC.writeHighscoreToFB(firebasePlayer.getName(), firebasePlayer.getScore());

		Gdx.app.log("DragonsGame", "created");
		initFonts();
		//this.setScreen(loadingScreen);
		this.setScreen(new LoadingScreen(this));
		_FBIC.SetOnValueChangedListener(firebasePlayer);
		//setScreen(new MenuScreen(this));
	}


    @Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		//testMenuScreen.dispose();
	}

	private void initFonts(){
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Arcon.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();

		params.size = 24;
		params.color = Color.WHITE;
		font = generator.generateFont(params);
	}




}