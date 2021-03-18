package com.dragons.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.view.screens.GameScreen;

public class DragonsGame extends Game {

	// TODO: Find out how to structure screen management for dynamically changing between them
	/*How do we treat e.g. being in a lobby, creating a game, setting the screen for the game,
	* leaving, then joining a new lobby and initializing a new game again?
	* */

	@Override
	public void create () {
		Gdx.app.log("DragonsGame", "created");
		setScreen(new GameScreen());
	}


	/* NOTE: This function actually becomes superficious. We are not rendering here anymore!
	* Might just end up removing it, but it might serve a purpose. The purpose being rendering
	* something if there are no set screens. Seems unlikely though. */
	@Override
	public void render () {
		Gdx.app.log("DragonsGame", "rendering");
		//Gdx.gl.glClearColor(1, 0, 0, 1);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//batch.begin();
		//batch.draw(img, 0, 0);
		//batch.end();
	}


	
	@Override
	public void dispose () {
		Gdx.app.log("DragonsGame", "dispose called");
	}
}
