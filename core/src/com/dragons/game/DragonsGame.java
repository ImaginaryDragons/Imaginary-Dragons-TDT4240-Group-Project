package com.dragons.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.gameWorld.GameMap;
import com.dragons.game.model.players.NormalPlayer;
import com.dragons.game.view.screens.GameScreen;

import java.io.IOException;

public class DragonsGame extends Game {
    SpriteBatch batch;
    Texture img;
    FireBaseInterface _FBIC;
    NormalPlayer player;
    GameMap map;
    GameScreen gameScreen;


    public DragonsGame(FireBaseInterface FBIC) throws IOException {
        _FBIC = FBIC;

    }


    public void randomID() {

    }

    @Override
    public void create () {
       try {
            gameScreen = new GameScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gdx.app.log("DragonGame", "Attached");
        setScreen(gameScreen);
        _FBIC.SomeFunction();
        _FBIC.SetOnValueChangedListener();
        Gdx.app.log("DragonGame", "Listener changed");
        Vector2 pStartPos = gameScreen.getGameMap().tilePos(new Vector2(1,1)); //gjør om til tilPos senere
        _FBIC.writePlayerToFB(4, pStartPos , Color.BLUE, 32, 32);
        Gdx.app.log("DragonGame", "Write to FB");
    }


}