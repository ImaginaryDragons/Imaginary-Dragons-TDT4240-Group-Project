package com.dragons.game.utilities;

import com.badlogic.gdx.Gdx;

public class Constants {

    public static final int WorldWidth = 800;
    public static final int WorldHeight = 480;

    //TODO: fix bodyjitter on higher PPM
    public static final float PPM = 1f;
    public static final int FPS = 30;
    public static final float VIEWPORT_WIDTH = 480f;
    public static final float VIEWPORT_HEIGHT = 350f;

    public static final float FRAME_DURATION = 0.2f;

    public static final float PlayerScaleFactor = 0.9f;
    public static final float FireScaleFactor = 0.99f;
    public static final float BombScaleFactor = 0.8f;
    public static final float PowerUpScaleFactor = 0.85f;
    public static final float HealthScaleFactor = 0.7f;

    public static final int InitPlayerHealth = 3; // Number of lives
    public static final int PlayerSpeed = 125; // RANDOM NUMBER FOR NOW
    public static final int PlayerSpeedBoostInc = 5;
    public static final float PlayerHeight = 10; // Has to be precalculated from a tile ratio!!
    public static final float PlayerWidth = 10; // Has to be precalculated from a tile ratio!!
    public static final int InitBombCap = 1;

    public static final int InitBombRange = 1; //Number of tiles range?? Would be nice and intuitive to use
    public static final float BombRangeBoostInc = 1.5f; // Number of tiles increased range
    public static final float BombExplodeTime = 3f; // Seconds before bomb is done exploding
    public static final float FireDisplayTime = 1f; // Seconds fire displays after bomb explodes
    public static final float BombReloadTime = BombExplodeTime + FireDisplayTime;

    public static final int JOYSTICK_PERIMETER_RADIUS = 50;
    public static final float JOYSTICK_ORIGIN_X = JOYSTICK_PERIMETER_RADIUS;
    public static final float JOYSTICK_ORIGIN_Y = JOYSTICK_PERIMETER_RADIUS;
    public static final int JOYSTICK_RADIUS = 10;

    public static final float EXIT_BUTTON_SCALING = 2;
    public static final float BOMB_BUTTON_SCALING = 2.5f;

    public static final float EDGE_MARGIN = 2f;
  
    public static final int CleanupCounterLimit = 20;
}