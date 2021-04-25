package com.dragons.game.controller.playerController;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.controller.gameWorld.GameObject;
import com.dragons.game.controller.gameWorld.GameWorld;
import com.dragons.game.view.componentViews.DropBombButtonView;
import com.dragons.game.view.componentViews.JoystickView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

public class PlayerController {
    private final Joystick joystick;
    private final JoystickView joystickView;
    private final DropBombButton dropBombButton;
    private final DropBombButtonView dropBombButtonView;

    public PlayerController(OrthographicCamera camera, AnnotationAssetManager manager, GameWorld gameWorld, boolean isPlayerOne) {
        joystick = new Joystick(camera, isPlayerOne);
        joystickView = new JoystickView(joystick);

        dropBombButtonView = new DropBombButtonView(manager, isPlayerOne);
        dropBombButton = new DropBombButton(camera, dropBombButtonView.getBounds(), gameWorld);
    }

    public void addPlayer(GameObject player) {
        joystick.addPlayer(player);
        dropBombButton.addPlayer(player);
    }

    public void render(SpriteBatch sb) {
        joystickView.render(sb);
        dropBombButtonView.render(sb);
    }

    public Joystick getJoystick() {
        return joystick;
    }

    public DropBombButton getDropBombButton() {
        return dropBombButton;
    }
}
