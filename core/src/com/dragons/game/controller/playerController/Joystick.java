package com.dragons.game.controller.playerController;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.dragons.game.controller.gameWorld.GameObject;
import com.dragons.game.model.players.NormalPlayer;

import static com.dragons.game.utilities.Constants.JOYSTICK_ORIGIN_Y;
import static com.dragons.game.utilities.Constants.JOYSTICK_PERIMETER_RADIUS;
import static com.dragons.game.utilities.Constants.JOYSTICK_ORIGIN_X;
import static com.dragons.game.utilities.Constants.JOYSTICK_RADIUS;
import static com.dragons.game.utilities.Constants.PlayerSpeed;
import static com.dragons.game.utilities.Constants.VIRTUAL_WIDTH;
import static com.dragons.game.utilities.Direction.DOWN;
import static com.dragons.game.utilities.Direction.LEFT;
import static com.dragons.game.utilities.Direction.RIGHT;
import static com.dragons.game.utilities.Direction.UP;

public class Joystick implements InputProcessor {

    private final Circle joystick;
    private final Vector2 joystickOrigin;
    private final Circle perimeter;
    private GameObject player;
    private NormalPlayer normalPlayer;
    private boolean isPlayerOne;
    private boolean isTouching;

    OrthographicCamera cam;

    public Joystick(OrthographicCamera cam, boolean isPlayerOne) {
        this.isPlayerOne = isPlayerOne;
        this.cam = cam;

        if (isPlayerOne) {
            joystickOrigin = new Vector2(JOYSTICK_ORIGIN_X, JOYSTICK_ORIGIN_Y);
            perimeter = new Circle(JOYSTICK_ORIGIN_X, JOYSTICK_ORIGIN_Y, JOYSTICK_PERIMETER_RADIUS);
        } else {
            joystickOrigin = new Vector2(VIRTUAL_WIDTH - JOYSTICK_ORIGIN_X, JOYSTICK_ORIGIN_Y);
            perimeter = new Circle(VIRTUAL_WIDTH - JOYSTICK_PERIMETER_RADIUS, JOYSTICK_ORIGIN_Y, JOYSTICK_PERIMETER_RADIUS);
        }
        joystick = new Circle(joystickOrigin.x, joystickOrigin.y, JOYSTICK_RADIUS);

    }

    public void addPlayer(GameObject player){
        this.player = player;
        this.normalPlayer = (NormalPlayer) player.getObject();
    }

    @Override
    public boolean keyDown(int keycode) {  // For testing purposes on multiplayer. Not able to test multiplayer with touch
        if (!isPlayerOne) {
            if (keycode == Input.Keys.UP) {
                player.getBody().setLinearVelocity(0f, PlayerSpeed);
                normalPlayer.setOrientation(UP);
            } else if (keycode == Input.Keys.RIGHT) {
                player.getBody().setLinearVelocity(PlayerSpeed, 0f);
                normalPlayer.setOrientation(RIGHT);
            } else if (keycode == Input.Keys.LEFT) {
                player.getBody().setLinearVelocity(-PlayerSpeed, 0f);
                normalPlayer.setOrientation(LEFT);
            } else if (keycode == Input.Keys.DOWN) {
                player.getBody().setLinearVelocity(0f, -PlayerSpeed);
                normalPlayer.setOrientation(DOWN);
            }
        } else {
            if (keycode == Input.Keys.W) {
                player.getBody().setLinearVelocity(0f, PlayerSpeed);
                normalPlayer.setOrientation(UP);
            } else if (keycode == Input.Keys.D) {
                player.getBody().setLinearVelocity(PlayerSpeed, 0f);
                normalPlayer.setOrientation(RIGHT);
            } else if (keycode == Input.Keys.A) {
                player.getBody().setLinearVelocity(-PlayerSpeed, 0f);
                normalPlayer.setOrientation(LEFT);
            } else if (keycode == Input.Keys.S) {
                player.getBody().setLinearVelocity(0f, -PlayerSpeed);
                normalPlayer.setOrientation(DOWN);
            }
        }
        return false;
    }

    private boolean asdwTouch(int keycode) {
        return (keycode == Input.Keys.A || keycode == Input.Keys.S || keycode == Input.Keys.D || keycode == Input.Keys.W);
    }
    private boolean arrowTouch(int keycode) {
        return (keycode == Input.Keys.LEFT || keycode == Input.Keys.DOWN || keycode == Input.Keys.RIGHT || keycode == Input.Keys.UP);
    }

    @Override
    public boolean keyUp(int keycode) {
        if (normalPlayer.getID() == 1 && asdwTouch(keycode)) {
            player.getBody().setLinearVelocity(0f, 0f);
        } else if (normalPlayer.getID() == 2 && arrowTouch(keycode)) {
            player.getBody().setLinearVelocity(0f, 0f);
        }
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

        if (perimeter.contains(new Vector2(touch.x, touch.y))){
            isTouching = true;

            joystick.x = touch.x;
            joystick.y = touch.y;

            float relativeX = touch.x - JOYSTICK_ORIGIN_X;
            float relativeY = touch.y - JOYSTICK_ORIGIN_Y;

            if (relativeX < relativeY && -relativeX < relativeY) {  // UP
                player.getBody().setLinearVelocity(0f, PlayerSpeed);
                normalPlayer.setOrientation(UP);
            } else if (relativeX > relativeY && -relativeX < relativeY) {  // RIGHT
                player.getBody().setLinearVelocity(PlayerSpeed, 0f);
                normalPlayer.setOrientation(RIGHT);
            } else if (relativeX < relativeY && -relativeX > relativeY) {  // LEFT
                player.getBody().setLinearVelocity(-PlayerSpeed, 0f);
                normalPlayer.setOrientation(LEFT);
            } else {                                            // DOWN
                player.getBody().setLinearVelocity(0f, -PlayerSpeed);
                normalPlayer.setOrientation(DOWN);
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        // TODO: If either player touchUp both players will stop moving
        isTouching = false;
        joystick.x = joystickOrigin.x;
        joystick.y = joystickOrigin.y;
        player.getBody().setLinearVelocity(0f, 0f);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (!isTouching) {
            return false;
        }
        Vector3 touch = new Vector3(screenX, screenY, 0);
        cam.unproject(touch);

        if (isPlayerOne && touch.x > VIRTUAL_WIDTH/2) {
            return false;
        } else if (!isPlayerOne && touch.x < VIRTUAL_WIDTH/2) {
            return false;
        }

        if (perimeter.contains(new Vector2(touch.x, touch.y))){
            joystick.x = touch.x;
            joystick.y = touch.y;
        }

        float relativeX = touch.x - joystickOrigin.x;
        float relativeY = touch.y - joystickOrigin.y;

        if (relativeX < relativeY && -relativeX < relativeY) {  // UP
            player.getBody().setLinearVelocity(0f, PlayerSpeed);
            normalPlayer.setOrientation(UP);
        } else if (relativeX > relativeY && -relativeX < relativeY) {  // RIGHT
            player.getBody().setLinearVelocity(PlayerSpeed, 0f);
            normalPlayer.setOrientation(RIGHT);
        } else if (relativeX < relativeY && -relativeX > relativeY) {  // LEFT
            player.getBody().setLinearVelocity(-PlayerSpeed, 0f);
            normalPlayer.setOrientation(LEFT);
        } else {                                                    // DOWN
            player.getBody().setLinearVelocity(0f, -PlayerSpeed);
            normalPlayer.setOrientation(DOWN);
        }
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

    public Circle getPerimeter() {
        return perimeter;
    }

    public Circle getCircle() {
        return joystick;
    }
}
