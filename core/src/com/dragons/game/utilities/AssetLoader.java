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
            DRAGON_SLIM_RED = "red_dragon_slim-1.png",
            DRAGON_MIDDLE_RED = "red_dragon_middle-1.png",
            DRAGON_WIDE_RED = "red_dragon_wide-1.png",

    /*
            DRAGON_SLIM_BLUE = "",
            DRAGON_MIDDLE_BLUE = "",
            DRAGON_WIDE_BLUE = "",

            DRAGON_SLIM_GREEN = "",
            DRAGON_MIDDLE_GREEN = "",
            DRAGON_WIDE_GREEN = "",

            DRAGON_SLIM_YELLOW = "",
            DRAGON_MIDDLE_YELLOW = "",
            DRAGON_WIDE_YELLOW = "",

     */


            /****************** BLOCKS *******************/

            /*

            INDESTRUCTIBLE_BLOCK = "",
            DESTRUCTIBLE_BLOCK = "",

             */


            /****************** POWER-UPS *******************/

            /*

            RANGE_POWERUP = "",
            BOMB_CAP_POWERUP = "",
            SPEED_POWERUP = "",

             */

            /***************** FIRE ************************/

            FIREBALL ="fireball.png",
            EXPLOSION="Explosion.png";

            // LAST ELEMENT MUST HAVE ';'!!

    private AssetLoader(){}
}
