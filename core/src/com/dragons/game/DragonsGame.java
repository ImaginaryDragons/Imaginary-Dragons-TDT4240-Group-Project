package com.dragons.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.FireBaseInterface;
import com.dragons.game.model.gameWorld.GameMap;
import com.dragons.game.model.gameWorld.GameWorld;
import com.dragons.game.model.player.Player;
import com.dragons.game.model.player.PlayerColor;
import com.dragons.game.view.screens.GameScreen;

import java.io.IOException;

import sun.security.util.AuthResources_fr;

public class DragonsGame extends Game {
    SpriteBatch batch;
    Texture img;
    FireBaseInterface _FBIC;
    Player player;
    GameMap map;
    GameScreen gameScreen;
    GameWorld gameWorld;


    public DragonsGame(FireBaseInterface FBIC) throws IOException {
        _FBIC = FBIC;

    }


    public void randomID() {

    }

    @Override
    public void create () {
        _FBIC.SomeFunction();
      try {
            gameScreen = new GameScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setScreen(gameScreen);

     // _FBIC.writePlayerToFB();

        _FBIC.SetOnValueChangedListener();
        Vector2 p1StartPos = gameScreen.gameMap.tilePos(new Vector2(1,1)); //gjør om til tilPos senere
        _FBIC.writePlayerToFB(5, p1StartPos , Color.RED, 32, 32);

        Vector2 p2StartPos = gameScreen.gameMap.tilePos(new Vector2(14,1)); //gjør om til tilPos senere
        _FBIC.writePlayerToFB(6, p2StartPos , Color.BLUE, 32, 32);

        Vector2 p3StartPos = gameScreen.gameMap.tilePos(new Vector2(14,10)); //gjør om til tilPos senere
        _FBIC.writePlayerToFB(7, p3StartPos , Color.YELLOW, 32, 32);

        Vector2 p4StartPos = gameScreen.gameMap.tilePos(new Vector2(14,10)); //gjør om til tilPos senere
        _FBIC.writePlayerToFB(8, p4StartPos , Color.GREEN, 32, 32);
    }


}