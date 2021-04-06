package com.dragons.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.playerController.Joystick;
import com.dragons.game.model.gameWorld.GameWorld;
import com.dragons.game.utilities.AssetLoader;
import com.dragons.game.utilities.Constants;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

public class GameRenderer {

    private GameWorld gameWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch spriteBatch;
    private AnnotationAssetManager manager;
    private Joystick joystick;

    // Asset loading: https://github.com/libgdx/libgdx/wiki/Managing-your-assets
    // https://www.codinginsights.blog/libgdx-assetmanager/

    public GameRenderer(GameWorld world, AnnotationAssetManager manager) {
        this.gameWorld = world;
        this.manager = manager;
        this.cam = new OrthographicCamera();
        this.cam.setToOrtho(true, 136, 204); //Hvor kommer parametrene fra nå igjen??
        // TODO: Get viewport parameters from config
        this.shapeRenderer = new ShapeRenderer();
        this.shapeRenderer.setProjectionMatrix(cam.combined);
        this.spriteBatch = new SpriteBatch();
        this.spriteBatch.setProjectionMatrix(cam.combined);
        this.joystick = new Joystick(50,50); // Arguments should be (Constants.JoystickPosX, Constants.JoystickPosY)
    }

    public void render() {
        Gdx.app.log("GameRenderer", "render");

        // 1. Draw a colored background
        Gdx.gl.glClearColor(0.5f,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // TODO: 2. Render the elements in the game world somehow!!
//        spriteBatch.begin();
//        joystick.render(spriteBatch);
//        spriteBatch.end();
        joystick.update();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        joystick.render(shapeRenderer);
        shapeRenderer.end();
    }

    private void loadAssets(){
        manager.load(AssetLoader.class);
        manager.finishLoading();
    }

    private void renderWorld() {
        // TODO: Render objects
        // TODO: Render players
        // TODO: Render bombs
    }
}
