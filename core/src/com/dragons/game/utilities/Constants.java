package com.dragons.game.utilities;

public class Constants {

    public static final int WorldWidth = 800;
    public static final int WorldHeight = 480;

    public static final int TIMER = 300;

    /*      MAPS        */
    // LEVEL 1
    public static final String level1MapName = "TileMapLvl1.tmx";
    public static final String level1MapTxtFile = "mapLvl1.txt";

    // LEVEL 2
    public static final String level2MapName = "TileMapLvl2.tmx";
    public static final String level2MapTxtFile = "mapLvl2.txt";

    // LEVEL 3
    public static final String level3MapName = "TileMapLvl3.tmx";
    public static final String level3MapTxtFile = "mapLvl3.txt";




    public static final float PPM = 7f;
    public static final int FPS = 60;
    public static final float VIEWPORT_WIDTH = 480f;
    public static final float VIEWPORT_HEIGHT = 350f;

    public static final float FRAME_DURATION = 4f;

    public static final float PlayerScaleFactor = 0.99f;
    public static final float FireScaleFactor = 0.99f;
    public static final float BombScaleFactor = 0.8f;
    public static final float PowerUpScaleFactor = 0.85f;
    public static final float HealthScaleFactor = 0.7f;

    public static final int InitPlayerHealth = 3; // Number of lives
    public static final float PlayerSpeed = 100 /  PPM; // RANDOM NUMBER FOR NOW
    public static final int InitBombCap = 1;

    public static final int InitBombRange = 1; //Number of tiles range?? Would be nice and intuitive to use
    public static final float DefaultDetonationTime = 3f; // Seconds before bomb is done exploding
    public static final float FireDisplayTime = 1f; // Seconds fire displays after bomb explodes

    public static final int JOYSTICK_PERIMETER_RADIUS = 50;
    public static final float JOYSTICK_ORIGIN_X = JOYSTICK_PERIMETER_RADIUS;
    public static final float JOYSTICK_ORIGIN_Y = JOYSTICK_PERIMETER_RADIUS;
    public static final int JOYSTICK_RADIUS = 10;

    public static final float EXIT_BUTTON_SCALING = 2;
    public static final float BOMB_BUTTON_SCALING = 2.5f;

    public static final float EDGE_MARGIN = 2f;
  
    public static final int CleanupCounterLimit = 20;
}