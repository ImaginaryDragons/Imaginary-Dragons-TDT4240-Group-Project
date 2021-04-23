package com.dragons.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.dragons.game.networking.FireBaseInterface;
import com.dragons.game.utilities.Constants;
import com.dragons.game.view.componentViews.TimerView;
import com.dragons.game.view.screens.LoadingScreen;
import com.dragons.game.networking.FirebasePlayer;

import java.io.IOException;

public class DragonsGame extends Game {

	private SpriteBatch batch;
	public FireBaseInterface _FBIC;

	public AssetManager assets;
	public BitmapFont font;

	public OrthographicCamera camera;
	public FirebasePlayer firebasePlayer = new FirebasePlayer();

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
;
		initFonts();
		this.setScreen(new LoadingScreen(this));

        //_FBIC.SetOnValueChangedListener(firebasePlayer);
		initFonts();
		setScreen(new LoadingScreen(this));

	}


	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
	}

	private void initFonts(){
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Arcon.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();

		params.size = 24;
		params.color = Color.WHITE;
		font = generator.generateFont(params);
	}

}