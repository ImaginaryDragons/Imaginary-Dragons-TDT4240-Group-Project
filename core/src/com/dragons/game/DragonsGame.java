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

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.view.screens.GameScreen;

import java.io.IOException;

public class DragonsGame extends Game {

	public AssetManager assets;
	public BitmapFont font;

	public OrthographicCamera camera;
	public SpriteBatch batch;

    public Texture img;
    public FireBaseInterface _FBIC;
    public GameScreen gameScreen;

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

        _FBIC.SomeFunction();
        _FBIC.SetOnValueChangedListener();
        Gdx.app.log("DragonGame", "Listener changed");
        //Vector2 pStartPos = gameScreen.getGameMap().tilePos(new Vector2(1,1)); //gjør om til tilPos senere
        //_FBIC.writePlayerToFB(4, pStartPos , Color.BLUE, 32, 32);
        //Gdx.app.log("DragonGame", "Write to FB");

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



    public void randomID() {

    }



}