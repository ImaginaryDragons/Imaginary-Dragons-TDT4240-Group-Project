package com.dragons.game.controller.playerController;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragons.game.controller.gameWorld.GameObject;
import com.dragons.game.controller.gameWorld.GameWorld;
import com.dragons.game.view.componentViews.ExitButtonView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

/**
 * Responsible for handling input from screen.
 */
public class InputHandler {
    private final PlayerController playerController1;
    private final PlayerController playerController2;
    private final ExitButtonView exitButtonView;

    /**
     * Instantiates player controllers and sets the multiplexer as InputProcessor
     * @param camera to unproject input
     * @param manager for getting textures to the render methods
     * @param gameWorld for placing bombs
     */
    public InputHandler(OrthographicCamera camera, AnnotationAssetManager manager, GameWorld gameWorld) {
        playerController1 = new PlayerController(camera, manager, gameWorld, true);
        playerController2 = new PlayerController(camera, manager, gameWorld, false);

        exitButtonView = new ExitButtonView(manager);
        ExitButton exitButton = new ExitButton(camera, exitButtonView.getBounds());

        InputMultiplexer multiplexer = new InputMultiplexer(
                playerController1.getJoystick(),
                playerController2.getJoystick(),
                playerController1.getDropBombButton(),
                playerController2.getDropBombButton(),
                exitButton);

        Gdx.input.setInputProcessor(multiplexer);
    }

    public void addPlayer(GameObject player, boolean player1) {
        if (player1) {
            playerController1.addPlayer(player);
        } else {
            playerController2.addPlayer(player);
        }
    }

    public void render(SpriteBatch batch) {
        playerController1.render(batch);
        playerController2.render(batch);
        exitButtonView.render(batch);
    }
}
