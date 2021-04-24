package com.dragons.game.model.bombs;

import com.badlogic.gdx.math.Vector2;
import com.dragons.game.utilities.Constants;

public class NewBombTemplate extends Bomb{

    private static final boolean isStatic = true;       // Non-movable object
    private static final boolean isSensor = true;       // Doesnt collide with other objects in thw world
    private static final float explodeTime = 1f;        // Explodes after 1 second
    private static final float fireDisplayTime = 1f;    // Fire is displayed for 1 second
    private static final int startingRange = Constants.InitBombRange;

    public NewBombTemplate(Vector2 pos, float width, float height, int bombRange, BombType type) {
        super(pos, width, height, startingRange + bombRange, type, isStatic, isSensor);
        super.setDetonationTime(explodeTime); // Overrides the default value of the explodeTime
        fire.setDisplayTime(fireDisplayTime);
    }

    @Override
    public void hitByFire() {
        bombExploded = false;   // This bomb does not explode when in contact with fire
    }
}
