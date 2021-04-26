package com.dragons.game.controller.playerController;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.controller.gameWorld.GameObject;
import com.dragons.game.controller.gameWorld.GameWorld;
import com.dragons.game.view.UIViews.DropBombButtonView;
import com.dragons.game.view.UIViews.JoystickView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

/**
 * Contains joystick and bombButton for controlling the player. Each component of the
 * PlayerController is separated into controller and view.
 */
public class PlayerController {
    private final Joystick joystick;
    private final JoystickView joystickView;
    private final DropBombButton dropBombButton;
    private final DropBombButtonView dropBombButtonView;

    /**
     * Instatiates joystick with view and dropBombButton with view. Passes on parameters
     * @param camera to unproject screen input
     * @param manager to get textures for rendering
     * @param gameWorld for placing bombs with dropBombButton
     * @param isPlayerOne used to know which player to control
     */
    public PlayerController(OrthographicCamera camera, AnnotationAssetManager manager, GameWorld gameWorld, boolean isPlayerOne) {
        joystick = new Joystick(camera, isPlayerOne);
        joystickView = new JoystickView(joystick);

        dropBombButtonView = new DropBombButtonView(manager, isPlayerOne);
        dropBombButton = new DropBombButton(camera, dropBombButtonView.getBounds(), gameWorld);
    }

    /**
     * Adds player to a controller
     * @param player The player the controller should control
     */
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
