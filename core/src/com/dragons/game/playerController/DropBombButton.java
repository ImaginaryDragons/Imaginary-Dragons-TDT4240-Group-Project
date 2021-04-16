package com.dragons.game.playerController;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.dragons.game.model.gameWorld.GameObject;
import com.dragons.game.view.modelViews.DropBombButtonView;

public class DropBombButton implements InputProcessor {

    private final OrthographicCamera cam;
    private GameObject player;
    private final Rectangle dropBombBounds;

    public DropBombButton(OrthographicCamera cam, Rectangle dropBombBounds) {
//    public DropBombButton(OrthographicCamera cam) {
        this.cam = cam;
        this.dropBombBounds = dropBombBounds;
    }

    public void addPlayer(GameObject player) {
        this.player = player;
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

        if (dropBombBounds.contains(touch.x, touch.y)) {
            // player.dropBomb();  // TODO: Not implemented
            Gdx.app.log("Game button", "DROP BOMB");
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
