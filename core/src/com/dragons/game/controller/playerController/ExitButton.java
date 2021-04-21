package com.dragons.game.controller.playerController;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.dragons.game.DragonsGame;
import com.dragons.game.view.screens.GameOverScreen;

public class ExitButton implements InputProcessor {
    private final Rectangle exitButtonBounds;
    private final OrthographicCamera cam;
    private DragonsGame dragonsGame;

    public ExitButton(OrthographicCamera cam, Rectangle exitButtonBounds, DragonsGame dragonsGame) {
        this.cam = cam;
        this.exitButtonBounds = exitButtonBounds;
        this.dragonsGame = dragonsGame;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector3 touch = new Vector3(screenX, screenY, 0);
        cam.unproject(touch);
        if (exitButtonBounds.contains(touch.x, touch.y)){
            Gdx.app.log("Player controller", "EXIT game");
            dragonsGame.setScreen(new GameOverScreen(dragonsGame, 0f));
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
