package com.dragons.game.playerController;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.dragons.game.utilities.Constants;

public class Joystick extends InputListener {

    private Vector2 origo;
    private Circle joystick;
    private final Circle perimeter;
    private Texture joystickTexture;
//    private GameObject player; // body and player


    public Joystick(int xPos, int yPos) {
        origo = new Vector2(xPos, yPos);
        joystick = new Circle(xPos, yPos, Constants.JoystickRadius);
        perimeter = new Circle(xPos, yPos, Constants.JoystickRadius + 20);

//        Pixmap pixmap = new Pixmap(2*radius, 2*radius, Pixmap.Format.RGBA8888);
//        pixmap.setColor(Color.YELLOW);
//        pixmap.fillCircle((int) joystick.x, (int) joystick.y, (int) joystick.radius);
//        joystickTexture = new Texture(pixmap);
    }

    public void registerInput() {
        Vector2 touch = new Vector2(Gdx.input.getX(), Gdx.input.getY());

        // Trouble with input coordinates that are not the same as when. Tried to unproject but the camera is not available in this class...
//        worldCoordinates = camera.unproject(new Vector3(screenX, screenY, 0), viewport.getScreenX(), viewport.getScreenY(), viewport.getScreenWidth(), viewport.getScreenHeight());

//        if (perimiter.contains(joystick)) {  // Contains the joystick circle in the perimiter.
//            joystick.x = touch.x;            // Does not show the joystick with this
//            joystick.y = touch.y;            // Used next two lines to test -v
//        }
        joystick.x = touch.x;  // For testing
        joystick.y = touch.y;

        float relativeX = touch.x-origo.x;
        float relativeY = touch.y-origo.y;
        if (relativeX < relativeY && -relativeX < relativeY) {
//            player.body.setVelocity("UP");
        } else if (relativeX > relativeY && -relativeX < relativeY) {
//            player.body.setVelocity("RIGHT");
        } else if (relativeX < relativeY && -relativeX > relativeY) {
//            player.body.setVelocity("LEFT");
        } else {
//            player.body.setVelocity("DOWN");
        }


    }

    public void update() {
        registerInput();
    }

    public void render(ShapeRenderer sr) {
        sr.setColor(Color.YELLOW);
        sr.circle(joystick.x, joystick.y, joystick.radius);
//        sb.draw(joystickTexture, pos.x, pos.y);
    }

    public Vector2 getPos() {
        Vector2 pos = new Vector2(joystick.x, joystick.y);
        return pos;
    }
}
