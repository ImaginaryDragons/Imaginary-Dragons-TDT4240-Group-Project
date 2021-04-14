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


public class DragonsGame extends Game {
	public AssetManager assets;
	public BitmapFont font;
	public BitmapFont fontWhite;

	public OrthographicCamera camera;
	public SpriteBatch batch;

	//public LoadingScreen loadingScreen;
	//public TestMenuScreen testMenuScreen;
	//public GameScreen gameScreen;
	//public GameOverScreen gameOverScreen;


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


		/*testMenuScreen = new TestMenuScreen(this);
		loadingScreen = new LoadingScreen(this);
		gameOverScreen = new GameOverScreen(this, ); */
		/**try {
			gameScreen = new GameScreen();
		} catch (IOException e) {
			e.printStackTrace();
		}*/


		Gdx.app.log("DragonsGame", "created");
		/*try {
			setScreen(new GameScreen());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		initFonts();
		//this.setScreen(loadingScreen);
		this.setScreen(new LoadingScreen(this));

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
