package com.dragons.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.dragons.game.view.screens.MenuScreen;

public class DragonsGame extends Game {
	protected Game game;

	// TODO: Find out how to structure screen management for dynamically changing between them
	/*How do we treat e.g. being in a lobby, creating a game, setting the screen for the game,
	* leaving, then joining a new lobby and initializing a new game again?
	* */

	@Override
	public void create () {
		Gdx.app.log("DragonsGame", "created");
		setScreen(new MenuScreen());
	}

}
