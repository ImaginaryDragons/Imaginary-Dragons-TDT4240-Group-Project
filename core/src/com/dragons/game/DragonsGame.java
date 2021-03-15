package com.dragons.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.view.screens.GameScreen;

public class DragonsGame extends Game {
	
	@Override
	public void create () {
		Gdx.app.log("DragonsGame", "created");
		setScreen(new GameScreen());
	}

	/*
	@Override
	public void render () {
		Gdx.app.log("DragonsGame", "rendering");
		//Gdx.gl.glClearColor(1, 0, 0, 1);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//batch.begin();
		//batch.draw(img, 0, 0);
		//batch.end();
	}

	 */
	
	@Override
	public void dispose () {
		Gdx.app.log("DragonsGame", "dispose called");
	}
}
