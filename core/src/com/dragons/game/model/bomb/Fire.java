package com.dragons.game.model.bomb;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModelType;
import com.dragons.game.model.Model;
import com.dragons.game.model.player.Player;
import com.dragons.game.view.modelViews.BombView;

public class Fire extends Model {

    private Vector2 position;
    private IModelType type;
    private float width, height;
    private Player player;

    public Fire(Vector2 position, IModelType type, float width, float height) {
        super(position, type, width, height);
        this.position =  position;
        this.type = type;
        this.width = width;
        this.height = height;
    }


    public IModelType getType() {
        return type;
    }

    public void setType(IModelType type) {
        this.type = type;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }


    @Override
    public void setPosition(Vector2 position) {
        this.position = position;
    }


    @Override
    public Vector2 getPosition() {
        return position;
    }

}
