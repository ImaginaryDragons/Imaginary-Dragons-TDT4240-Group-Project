package com.dragons.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.utilities.AssetLoader;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

public class GameRenderer {

    private World gameWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch spriteBatch;
    private AnnotationAssetManager manager;

    // Asset loading: https://github.com/libgdx/libgdx/wiki/Managing-your-assets
    // https://www.codinginsights.blog/libgdx-assetmanager/

    public GameRenderer(World world, AnnotationAssetManager manager) {
        this.gameWorld = world;
        this.manager = manager;
        this.cam = new OrthographicCamera();
        this.cam.setToOrtho(true, 136, 204); //Hvor kommer parametrene fra nå igjen??
        // TODO: Get viewport parameters from config
        this.shapeRenderer = new ShapeRenderer();
        this.shapeRenderer.setProjectionMatrix(cam.combined);
        this.spriteBatch = new SpriteBatch();
        this.spriteBatch.setProjectionMatrix(cam.combined);
    }


    public void render() {
        Gdx.app.log("GameRenderer", "render");

        // 1. Draw a colored background
        Gdx.gl.glClearColor(0.5f,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // TODO: 2. Render the elements in the game world somehow!!

    }

    // TODO: Write functionality for rendering the gameworld!
    /** A way of doing this could be to create a mapping from an Enum to a gameObject.
     * The Enum states what kind of object this is, while the gameObject implements a gameObject
     * interface. Alternatively, we can assign all objects a type that is part of our global enum!**/

    private void loadAssets(){
        manager.load(AssetLoader.class);
        manager.finishLoading();
    }

    // Loads all the assets needed for GameScreen
    /*
    public void loadAssets() {
        manager.load(AssetDescriptors.CharUpBlue);
        manager.load(AssetDescriptors.CharDownBlue);
        manager.load(AssetDescriptors.CharLeftBlue);
        manager.load(AssetDescriptors.CharRightBlue);
        manager.load(AssetDescriptors.CharUpRunningBlue);
        manager.load(AssetDescriptors.CharDownRunningBlue);
        manager.load(AssetDescriptors.CharLeftRunningBlue);
        manager.load(AssetDescriptors.CharRightRunningBlue);

        manager.load(AssetDescriptors.CharUpRed);
        manager.load(AssetDescriptors.CharDownRed);
        manager.load(AssetDescriptors.CharLeftRed);
        manager.load(AssetDescriptors.CharRightRed);
        manager.load(AssetDescriptors.CharUpRunningRed);
        manager.load(AssetDescriptors.CharDownRunningRed);
        manager.load(AssetDescriptors.CharLeftRunningRed);
        manager.load(AssetDescriptors.CharRightRunningRed);

        manager.load(AssetDescriptors.CharUpGreen);
        manager.load(AssetDescriptors.CharDownGreen);
        manager.load(AssetDescriptors.CharLeftGreen);
        manager.load(AssetDescriptors.CharRightGreen);
        manager.load(AssetDescriptors.CharUpRunningGreen);
        manager.load(AssetDescriptors.CharDownRunningGreen);
        manager.load(AssetDescriptors.CharLeftRunningGreen);
        manager.load(AssetDescriptors.CharRightRunningGreen);

        manager.load(AssetDescriptors.CharUpYellow);
        manager.load(AssetDescriptors.CharDownYellow);
        manager.load(AssetDescriptors.CharLeftYellow);
        manager.load(AssetDescriptors.CharRightYellow);
        manager.load(AssetDescriptors.CharUpRunningYellow);
        manager.load(AssetDescriptors.CharDownRunningYellow);
        manager.load(AssetDescriptors.CharLeftRunningYellow);
        manager.load(AssetDescriptors.CharRightRunningYellow);

        manager.load(AssetDescriptors.IndestructibleBlock);
        manager.load(AssetDescriptors.DestructibleBlock);

        manager.load(AssetDescriptors.SpeedPowerUp);
        manager.load(AssetDescriptors.BombCapPowerUp);
        manager.load(AssetDescriptors.RangePowerUp);

        }
     */

        // TODO: Add other sprites you want to use!
}
