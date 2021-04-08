package com.dragons.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.view.screens.GameScreen;

import java.io.IOException;

public class DragonsGame extends Game {

	// TODO: Find out how to structure screen management for dynamically changing between them
	/*How do we treat e.g. being in a lobby, creating a game, setting the screen for the game,
	* leaving, then joining a new lobby and initializing a new game again?
	* */
	FireBaseInterface _FBIC;

	public DragonsGame(FireBaseInterface FBIC) { this._FBIC = FBIC; };

	@Override
	public void create () {
		Gdx.app.log("DragonsGame", "created");
		try {
			setScreen(new GameScreen());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
