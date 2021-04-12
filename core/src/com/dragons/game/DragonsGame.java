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
import com.dragons.game.view.screens.GameScreen;
import com.dragons.game.view.screens.LoadingScreen;
import com.dragons.game.view.screens.TestMenuScreen;

import java.io.IOException;


public class DragonsGame extends Game {
	public AssetManager assets;
	public BitmapFont font;

	public OrthographicCamera camera;
	public SpriteBatch batch;

	public LoadingScreen loadingScreen;
	public TestMenuScreen testMenuScreen;
	public GameScreen gameScreen;

	// TODO: Find out how to structure screen management for dynamically changing between them
	/*How do we treat e.g. being in a lobby, creating a game, setting the screen for the game,
	* leaving, then joining a new lobby and initializing a new game again?
	* */
	FireBaseInterface _FBIC;

	public DragonsGame(FireBaseInterface FBIC) { this._FBIC = FBIC; };

	@Override
	public void create () {
		assets = new AssetManager();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Constants.WorldWidth, Constants.WorldHeight);
		batch = new SpriteBatch();

		testMenuScreen = new TestMenuScreen(this);
		loadingScreen = new LoadingScreen(this);
		try {
			gameScreen = new GameScreen();
		} catch (IOException e) {
			e.printStackTrace();
		}


		Gdx.app.log("DragonsGame", "created");
		/*try {
			setScreen(new GameScreen());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		initFonts();
		this.setScreen(loadingScreen);

		//setScreen(new MenuScreen(this));
	}

	@Override
	public void dispose() {
		assets.dispose();
		font.dispose();
		testMenuScreen.dispose();
	}

	private void initFonts(){
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Arcon.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();

		params.size = 24;
		params.color = Color.BLACK;
		font = generator.generateFont(params);
	}

}
