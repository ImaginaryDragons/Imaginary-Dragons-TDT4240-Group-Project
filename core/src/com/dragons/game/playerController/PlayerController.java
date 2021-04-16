package com.dragons.game.playerController;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.model.IModel;
import com.dragons.game.model.gameWorld.GameObject;
import com.dragons.game.view.modelViews.DropBombButtonView;
import com.dragons.game.view.modelViews.ExitButtonView;
import com.dragons.game.view.modelViews.JoystickView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

public class PlayerController {
    private final Joystick joystick;
    private final JoystickView joystickView;
    private final DropBombButton dropBombButton;
    private final DropBombButtonView dropBombButtonView;
    private final ExitButton exitButton;
    private final ExitButtonView exitButtonView;

    public InputMultiplexer multiplexer;

    public PlayerController(OrthographicCamera camera, AnnotationAssetManager manager) {
        joystick = new Joystick(camera);
        joystickView = new JoystickView(joystick);  // TODO: Should probably decouple joystick from view, but unsure how

        dropBombButtonView = new DropBombButtonView(manager);
        dropBombButton = new DropBombButton(camera, dropBombButtonView.getBounds());  // TODO: Find way to get bounds of button without passing dropBombButtonView

        exitButtonView = new ExitButtonView(manager);
        exitButton = new ExitButton(camera, exitButtonView.getBounds());  // TODO: Find way to get bounds of button without passing exitButtonView

        multiplexer = new InputMultiplexer(joystick, dropBombButton, exitButton);
        Gdx.input.setInputProcessor(multiplexer);
    }

    public void addPlayer(GameObject player) {
        joystick.addPlayer(player);
        dropBombButton.addPlayer(player);
    }

    public void render(SpriteBatch sb) {
        joystickView.render(sb);
        dropBombButtonView.render(sb);
        exitButtonView.render(sb);
    }
}
