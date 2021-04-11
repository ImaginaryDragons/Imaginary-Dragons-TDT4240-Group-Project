package com.dragons.game.utilities;

public class Constants {

    public static final float PPM = 1f;
    public static final int FPS = 30;
    public static final float VIRTUAL_WIDTH = 480f;
    public static final float VIRTUAL_HEIGHT = 350f;

    public static final int InitPlayerHealth = 3; // Number of lives
    public static final int PlayerSpeed = 10; // RANDOM NUMBER FOR NOW
    public static final int PlayerSpeedBoostInc = 5;
    public static final float PlayerHeight = 10; // Has to be precalculated from a tile ratio!!
    public static final float PlayerWidth = 10; // Has to be precalculated from a tile ratio!!
    public static final int InitBombCap = 1;

    public static final int InitBombRange = 1; //Number of tiles range?? Would be nice and intuitive to use
    public static final float BombRangeBoostInc = 1.5f; // Number of tiles increased range
    public static final float BombExplodeTime = 2.5f; // Seconds before bomb is done exploding
    public static final float FireDisplayTime = 1.5f; // Seconds fire displays after bomb explodes
    public static final float BombReloadTime = BombExplodeTime + FireDisplayTime;



}