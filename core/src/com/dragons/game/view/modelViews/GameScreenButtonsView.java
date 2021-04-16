package com.dragons.game.view.modelViews;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.dragons.game.utilities.Constants;
import com.dragons.game.view.modelViews.IModelView;

import static com.dragons.game.utilities.Constants.BOMB_BUTTON_SCALING;
import static com.dragons.game.utilities.Constants.EXIT_BUTTON_SCALING;

public class GameScreenButtonsView implements IModelView {
    private final Texture exitButton;
    private final Texture dropBombTexture;

    private final Rectangle exitButtonBounds;
    private final Rectangle dropBombBounds;

    int dropBombPosX, dropBombPosY, dropBombHeight, dropBombWidth;
    int exitButtonPosX, exitButtonPosY, exitButtonHeight, exitButtonWidth;

    public GameScreenButtonsView() {
        exitButton = new Texture("exitBtn_small.png");
        dropBombTexture = new Texture("bombBtn_small.png");

        dropBombPosX = (int) (Constants.VIRTUAL_WIDTH - dropBombTexture.getWidth()*BOMB_BUTTON_SCALING - dropBombTexture.getHeight());
        dropBombPosY = (int) (dropBombTexture.getHeight());
        exitButtonPosX = (int) (Constants.VIRTUAL_WIDTH - exitButton.getWidth()*EXIT_BUTTON_SCALING - exitButton.getHeight());
        exitButtonPosY = (int) (Constants.VIRTUAL_HEIGHT - exitButton.getHeight()*EXIT_BUTTON_SCALING - exitButton.getHeight()/4);

        dropBombWidth = (int) (dropBombTexture.getWidth()*BOMB_BUTTON_SCALING);
        dropBombHeight = (int) (dropBombTexture.getHeight()*BOMB_BUTTON_SCALING);
        exitButtonWidth = (int) (exitButton.getWidth()*EXIT_BUTTON_SCALING);
        exitButtonHeight = (int) (exitButton.getHeight()*EXIT_BUTTON_SCALING);

        dropBombBounds = new Rectangle(dropBombPosX, dropBombPosY, dropBombWidth, dropBombHeight);
        exitButtonBounds = new Rectangle(exitButtonPosX, exitButtonPosY, exitButtonWidth, exitButtonHeight);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.draw(dropBombTexture, dropBombPosX, dropBombPosY, dropBombWidth, dropBombHeight);
        sb.draw(exitButton, exitButtonPosX, exitButtonPosY, exitButtonWidth, exitButtonHeight);
    }

    public Rectangle getExitButtonBounds() {
        return exitButtonBounds;
    }

    public Rectangle getDropBombBounds() {
        return dropBombBounds;
    }
}
