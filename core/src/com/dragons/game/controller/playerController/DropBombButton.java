package com.dragons.game.controller.playerController;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.dragons.game.controller.gameWorld.GameObject;
import com.dragons.game.controller.gameWorld.GameWorld;
import com.dragons.game.model.players.IPlayer;

public class DropBombButton implements InputProcessor {

    private final OrthographicCamera cam;
    private IPlayer player;
    private final Rectangle dropBombBounds;
    private final GameWorld gameWorld;

    public DropBombButton(OrthographicCamera cam, Rectangle dropBombBounds, GameWorld gameWorld) {
        this.cam = cam;
        this.dropBombBounds = dropBombBounds;
        this.gameWorld = gameWorld;
    }

    public void addPlayer(GameObject gameObject) {
        player = (IPlayer) gameObject.getObject();
    }

    @Override
    public boolean keyDown(int keycode) {  // For keyboard testing purposes
        if (player.getBombsAvailable() > 0){
            Vector2 bombPosition;
            if (player.getID() == 1 && keycode == Input.Keys.Q) {
                bombPosition = new Vector2(player.getPosition());
                gameWorld.placeBomb(bombPosition, player.getBombType(), player.getBombRange());
                player.useBomb();
            } else if (player.getID() == 2 && keycode == Input.Keys.M) {
                bombPosition = new Vector2(player.getPosition());
                gameWorld.placeBomb(bombPosition, player.getBombType(), player.getBombRange());
                player.useBomb();
            }

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

        if (dropBombBounds.contains(touch.x, touch.y) && player.getBombsAvailable() > 0) {  // Does bombsAvailable increase
            Vector2 bombPosition = new Vector2(player.getPosition());
            gameWorld.placeBomb(bombPosition, player.getBombType(), player.getBombRange());
            player.useBomb();
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
