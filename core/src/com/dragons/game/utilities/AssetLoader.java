package com.dragons.game.utilities;

import com.badlogic.gdx.graphics.Texture;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

public class AssetLoader {

    /** ENTER ALL TEXTURE PATHS HERE
     * AssetAnnotationManager: https://man.sr.ht/~dermetfan/libgdx-utils/ *
     * https://man.sr.ht/~dermetfan/libgdx-utils/net.dermetfan.gdx.assets.AnnotationAssetManager.md
     * */

    @AnnotationAssetManager.Asset(Texture.class)
    public static final String
            CHARACTER_UP_BLUE = "",
            CHARACTER_DOWN_BLUE = "",
            CHARACTER_LEFT_BLUE = "",
            CHARACTER_RIGHT_BLUE = "",
            CHARACTER_UP_RUNNING_BLUE = "",
            CHARACTER_DOWN_RUNNING_BLUE = "",
            CHARACTER_LEFT_RUNNING_BLUE = "",
            CHARACTER_RIGHT_RUNNING_BLUE = "",

            CHARACTER_UP_RED = "",
            CHARACTER_DOWN_RED = "",
            CHARACTER_LEFT_RED = "",
            CHARACTER_RIGHT_RED = "",
            CHARACTER_UP_RUNNING_RED = "",
            CHARACTER_DOWN_RUNNING_RED = "",
            CHARACTER_LEFT_RUNNING_RED = "",
            CHARACTER_RIGHT_RUNNING_RED = "",

            CHARACTER_UP_GREEN = "",
            CHARACTER_DOWN_GREEN = "",
            CHARACTER_LEFT_GREEN = "",
            CHARACTER_RIGHT_GREEN = "",
            CHARACTER_UP_RUNNING_GREEN = "",
            CHARACTER_DOWN_RUNNING_GREEN = "",
            CHARACTER_LEFT_RUNNING_GREEN = "",
            CHARACTER_RIGHT_RUNNING_GREEN = "",

            CHARACTER_UP_YELLOW = "",
            CHARACTER_DOWN_YELLOW = "",
            CHARACTER_LEFT_YELLOW = "",
            CHARACTER_RIGHT_YELLOW = "",
            CHARACTER_UP_RUNNING_YELLOW = "",
            CHARACTER_DOWN_RUNNING_YELLOW = "",
            CHARACTER_LEFT_RUNNING_YELLOW = "",
            CHARACTER_RIGHT_RUNNING_YELLOW = "",

            /****************** BLOCKS *******************/

            INDESTRUCTIBLE_BLOCK = "",
            DESTRUCTIBLE_BLOCK = "",

            /****************** POWER-UPS *******************/

            RANGE_POWERUP = "",
            BOMB_CAP_POWERUP = "",
            SPEED_POWERUP = "",

            /****************** BOMB *******************/
            FIREBALL ="fireball.png",
            EXPLOSION="Explosion.png";

            // LAST ELEMENT MUST HAVE ';'!!

    private AssetLoader(){}
}
