package com.dragons.game.view.componentViews;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dragons.game.DragonsGame;
import com.dragons.game.networking.FirebasePlayer;
import com.dragons.game.view.IView;

public class TimerView implements IView {
    public AssetManager assets;
    public Stage stage;

    private Skin skin;
    private BitmapFont font;

    //Mario score/time Tracking Variables
    private Integer worldTimer;
    private boolean timeUp; // true when the world timer reaches 0
    private float timeCount;
    private int scoreCount;

    //Scene2D widgets
    private final Label countdownLabel;
    private Label timeLabel;

    public TimerView(AssetManager assets, OrthographicCamera camera) {
        worldTimer = 600;
        timeCount = 0;
        scoreCount = 1;

        firebasePlayer = new FirebasePlayer();
        stage = new Stage(new StretchViewport(camera.viewportWidth, camera.viewportHeight, camera));

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Arcon.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();

        params.size = 24;
        params.color = Color.WHITE;
        font = generator.generateFont(params);

        this.skin = new Skin();
        this.skin.addRegions(assets.get("uiskin.atlas", TextureAtlas.class));
        this.skin.add("default-font", font);
        this.skin.load(Gdx.files.internal("uiskin.json"));


        Table table = new Table();
        //Top-Align table
        table.top();
        //make the table fill the entire stage
        table.setFillParent(true);

        //define our labels using the String, and a Label style consisting of a font and color
        countdownLabel = new Label(String.format("%03d", worldTimer), skin);
        timeLabel = new Label("TIME", skin);

        //add our labels to our table, padding the top, and giving them all equal width with expandX
        table.add(timeLabel).expandX().padTop(10);
        //add a second row to our table
        table.row();
        table.add(countdownLabel).expandX();

        //add our table to the stage
        stage.addActor(table);

    }

    @Override
    public void update(float delta) {
        timeCount += delta;
        if(timeCount >= 1){
            if (worldTimer > 1) {
                worldTimer--;
                scoreCount++;
            } else {
                timeUp = true;
            }
            countdownLabel.setText(String.format("%03d", worldTimer));
            timeCount = 0;
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        stage.draw();
    }

    public boolean isTimeUp() { return timeUp; }

    public int getScoreCount(){
        return scoreCount;
    }
}

