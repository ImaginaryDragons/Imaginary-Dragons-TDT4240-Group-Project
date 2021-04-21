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
import com.dragons.game.view.screens.LoadingScreen;

import com.badlogic.gdx.math.Vector2;

import java.io.IOException;

public class DragonsGame extends Game {
    SpriteBatch batch;
    FireBaseInterface _FBIC;

	public AssetManager assets;
	public BitmapFont font;

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

        _FBIC.SetOnValueChangedListener();
        Vector2 p1StartPos = new Vector2(1,1); //gjør om til tilPos senere
        _FBIC.writeHighscoreToFB("Mads", 2.9, 22);
		_FBIC.writeHighscoreToFB("Nora", 2.5, 21);
		_FBIC.writeHighscoreToFB("Eldar", 6.5, 28);
		_FBIC.writeHighscoreToFB("Jakob", 2.7, 1);

		Gdx.app.log("DragonsGame", "created");
		initFonts();
		setScreen(new LoadingScreen(this));

        _FBIC.SetOnValueChangedListener();
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