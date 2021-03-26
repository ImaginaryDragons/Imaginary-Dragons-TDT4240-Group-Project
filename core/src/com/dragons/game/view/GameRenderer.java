package com.dragons.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class GameRenderer {

    private World gameWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch spriteBatch;
    TiledMapRenderer tiledMapRenderer;
    TiledMap tiledMap;

    public GameRenderer(World world) {
        gameWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, 204);
        // TODO: Get viewport parameters from config
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        spriteBatch = new SpriteBatch();
        spriteBatch.setProjectionMatrix(cam.combined);
        tiledMap = new TmxMapLoader().load("TiledMapNew.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
    }

    public void render() {
        Gdx.app.log("GameRenderer", "render");

        // 1. Draw a black background

        //Gdx.gl.glClearColor(0.5f,0,0,1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cam.update();
        tiledMapRenderer.setView(cam);
        tiledMapRenderer.render();

        // TODO: 2. Render the elements in the game world

    }
}
