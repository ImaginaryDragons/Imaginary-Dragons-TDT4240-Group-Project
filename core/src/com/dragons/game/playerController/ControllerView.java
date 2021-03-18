package com.dragons.game.playerController;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class ControllerView {

    private final Texture upTexture = new Texture("upArrow.PNG");
    private final Texture downTexture = new Texture("downArrow.PNG");
    private final Texture leftTexture = new Texture("leftArrow.PNG");
    private final Texture rightTexture = new Texture("rightArrow.PNG");

    private Rectangle upButtonRectangle;
    private Rectangle downButtonRectangle;
    private Rectangle leftButtonRectangle;
    private Rectangle rightButtonRectangle;

    public ControllerView(int xPos, int yPos) {
        
    }
}
