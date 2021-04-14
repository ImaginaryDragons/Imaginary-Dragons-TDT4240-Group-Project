package com.dragons.game.model.bomb;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.dragons.game.model.IModelType;
import com.dragons.game.model.Model;


public class Fire extends Model {

    public Fire(Vector2 position, IModelType type, float width, float height) {
        super(position, type, width, height);

        final PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2f, height / 2f);
        super.setShape(shape);
    }

}
