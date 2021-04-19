package com.dragons.game.view.componentViews;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.dragons.game.utilities.Constants;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.EXIT_BTN;
import static com.dragons.game.utilities.Constants.EDGE_MARGIN;
import static com.dragons.game.utilities.Constants.EXIT_BUTTON_SCALING;

public class ExitButtonView {
    private final AnnotationAssetManager manager;
    private final Texture exitButton;
    private final Rectangle exitButtonBounds;
    private final int exitButtonPosX, exitButtonPosY, exitButtonHeight, exitButtonWidth;

    public ExitButtonView(AnnotationAssetManager manager) {
        this.manager = manager;
//        exitButton = manager.get(EXIT_BTN, Texture.class);
        exitButton = new Texture("exitBtn_small.png");

//        exitButtonPosX = (int) (Constants.VIRTUAL_WIDTH - exitButton.getWidth()*EXIT_BUTTON_SCALING - exitButton.getHeight());
        exitButtonPosX = (int) (Constants.VIRTUAL_WIDTH/2 - exitButton.getWidth()*EXIT_BUTTON_SCALING/2);
        exitButtonPosY = (int) (Constants.VIRTUAL_HEIGHT - exitButton.getHeight()*EXIT_BUTTON_SCALING - EDGE_MARGIN);
        exitButtonWidth = (int) (exitButton.getWidth()*EXIT_BUTTON_SCALING);
        exitButtonHeight = (int) (exitButton.getHeight()*EXIT_BUTTON_SCALING);

        exitButtonBounds = new Rectangle(exitButtonPosX, exitButtonPosY, exitButtonWidth, exitButtonHeight);
    }

    public void render(SpriteBatch sb) {
        sb.draw(exitButton, exitButtonPosX, exitButtonPosY, exitButtonWidth, exitButtonHeight);
    }

    public Rectangle getBounds() {
        return exitButtonBounds;
    }
}
