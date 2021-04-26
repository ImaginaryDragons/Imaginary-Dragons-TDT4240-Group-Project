package com.dragons.game.view.UIViews;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.dragons.game.utilities.Constants;
import com.dragons.game.view.IView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.EXIT_BTN;
import static com.dragons.game.utilities.Constants.EDGE_MARGIN;
import static com.dragons.game.utilities.Constants.EXIT_BUTTON_SCALING;

public class ExitButtonView implements IView {
    private final Texture exitButton;
    private final Rectangle exitButtonBounds;
    private final int exitButtonPosX, exitButtonPosY, exitButtonHeight, exitButtonWidth;

    public ExitButtonView(AnnotationAssetManager manager) {
        exitButton = manager.get(EXIT_BTN, Texture.class);


        exitButtonPosX = (int) (Constants.VIEWPORT_WIDTH /2 - exitButton.getWidth()*EXIT_BUTTON_SCALING/2);
        exitButtonPosY = (int) (EDGE_MARGIN);
        exitButtonWidth = (int) (exitButton.getWidth()*EXIT_BUTTON_SCALING);
        exitButtonHeight = (int) (exitButton.getHeight()*EXIT_BUTTON_SCALING);

        exitButtonBounds = new Rectangle(exitButtonPosX, exitButtonPosY, exitButtonWidth, exitButtonHeight);
    }
    @Override
    public void render(SpriteBatch sb) {
        sb.draw(exitButton, exitButtonPosX, exitButtonPosY, exitButtonWidth, exitButtonHeight);
    }

    public Rectangle getBounds() {
        return exitButtonBounds;
    }
}
