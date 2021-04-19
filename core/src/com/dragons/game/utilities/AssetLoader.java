package com.dragons.game.utilities;

import com.badlogic.gdx.graphics.Texture;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

public class AssetLoader<BACKGROUND, STARTGAME_BTN, JOINGAME_BTN> {
    private static final AssetLoader ourInstance = new AssetLoader();


    /** ENTER ALL TEXTURE PATHS HERE
     * AssetAnnotationManager: https://man.sr.ht/~dermetfan/libgdx-utils/ *
     * https://man.sr.ht/~dermetfan/libgdx-utils/net.dermetfan.gdx.assets.AnnotationAssetManager.md
     * */

    public static AssetLoader getInstance() {
        return ourInstance;
    }

    @AnnotationAssetManager.Asset(Texture.class)
    public static final String
            DRAGON_SLIM_RED = "red_dragon_slim-1.png",
            DRAGON_MIDDLE_RED = "red_dragon_middle-1.png",
            DRAGON_WIDE_RED = "red_dragon_wide-1.png",


            DRAGON_SLIM_BLUE = "b3.png",
            DRAGON_MIDDLE_BLUE = "b2.png",
            DRAGON_WIDE_BLUE = "b1.png",

            DRAGON_SLIM_GREEN = "g3.png",
            DRAGON_MIDDLE_GREEN = "g2.png",
            DRAGON_WIDE_GREEN = "g1.png",

            DRAGON_SLIM_YELLOW = "y3.png",
            DRAGON_MIDDLE_YELLOW = "y2.png",
            DRAGON_WIDE_YELLOW = "y1.png",


            /****************** BLOCKS *******************/


            //INDESTRUCTIBLE_BLOCK = "",
            DESTRUCTIBLE_BLOCK = "Rock.png",



            /****************** POWER-UPS *******************/

            /*

            RANGE_POWERUP = "",
            BOMB_CAP_POWERUP = "",
            SPEED_POWERUP = "",

             */

            /***************** FIRE ************************/

            FIREBALL ="fireball.png",
            EXPLOSION="Explosion.png",

            /***************** MENU SCREEN ************************/

            BACKGROUND = "grey_background.jpeg",
            STARTGAME_BTN = "start_game.jpeg",
            JOINGAME_BTN = "join_game.jpeg",

            RANGE_POWERUP = "bomb_range_powerup.png",
            BOMB_CAP_POWERUP = "bomb_cap_powerup.png",
            SPEED_POWERUP = "dragon_wings.png",



            /***************** BOMB AND FIRE ************************/

            BOMB1 = "bomb1.png",
            BOMB2 = "bomb2.png",
            BOMB3 = "bomb3.png",
            BOMB4 = "bomb4.png",
            /*BOMB = "FireEgg.png",
            FIREBALL ="fireball1.png",
            EXPLOSION="Explosion.png";*/
            EXPLOSION1= "explosion1.png",
            EXPLOSION2= "explosion2.png",
            EXPLOSION3= "explosion3.png",
            EXPLOSION4= "explosion4.png",
            EXPLOSION5= "explosion5.png",


            /***************** PLAYER CONTROLLER BUTTONS ************************/
  
            EXIT_BTN = "exitBtn_small.png",
            BOMB_BTN = "bombBtn_small.png",


            /*********** HEALTH *************/
            FULL_HEALTH = "fullhealth.png",
            EMPTY_HEALTH = "emptyhealth.png";

            // LAST ELEMENT MUST HAVE ';'!!

    private AssetLoader(){}


}
