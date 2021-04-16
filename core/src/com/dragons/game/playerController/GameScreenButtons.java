package com.dragons.game.playerController;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dragons.game.model.gameWorld.GameObject;
import com.dragons.game.utilities.Constants;
import com.dragons.game.view.screens.GameScreen;
import com.dragons.game.view.screens.MenuScreen;

public class GameScreenButtons implements InputProcessor {

    private final OrthographicCamera cam;
    private GameObject player;

    private final Rectangle dropBombBounds;
    private final Rectangle exitButtonBounds;

    public GameScreenButtons(OrthographicCamera cam, GameScreenButtonsView buttonsView) {
        this.cam = cam;
        dropBombBounds = buttonsView.getDropBombBounds();
        exitButtonBounds = buttonsView.getExitButtonBounds();
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

        if (exitButtonBounds.contains(touch.x, touch.y)) {
//            game.setScreen(new MenuScreen(game));  // TODO: Need to access main DragonGame to set screen
            Gdx.app.log("Game button", "EXIT");
        }
        if (dropBombBounds.contains(touch.x, touch.y)) {
            // Drop bomb
            Gdx.app.log("Game button", "DROP BOMB");
        }
        return true;
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
