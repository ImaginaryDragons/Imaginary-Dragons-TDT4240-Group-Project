package com.dragons.game.model.bombs;

import com.badlogic.gdx.math.Vector2;

public class NewBombTemplate extends Bomb{

    private static final boolean isStatic = true;   // Non-movable object
    private static final boolean isSensor = true;   // Doesnt collide with other objects in thw world
    private static final float loadingTime = 1f;    // Explodes after 1 second

    public NewBombTemplate(Vector2 pos, float width, float height, int bombRange, BombType type) {
        super(pos, width, height, bombRange, type, isStatic, isSensor);
        super.setLoadingTime(loadingTime); // Overrides the default value of the loading time
    }

    @Override
    public void hitByFire() {
        bombExploded = false;   // This bomb does not explode when in contact with fire
    }
}
