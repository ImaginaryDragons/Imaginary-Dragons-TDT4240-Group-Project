package com.dragons.game.model.bomb;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.IModelType;
import com.dragons.game.model.Model;
import com.dragons.game.view.modelViews.BombView;

public enum FireType implements IModelType {
    NORMALFIRE
}
public class Fire extends Model {

    private Vector2 position;
    private BombView bombView;

    public Fire(Vector2 position, IModelType type, float width, float height) {
        super(position, type, width, height);
    }


    public Vector2 getPosition() {
        return position;
    }
}
