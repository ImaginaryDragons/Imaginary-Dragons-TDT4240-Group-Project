package com.dragons.game.utilities;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;

public class AssetDescriptors {

    /**DEPRECATED CLASS - IGNORE!!
     *
     * Stores what type of asset a specified filepath is
     * https://www.codinginsights.blog/libgdx-assetmanager/ **/

    /******************CHARACTERS*******************/

    public static final AssetDescriptor<Texture> CharUpBlue = new AssetDescriptor<Texture>(Assets.CHARACTER_UP_BLUE, Texture.class);
    public static final AssetDescriptor<Texture> CharDownBlue = new AssetDescriptor<Texture>(Assets.CHARACTER_DOWN_BLUE, Texture.class);
    public static final AssetDescriptor<Texture> CharLeftBlue = new AssetDescriptor<Texture>(Assets.CHARACTER_LEFT_BLUE, Texture.class);
    public static final AssetDescriptor<Texture> CharRightBlue = new AssetDescriptor<Texture>(Assets.CHARACTER_RIGHT_BLUE, Texture.class);
    public static final AssetDescriptor<Texture> CharUpRunningBlue = new AssetDescriptor<Texture>(Assets.CHARACTER_UP_RUNNING_BLUE, Texture.class);
    public static final AssetDescriptor<Texture> CharDownRunningBlue = new AssetDescriptor<Texture>(Assets.CHARACTER_DOWN_RUNNING_BLUE, Texture.class);
    public static final AssetDescriptor<Texture> CharLeftRunningBlue = new AssetDescriptor<Texture>(Assets.CHARACTER_LEFT_RUNNING_BLUE, Texture.class);
    public static final AssetDescriptor<Texture> CharRightRunningBlue = new AssetDescriptor<Texture>(Assets.CHARACTER_RIGHT_RUNNING_BLUE, Texture.class);

    public static final AssetDescriptor<Texture> CharUpRed = new AssetDescriptor<Texture>(Assets.CHARACTER_UP_RED, Texture.class);
    public static final AssetDescriptor<Texture> CharDownRed = new AssetDescriptor<Texture>(Assets.CHARACTER_DOWN_RED, Texture.class);
    public static final AssetDescriptor<Texture> CharLeftRed = new AssetDescriptor<Texture>(Assets.CHARACTER_LEFT_RED, Texture.class);
    public static final AssetDescriptor<Texture> CharRightRed = new AssetDescriptor<Texture>(Assets.CHARACTER_RIGHT_RED, Texture.class);
    public static final AssetDescriptor<Texture> CharUpRunningRed = new AssetDescriptor<Texture>(Assets.CHARACTER_UP_RUNNING_RED, Texture.class);
    public static final AssetDescriptor<Texture> CharDownRunningRed = new AssetDescriptor<Texture>(Assets.CHARACTER_DOWN_RUNNING_RED, Texture.class);
    public static final AssetDescriptor<Texture> CharLeftRunningRed = new AssetDescriptor<Texture>(Assets.CHARACTER_LEFT_RUNNING_RED, Texture.class);
    public static final AssetDescriptor<Texture> CharRightRunningRed = new AssetDescriptor<Texture>(Assets.CHARACTER_RIGHT_RUNNING_RED, Texture.class);

    public static final AssetDescriptor<Texture> CharUpGreen = new AssetDescriptor<Texture>(Assets.CHARACTER_UP_GREEN, Texture.class);
    public static final AssetDescriptor<Texture> CharDownGreen = new AssetDescriptor<Texture>(Assets.CHARACTER_DOWN_GREEN, Texture.class);
    public static final AssetDescriptor<Texture> CharLeftGreen = new AssetDescriptor<Texture>(Assets.CHARACTER_LEFT_GREEN, Texture.class);
    public static final AssetDescriptor<Texture> CharRightGreen = new AssetDescriptor<Texture>(Assets.CHARACTER_RIGHT_GREEN, Texture.class);
    public static final AssetDescriptor<Texture> CharUpRunningGreen = new AssetDescriptor<Texture>(Assets.CHARACTER_UP_RUNNING_GREEN, Texture.class);
    public static final AssetDescriptor<Texture> CharDownRunningGreen = new AssetDescriptor<Texture>(Assets.CHARACTER_DOWN_RUNNING_GREEN, Texture.class);
    public static final AssetDescriptor<Texture> CharLeftRunningGreen = new AssetDescriptor<Texture>(Assets.CHARACTER_LEFT_RUNNING_GREEN, Texture.class);
    public static final AssetDescriptor<Texture> CharRightRunningGreen = new AssetDescriptor<Texture>(Assets.CHARACTER_RIGHT_RUNNING_GREEN, Texture.class);

    public static final AssetDescriptor<Texture> CharUpYellow = new AssetDescriptor<Texture>(Assets.CHARACTER_UP_YELLOW, Texture.class);
    public static final AssetDescriptor<Texture> CharDownYellow = new AssetDescriptor<Texture>(Assets.CHARACTER_DOWN_YELLOW, Texture.class);
    public static final AssetDescriptor<Texture> CharLeftYellow = new AssetDescriptor<Texture>(Assets.CHARACTER_LEFT_YELLOW, Texture.class);
    public static final AssetDescriptor<Texture> CharRightYellow = new AssetDescriptor<Texture>(Assets.CHARACTER_RIGHT_YELLOW, Texture.class);
    public static final AssetDescriptor<Texture> CharUpRunningYellow = new AssetDescriptor<Texture>(Assets.CHARACTER_UP_RUNNING_YELLOW, Texture.class);
    public static final AssetDescriptor<Texture> CharDownRunningYellow = new AssetDescriptor<Texture>(Assets.CHARACTER_DOWN_RUNNING_YELLOW, Texture.class);
    public static final AssetDescriptor<Texture> CharLeftRunningYellow = new AssetDescriptor<Texture>(Assets.CHARACTER_LEFT_RUNNING_YELLOW, Texture.class);
    public static final AssetDescriptor<Texture> CharRightRunningYellow = new AssetDescriptor<Texture>(Assets.CHARACTER_RIGHT_RUNNING_YELLOW, Texture.class);

    /******************BLOCKS*******************/

    public static final AssetDescriptor<Texture> IndestructibleBlock = new AssetDescriptor<Texture>(Assets.INDESTRUCTIBLE_BLOCK, Texture.class);
    public static final AssetDescriptor<Texture> DestructibleBlock = new AssetDescriptor<Texture>(Assets.DESTRUCTIBLE_BLOCK, Texture.class);

    /******************POWER-UPS*******************/

    public static final AssetDescriptor<Texture> RangePowerUp = new AssetDescriptor<Texture>(Assets.RANGE_POWERUP, Texture.class);
    public static final AssetDescriptor<Texture> BombCapPowerUp = new AssetDescriptor<Texture>(Assets.BOMB_CAP_POWERUP, Texture.class);
    public static final AssetDescriptor<Texture> SpeedPowerUp = new AssetDescriptor<Texture>(Assets.SPEED_POWERUP, Texture.class);

    // TODO: Add other sprites you want to use!

    private AssetDescriptors(){}

}
