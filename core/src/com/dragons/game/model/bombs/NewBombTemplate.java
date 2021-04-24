package com.dragons.game.model.bombs;

import com.badlogic.gdx.math.Vector2;

public class NewBombTemplate extends Bomb{

    private static final boolean isStatic = true;       // Non-movable object
    private static final boolean isSensor = true;       // Doesnt collide with other objects in thw world
    private static final float detonationTime = 1f;     // Explodes after 1 second
    private static final float fireDisplayTime = 1f;    // Fire is displayed for 1 second
    private static final int startingRange = 2;         // Starting range of the bomb

    public NewBombTemplate(Vector2 pos, float width, float height, int extraRange, BombType type) {
        super(pos, width, height, startingRange + extraRange, type, isStatic, isSensor);
        super.setDetonationTime(detonationTime);    // Overrides the default value of the detonationTime
        fire.setDisplayTime(fireDisplayTime);       // Overrides the default value of the fireDisplayTime
    }

    @Override
    public void hitByFire() {
        bombExploded = false;   // This bomb does not explode when in contact with fire
    }
}
