package com.dragons.game.playerController;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class ControllerView {

    private final Texture upTexture = new Texture("upArrow.PNG");
    private final Texture downTexture = new Texture("downArrow.PNG");
    private final Texture leftTexture = new Texture("leftArrow.PNG");
    private final Texture rightTexture = new Texture("rightArrow.PNG");

    private final Rectangle upButtonRectangle;
    private final Rectangle downButtonRectangle;
    private final Rectangle leftButtonRectangle;
    private final Rectangle rightButtonRectangle;

    private final Rectangle allButtonRectangle;

    public ControllerView(int xPos, int yPos) {
        int textureSize = upTexture.getHeight();  // Assumes all textures have equal size. In this case 80

        allButtonRectangle = new Rectangle(xPos, yPos, 3*textureSize, 3*textureSize);

        upButtonRectangle = new Rectangle(allButtonRectangle.x + textureSize, allButtonRectangle.y + 2*textureSize, upTexture.getWidth(), upTexture.getHeight());
        downButtonRectangle = new Rectangle(allButtonRectangle.x + textureSize, allButtonRectangle.y, upTexture.getWidth(), upTexture.getHeight());
        leftButtonRectangle = new Rectangle(allButtonRectangle.x, allButtonRectangle.y + textureSize, upTexture.getWidth(), upTexture.getHeight());
        rightButtonRectangle = new Rectangle(allButtonRectangle.x + 2*textureSize, allButtonRectangle.y + textureSize, upTexture.getWidth(), upTexture.getHeight());
    }

    public void registerInput() {
        Vector2 touch = new Vector2(Gdx.input.getX(), Gdx.input.getY());
        boolean up = upButtonRectangle.contains(touch.x, touch.y);
        boolean down = downButtonRectangle.contains(touch.x, touch.y);
        boolean left = leftButtonRectangle.contains(touch.x, touch.y);
        boolean right = rightButtonRectangle.contains(touch.x, touch.y);
    }

    public void render() {
        
    }

}
