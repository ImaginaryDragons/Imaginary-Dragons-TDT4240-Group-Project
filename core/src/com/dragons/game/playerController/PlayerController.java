package com.dragons.game.playerController;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.view.modelViews.GameScreenButtonsView;
import com.dragons.game.view.modelViews.JoystickView;

public class PlayerController {
    private Joystick joystick;
    private JoystickView joystickView;
    private GameScreenButtons buttons;
    private GameScreenButtonsView buttonsView;
    public InputMultiplexer multiplexer;

    public PlayerController(OrthographicCamera camera) {
        joystick = new Joystick(camera);
        buttonsView = new GameScreenButtonsView();
        buttons = new GameScreenButtons(camera, buttonsView);
        joystickView = new JoystickView(joystick);

        multiplexer = new InputMultiplexer(joystick, buttons);
        Gdx.input.setInputProcessor(multiplexer);
    }

    public void render(SpriteBatch batch) {
        joystickView.render(batch);
        buttonsView.render(batch);
    }
}
