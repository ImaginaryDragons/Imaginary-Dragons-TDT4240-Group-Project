package com.dragons.game.view.componentViews;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.dragons.game.controller.playerController.Joystick;
import com.dragons.game.view.IView;
import com.dragons.game.view.modelViews.IModelView;

import static com.dragons.game.utilities.Constants.JOYSTICK_PERIMETER_RADIUS;

public class JoystickView implements IView {

    private final Joystick joystick;
    private Circle pos;
    private final Circle perimeter;

    private final Texture joystickTexture;
    private final Texture joystickBG;

    public JoystickView(Joystick joystick) {
        this.joystick = joystick;

        pos = joystick.getCircle();
        perimeter = joystick.getPerimeter();

        Pixmap pixmapJoystick = new Pixmap((int) (2 * pos.radius + 1), (int) (2 * pos.radius + 1), Pixmap.Format.RGBA8888);
        pixmapJoystick.setBlending(Pixmap.Blending.None);
        pixmapJoystick.setColor(Color.BLACK);
        pixmapJoystick.fillCircle((int) pos.radius, (int) pos.radius, (int) pos.radius);
        joystickTexture = new Texture(pixmapJoystick);

        // Create texture for joystick background
        Pixmap pixmapJoystickBG = new Pixmap((int) (2 * perimeter.radius), (int) (2 * perimeter.radius), Pixmap.Format.RGBA8888);
        pixmapJoystickBG.setBlending(Pixmap.Blending.None);
        pixmapJoystickBG.setColor(new Color(0, 0, 0, 0.3f));
        pixmapJoystickBG.fillCircle((int) perimeter.radius, (int) perimeter.radius, (int) perimeter.radius);
        joystickBG = new Texture(pixmapJoystickBG);
    }


    @Override
    public void render(SpriteBatch sb) {
        pos = joystick.getCircle();

        sb.draw(joystickTexture, pos.x-pos.radius, pos.y-pos.radius);
        sb.draw(joystickBG, perimeter.x - JOYSTICK_PERIMETER_RADIUS, perimeter.y - JOYSTICK_PERIMETER_RADIUS);
    }
}
