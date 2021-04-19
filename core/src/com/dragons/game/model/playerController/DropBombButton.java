package com.dragons.game.model.playerController;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.dragons.game.model.bombs.BombType;
import com.dragons.game.model.gameWorld.GameObject;
import com.dragons.game.model.gameWorld.GameWorld;
import com.dragons.game.model.players.NormalPlayer;
import com.dragons.game.view.modelViews.DropBombButtonView;

public class DropBombButton implements InputProcessor {

    private final OrthographicCamera cam;
    private GameObject player;
    private NormalPlayer normalPlayer;
    private final Rectangle dropBombBounds;
    private GameWorld gameWorld;

    public DropBombButton(OrthographicCamera cam, Rectangle dropBombBounds, GameWorld gameWorld) {
//    public DropBombButton(OrthographicCamera cam) {
        this.cam = cam;
        this.dropBombBounds = dropBombBounds;
        this.gameWorld = gameWorld;
    }

    public void addPlayer(GameObject player) {
        this.player = player;
        this.normalPlayer = (NormalPlayer) player.getObject();
    }

    @Override
    public boolean keyDown(int keycode) {  // For keyboard testing purposes
        if (normalPlayer.getID() == 1 && keycode == Input.Keys.Q) {
            gameWorld.placeBomb(player.getBody().getPosition(), BombType.NORMALBOMB, normalPlayer.getBombRange());
        } else if (normalPlayer.getID() == 2 && keycode == Input.Keys.M) {
            gameWorld.placeBomb(player.getBody().getPosition(), BombType.NORMALBOMB, normalPlayer.getBombRange());
        }
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

        if (dropBombBounds.contains(touch.x, touch.y) && normalPlayer.getBombsAvailable() > 0) {  // Does bombsAvailable increase

            gameWorld.placeBomb(player.getBody().getPosition(), BombType.NORMALBOMB, normalPlayer.getBombRange());

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
