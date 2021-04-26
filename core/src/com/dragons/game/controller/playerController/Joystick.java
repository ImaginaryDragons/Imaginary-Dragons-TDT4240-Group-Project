package com.dragons.game.controller.playerController;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.dragons.game.controller.gameWorld.GameObject;
import com.dragons.game.model.players.IPlayer;

import static com.dragons.game.utilities.Constants.JOYSTICK_ORIGIN_Y;
import static com.dragons.game.utilities.Constants.JOYSTICK_PERIMETER_RADIUS;
import static com.dragons.game.utilities.Constants.JOYSTICK_ORIGIN_X;
import static com.dragons.game.utilities.Constants.JOYSTICK_RADIUS;
import static com.dragons.game.utilities.Constants.VIEWPORT_WIDTH;
import static com.dragons.game.model.players.playerEnums.Direction.DOWN;
import static com.dragons.game.model.players.playerEnums.Direction.LEFT;
import static com.dragons.game.model.players.playerEnums.Direction.RIGHT;
import static com.dragons.game.model.players.playerEnums.Direction.UP;

public class Joystick implements InputProcessor {

    private final Circle joystick;
    private final Vector2 joystickOrigin;
    private final Circle perimeter;
    private GameObject gameObject;
    private IPlayer player;
    private final boolean isPlayerOne;
    private boolean isTouching;
    private int lastTouch;

    OrthographicCamera cam;

    public Joystick(OrthographicCamera cam, boolean isPlayerOne) {
        this.isPlayerOne = isPlayerOne;
        this.cam = cam;

        if (isPlayerOne) {
            joystickOrigin = new Vector2(JOYSTICK_ORIGIN_X, JOYSTICK_ORIGIN_Y);
            perimeter = new Circle(JOYSTICK_ORIGIN_X, JOYSTICK_ORIGIN_Y, JOYSTICK_PERIMETER_RADIUS);
        } else {
            joystickOrigin = new Vector2(VIEWPORT_WIDTH - JOYSTICK_ORIGIN_X, JOYSTICK_ORIGIN_Y);
            perimeter = new Circle(VIEWPORT_WIDTH - JOYSTICK_PERIMETER_RADIUS, JOYSTICK_ORIGIN_Y, JOYSTICK_PERIMETER_RADIUS);
        }
        joystick = new Circle(joystickOrigin.x, joystickOrigin.y, JOYSTICK_RADIUS);
    }

    public void addPlayer(GameObject gameObject){
        this.gameObject = gameObject;
        player = (IPlayer) gameObject.getModel();
    }

    @Override
    public boolean keyDown(int keycode) {  // For testing purposes on multiplayer. Not able to test multiplayer with touch on
        if (!isPlayerOne) {
            if (keycode == Input.Keys.UP) {
                gameObject.setLinearVelocity(0f, player.getSpeed());
                player.setOrientation(UP);
            } else if (keycode == Input.Keys.RIGHT) {
                gameObject.setLinearVelocity(player.getSpeed(), 0f);
                player.setOrientation(RIGHT);
            } else if (keycode == Input.Keys.LEFT) {
                gameObject.setLinearVelocity(-player.getSpeed(), 0f);
                player.setOrientation(LEFT);
            } else if (keycode == Input.Keys.DOWN) {
                gameObject.setLinearVelocity(0f, -player.getSpeed());
                player.setOrientation(DOWN);
            }
        } else {
            if (keycode == Input.Keys.W) {
                gameObject.setLinearVelocity(0f, player.getSpeed());
                player.setOrientation(UP);
            } else if (keycode == Input.Keys.D) {
                gameObject.setLinearVelocity(player.getSpeed(), 0f);
                player.setOrientation(RIGHT);
            } else if (keycode == Input.Keys.A) {
                gameObject.setLinearVelocity(-player.getSpeed(), 0f);
                player.setOrientation(LEFT);
            } else if (keycode == Input.Keys.S) {
                gameObject.setLinearVelocity(0f, -player.getSpeed());
                player.setOrientation(DOWN);
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
        if (player.getID() == 1 && asdwTouch(keycode)) {
            gameObject.setLinearVelocity(0f, 0f);
        } else if (player.getID() == 2 && arrowTouch(keycode)) {
            gameObject.setLinearVelocity(0f, 0f);
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

        if (perimeter.contains(new Vector2(touch.x, touch.y))) {
            joystick.x = touch.x;
            joystick.y = touch.y;
            lastTouch = pointer;
            isTouching = true;

            float relativeX = touch.x - joystickOrigin.x;
            float relativeY = touch.y - joystickOrigin.y;

            if (relativeX < relativeY && -relativeX < relativeY) {
                gameObject.setLinearVelocity(0f, player.getSpeed());
                player.setOrientation(UP);
            } else if (relativeX > relativeY && -relativeX < relativeY) {
                gameObject.setLinearVelocity(player.getSpeed(), 0f);
                player.setOrientation(RIGHT);
            } else if (relativeX < relativeY && -relativeX > relativeY) {
                gameObject.setLinearVelocity(-player.getSpeed(), 0f);
                player.setOrientation(LEFT);
            } else {
                gameObject.setLinearVelocity(0f, -player.getSpeed());
                player.setOrientation(DOWN);
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (lastTouch == pointer) {
            isTouching = false;
            joystick.x = joystickOrigin.x;
            joystick.y = joystickOrigin.y;
            gameObject.setLinearVelocity(0f, 0f);
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (isTouching && lastTouch == pointer) {
            Vector3 touch = new Vector3(screenX, screenY, 0);
            cam.unproject(touch);

            if (perimeter.contains(new Vector2(touch.x, touch.y))) {
                joystick.x = touch.x;
                joystick.y = touch.y;
            }

            float relativeX = touch.x - joystickOrigin.x;
            float relativeY = touch.y - joystickOrigin.y;

            if (relativeX < relativeY && -relativeX < relativeY) {
                gameObject.setLinearVelocity(0f, player.getSpeed());
                player.setOrientation(UP);
            } else if (relativeX > relativeY && -relativeX < relativeY) {
                gameObject.setLinearVelocity(player.getSpeed(), 0f);
                player.setOrientation(RIGHT);
            } else if (relativeX < relativeY && -relativeX > relativeY) {
                gameObject.setLinearVelocity(-player.getSpeed(), 0f);
                player.setOrientation(LEFT);
            } else {
                gameObject.setLinearVelocity(0f, -player.getSpeed());
                player.setOrientation(DOWN);
            }
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
