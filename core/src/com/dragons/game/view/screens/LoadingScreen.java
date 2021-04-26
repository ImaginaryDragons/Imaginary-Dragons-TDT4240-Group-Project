package com.dragons.game.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.dragons.game.utilities.Constants;

public class LoadingScreen extends ScreenAdapter {

    private final ShapeRenderer shapeRenderer;
    private float progress;
    private final AssetManager assetManager;
    private final OrthographicCamera camera;

    public LoadingScreen(AssetManager assetManager, OrthographicCamera camera) {
        this.assetManager = assetManager;
        this.camera = camera;
        shapeRenderer = new ShapeRenderer();

    }

    private void queueAssets() {
        assetManager.load("components/logo.png", Texture.class);
        assetManager.load("components/over.png", Texture.class);
        assetManager.load("components/highscores.png", Texture.class);
        assetManager.load("uiskin.atlas", TextureAtlas.class);
    }

    @Override
    public void show() {
        System.out.println("LOADING");
        shapeRenderer.setProjectionMatrix(camera.combined);
        this.progress = 0f;
        queueAssets();
    }

    private void update(float delta) {
        progress = MathUtils.lerp(progress, assetManager.getProgress(), .1f);
        if (assetManager.update() && progress >= assetManager.getProgress() - .001f) {
            ScreenManager.getInstance().setMenuScreen();
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.GRAY);
        shapeRenderer.rect(32, camera.viewportHeight / 2 - 8, camera.viewportWidth - 64, 16);

        shapeRenderer.setColor(Color.LIME);
        shapeRenderer.rect(32, camera.viewportHeight / 2 - 8, progress * (camera.viewportWidth - 64), 16);
        shapeRenderer.end();
    }



    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }




}