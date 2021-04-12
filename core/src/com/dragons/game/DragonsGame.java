package com.dragons.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.dragons.game.view.screens.MenuScreen;

public class DragonsGame extends Game {
	public AssetManager assets;

	// TODO: Find out how to structure screen management for dynamically changing between them
	/*How do we treat e.g. being in a lobby, creating a game, setting the screen for the game,
	* leaving, then joining a new lobby and initializing a new game again?
	* */
	FireBaseInterface _FBIC;

	public DragonsGame(FireBaseInterface FBIC) { this._FBIC = FBIC; };

	@Override
	public void create () {
		assets = new AssetManager();
		Gdx.app.log("DragonsGame", "created");
		/*try {
			setScreen(new GameScreen());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		setScreen(new MenuScreen(this));
	}


}
