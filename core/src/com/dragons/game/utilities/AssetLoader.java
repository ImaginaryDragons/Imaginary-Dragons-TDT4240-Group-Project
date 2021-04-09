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
            DRAGON_SLIM_RED = "assets/red_dragon_slim.png",
            DRAGON_MIDDLE_RED = "assets/red_dragon_middle.png",
            DRAGON_WIDE_RED = "assets/red_dragon_wide.png",

            DRAGON_SLIM_BLUE = "",
            DRAGON_MIDDLE_BLUE = "",
            DRAGON_WIDE_BLUE = "",

            DRAGON_SLIM_GREEN = "",
            DRAGON_MIDDLE_GREEN = "",
            DRAGON_WIDE_GREEN = "",

            DRAGON_SLIM_YELLOW = "",
            DRAGON_MIDDLE_YELLOW = "",
            DRAGON_WIDE_YELLOW = "",


            /****************** BLOCKS *******************/

            INDESTRUCTIBLE_BLOCK = "",
            DESTRUCTIBLE_BLOCK = "",

            /****************** POWER-UPS *******************/

            RANGE_POWERUP = "",
            BOMB_CAP_POWERUP = "",
            SPEED_POWERUP = "",

            /***************** FIRE ************************/

            FIREBALL ="fireball.png",
            EXPLOSION="Explosion.png",

            /***************** JOYSTICK ************************/
            JOYSTICK_BG = "joystickBG.png",
            JOYSTICK_SPRITE = "joystick.png";

            // LAST ELEMENT MUST HAVE ';'!!

    private AssetLoader(){}
}
