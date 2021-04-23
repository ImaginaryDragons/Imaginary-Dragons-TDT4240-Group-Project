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
import com.dragons.game.view.screens.LoadingScreen;
import com.dragons.game.view.screens.ScreenManager;

import java.io.IOException;

public class DragonsGame extends Game {
    FireBaseInterface _FBIC;
    public DragonsGame(FireBaseInterface FBIC) {
        _FBIC = FBIC;

    }


	@Override
	public void create () {

		ScreenManager.getInstance().initialize(this);
        _FBIC.SetOnValueChangedListener();
        _FBIC.writeHighscoreToFB("Mads", 2.9, 22);
		_FBIC.writeHighscoreToFB("Nora", 2.5, 21);
		_FBIC.writeHighscoreToFB("Eldar", 6.5, 28);
		_FBIC.writeHighscoreToFB("Jakob", 2.7, 1);

		Gdx.app.log("DragonsGame", "created");
		ScreenManager.getInstance().setLoadingScreen();
        _FBIC.SetOnValueChangedListener();
	}


    @Override
	public void dispose() {
		super.dispose();
	}






}