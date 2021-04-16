package com.dragons.game.view.modelViews;


import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.dragons.game.utilities.Constants;
import com.dragons.game.view.modelViews.IModelView;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import static com.dragons.game.utilities.AssetLoader.BOMB_BTN;
import static com.dragons.game.utilities.AssetLoader.EXIT_BTN;
import static com.dragons.game.utilities.Constants.BOMB_BUTTON_SCALING;
import static com.dragons.game.utilities.Constants.EXIT_BUTTON_SCALING;

public class DropBombButtonView implements IModelView {
    private final AnnotationAssetManager manager;
    private final Texture dropBombTexture;
    private final Rectangle dropBombBounds;
    int dropBombPosX, dropBombPosY, dropBombHeight, dropBombWidth;

    public DropBombButtonView(AnnotationAssetManager manager) {
        this.manager = manager;
//        dropBombTexture = manager.get(BOMB_BTN, Texture.class);
        dropBombTexture = new Texture("bombBtn_small.png");

        dropBombPosX = (int) (Constants.VIRTUAL_WIDTH - dropBombTexture.getWidth()*BOMB_BUTTON_SCALING - dropBombTexture.getHeight());
        dropBombPosY = (int) (dropBombTexture.getHeight());

        dropBombWidth = (int) (dropBombTexture.getWidth()*BOMB_BUTTON_SCALING);
        dropBombHeight = (int) (dropBombTexture.getHeight()*BOMB_BUTTON_SCALING);

        dropBombBounds = new Rectangle(dropBombPosX, dropBombPosY, dropBombWidth, dropBombHeight);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.draw(dropBombTexture, dropBombPosX, dropBombPosY, dropBombWidth, dropBombHeight);
    }

    public Rectangle getBounds() {
        return dropBombBounds;
    }
}
