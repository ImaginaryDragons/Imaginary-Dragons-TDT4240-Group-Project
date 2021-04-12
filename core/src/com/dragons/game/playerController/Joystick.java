package com.dragons.game.playerController;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.dragons.game.model.gameWorld.GameObject;
import com.dragons.game.utilities.Constants;

import static com.dragons.game.utilities.Constants.JOYSTICK_ORIGIN_Y;
import static com.dragons.game.utilities.Constants.JOYSTICK_PERIMETER_RADIUS;
import static com.dragons.game.utilities.Constants.JOYSTICK_ORIGIN_X;
import static com.dragons.game.utilities.Constants.JOYSTICK_RADIUS;
import static com.dragons.game.utilities.Constants.PlayerSpeed;

public class Joystick implements InputProcessor {

    private Circle joystick;
    private final Circle perimeter;
    private GameObject player; // body and player

    private final Texture joystickBG;
    private final Texture joystickTexture;

    OrthographicCamera cam;

    public Joystick(OrthographicCamera cam) {
        this.cam = cam;
        joystick = new Circle(JOYSTICK_ORIGIN_X, JOYSTICK_ORIGIN_Y, JOYSTICK_RADIUS);
        perimeter = new Circle(JOYSTICK_ORIGIN_X, JOYSTICK_ORIGIN_Y, JOYSTICK_PERIMETER_RADIUS);
        Gdx.input.setInputProcessor(this);

        // Create joystick texture
        Pixmap pixmapJoystick = new Pixmap((int) (2*joystick.radius+1), (int) (2*joystick.radius+1), Pixmap.Format.RGBA8888);
        pixmapJoystick.setBlending(Pixmap.Blending.None);
        pixmapJoystick.setColor(Color.BLACK);
        pixmapJoystick.fillCircle((int) joystick.radius, (int) joystick.radius, (int) joystick.radius);
        joystickTexture = new Texture(pixmapJoystick);

        // Create texture for joystick background
        Pixmap pixmapJoystickBG = new Pixmap((int) (2*perimeter.radius), (int) (2*perimeter.radius), Pixmap.Format.RGBA8888);
        pixmapJoystickBG.setBlending(Pixmap.Blending.None);
        pixmapJoystickBG.setColor(new Color(0,0,0,0.3f));
        pixmapJoystickBG.fillCircle((int) perimeter.radius, (int) perimeter.radius, (int) perimeter.radius);
        joystickBG = new Texture(pixmapJoystickBG);
    }

    public void addPlayer(GameObject player){
        this.player = player;
    }

    public void render(SpriteBatch sb) {
        sb.draw(joystickTexture, joystick.x-joystick.radius, joystick.y-joystick.radius);
        sb.draw(joystickBG, JOYSTICK_ORIGIN_X - JOYSTICK_PERIMETER_RADIUS,JOYSTICK_ORIGIN_Y - JOYSTICK_PERIMETER_RADIUS);
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

        if (perimeter.contains(new Vector2(touch.x, touch.y))){

            joystick.x = touch.x;
            joystick.y = touch.y;

            float relativeX = touch.x - JOYSTICK_ORIGIN_X;
            float relativeY = touch.y - JOYSTICK_ORIGIN_Y;

            if (relativeX < relativeY && -relativeX < relativeY) {  // UP
                Gdx.app.log("Touch down", String.format("UP\t\ttouch.x: %.1f\trelativeX: %.1f\n\t\t\t\t\ttouch.y: %.1f\trelativeY: %.1f", touch.x, relativeX, touch.y, relativeY));
//            player.body.setLinearVelocity(0f, PlayerSpeed);
            } else if (relativeX > relativeY && -relativeX < relativeY) {  // RIGHT
                Gdx.app.log("Touch down", String.format("RIGHT\ttouch.x: %.1f\trelativeX: %.1f\n\t\t\t\t\ttouch.y: %.1f\trelativeY: %.1f", touch.x, relativeX, touch.y, relativeY));
//            player.body.setLinearVelocity(PlayerSpeed, 0f);
            } else if (relativeX < relativeY && -relativeX > relativeY) {  // LEFT
                Gdx.app.log("Touch down", String.format("LEFT\ttouch.x: %.1f\trelativeX: %.1f\n\t\t\t\t\ttouch.y: %.1f\trelativeY: %.1f", touch.x, relativeX, touch.y, relativeY));
//            player.body.setLinearVelocity(-PlayerSpeed, 0f);
            } else {                                            // DOWN
                Gdx.app.log("Touch down", String.format("DOWN\ttouch.x: %.1f\trelativeX: %.1f\n\t\t\t\t\ttouch.y: %.1f\trelativeY: %.1f", touch.x, relativeX, touch.y, relativeY));
//            player.body.setLinearVelocity(0f, -PlayerSpeed);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        joystick.x = JOYSTICK_ORIGIN_X;
        joystick.y = JOYSTICK_ORIGIN_Y;
//        player.body.setLinearVelocity(0f, 0f);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Vector3 touch = new Vector3(screenX, screenY, 0);
        cam.unproject(touch);

        if (perimeter.contains(new Vector2(touch.x, touch.y))){
            joystick.x = touch.x;
            joystick.y = touch.y;
        }

        float relativeX = touch.x - JOYSTICK_ORIGIN_X;
        float relativeY = touch.y - JOYSTICK_ORIGIN_Y;

        if (relativeX < relativeY && -relativeX < relativeY) {  // UP
            Gdx.app.log("Touch dragged", "UP");
//            player.body.setLinearVelocity(0f, PlayerSpeed);
        } else if (relativeX > relativeY && -relativeX < relativeY) {  // RIGHT
            Gdx.app.log("Touch dragged", "RIGHT");
//            player.body.setLinearVelocity(PlayerSpeed, 0f);
        } else if (relativeX < relativeY && -relativeX > relativeY) {  // LEFT
            Gdx.app.log("Touch dragged", "LEFT");
//            player.body.setLinearVelocity(-PlayerSpeed, 0f);
        } else {                                                    // DOWN
            Gdx.app.log("Touch dragged", "DOWN");
//            player.body.setLinearVelocity(0f, -PlayerSpeed);
        }
        return true;
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
