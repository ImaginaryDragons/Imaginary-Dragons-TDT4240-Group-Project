package com.dragons.game.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.dragons.game.DragonsGame;

public class LoadingScreen implements Screen {

    private final DragonsGame dragonsGame;
    private ShapeRenderer shapeRenderer;


    private float progress;

    public LoadingScreen(final DragonsGame dragonsGame) {
        this.dragonsGame = dragonsGame;
        this.shapeRenderer = new ShapeRenderer();

    }

    private void queueAssets() {
        dragonsGame.assets.load("logo.png", Texture.class);
        dragonsGame.assets.load("over.png", Texture.class);
        dragonsGame.assets.load("uiskin.atlas", TextureAtlas.class);
    }

    @Override
    public void show() {
        System.out.println("LOADING");
        shapeRenderer.setProjectionMatrix(dragonsGame.camera.combined);
        this.progress = 0f;
        queueAssets();
    }

    private void update(float delta) {
        progress = MathUtils.lerp(progress, dragonsGame.assets.getProgress(), .1f);
        if (dragonsGame.assets.update() && progress >= dragonsGame.assets.getProgress() - .001f) {
            dragonsGame.setScreen(new MenuScreen(dragonsGame));
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.GRAY);
        shapeRenderer.rect(32, dragonsGame.camera.viewportHeight / 2 - 8, dragonsGame.camera.viewportWidth - 64, 16);

        shapeRenderer.setColor(Color.LIME);
        shapeRenderer.rect(32, dragonsGame.camera.viewportHeight / 2 - 8, progress * (dragonsGame.camera.viewportWidth - 64), 16);
        shapeRenderer.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}