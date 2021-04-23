package com.dragons.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.dragons.game.networking.FireBaseInterface;
import com.dragons.game.view.screens.ScreenManager;

public class DragonsGame extends Game {

    FireBaseInterface _FBIC;
    public DragonsGame(FireBaseInterface FBIC) {
        _FBIC = FBIC;
    }



	@Override
	public void create () {

		ScreenManager.getInstance().initialize(this, _FBIC);

		Gdx.app.log("DragonsGame", "created");
		ScreenManager.getInstance().setLoadingScreen();


	}


	@Override
	public void dispose() {
		super.dispose();
	}



}