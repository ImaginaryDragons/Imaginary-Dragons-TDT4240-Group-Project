package com.dragons.game.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.view.GameRenderer;

public class GameScreen extends ScreenAdapter {
    private World gameWorld;
    private GameRenderer gameRenderer;

    // TODO: Integrating the gameWorld onto the firebase server
    /*Right now the gameWorld is statically defined within our gamescreen. However, we need
    * some way of ensuring that the main gameworld is on our server and that this version is
    * primarily loaded from the server and then continuously updated. How this should be done is
    * not clear!
    * */

    public GameScreen() {
        //super();
        Gdx.app.log("GameScreen", "Attached");

        //float screenWidth = Gdx.graphics.getWidth();
        //float screenHeight = Gdx.graphics.getHeight();
        //float gameWidth = 136;

        // initialize gameWorld. Set Gravity 0 and not simulating inactive objects true
        gameWorld = new World(new Vector2(0,0), true);
        gameRenderer = new GameRenderer(gameWorld); // Initialize world renderer
    }

    @Override
    public void render(float delta) {
        Gdx.app.log("GameScreen", "Rendering");
        // TODO: gameWorld.step();

        // Explanation gameWorld step: http://www.iforce2d.net/b2dtut/worlds
        gameRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
        super.resize(width, height);
    }

    // TODO: At some point we want to remove all the override methods we haven't used!!
    // For now I'll leave them her so we can log whenever one is called for research purposes.

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
        super.show();
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
        super.hide();
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
        super.pause();
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
