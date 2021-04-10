package com.dragons.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.FireBaseInterface;
import com.dragons.game.model.player.Player;
import com.dragons.game.model.player.PlayerColor;
import com.dragons.game.view.screens.GameScreen;

import java.io.IOException;

import sun.security.util.AuthResources_fr;

public class DragonGame extends Game {
    SpriteBatch batch;
    Texture img;
    FireBaseInterface _FBIC;
    Player player;


    public DragonGame(FireBaseInterface FBIC)
    {
        _FBIC = FBIC;
    }

    public void randomID() {

    }

    @Override
    public void create () {
        //Gdx.app.log("DragonGame", "Attached");
        try {
            setScreen(new GameScreen());
        } catch (IOException e) {
            e.printStackTrace();
        }
        _FBIC.SomeFunction();
        _FBIC.SetOnValueChangedListener();
        _FBIC.writePlayerToFB(4, player.getPosition(), player.getCol());
    }


}