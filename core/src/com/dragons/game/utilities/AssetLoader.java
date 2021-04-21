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
            /****************** PLAYERS *******************/

            DRAGON_SLIM_RED =   "dragons/red_dragon_slim-1.png",
            DRAGON_MIDDLE_RED = "dragons/red_dragon_middle-1.png",
            DRAGON_WIDE_RED =   "dragons/red_dragon_wide-1.png",


            DRAGON_SLIM_BLUE =      "dragons/b3.png",
            DRAGON_MIDDLE_BLUE =    "dragons/b2.png",
            DRAGON_WIDE_BLUE =      "dragons/b1.png",

            DRAGON_SLIM_GREEN =     "dragons/g3.png",
            DRAGON_MIDDLE_GREEN =   "dragons/g2.png",
            DRAGON_WIDE_GREEN =     "dragons/g1.png",

            DRAGON_SLIM_YELLOW =    "dragons/y3.png",
            DRAGON_MIDDLE_YELLOW =  "dragons/y2.png",
            DRAGON_WIDE_YELLOW =    "dragons/y1.png",


            /****************** BLOCKS ********************/


            //INDESTRUCTIBLE_BLOCK = "",
            DESTRUCTIBLE_BLOCK = "blocks/Rock.png",



            /****************** POWER-UPS *******************/

            RANGE_POWERUP =     "powerUps/bomb_range_powerup_red.png",
            BOMB_CAP_POWERUP =  "powerUps/bomb_cap_powerup_red.png",
            SPEED_POWERUP =     "powerUps/dragon_wings.png",


            /***************** BOMB AND FIRE *****************/

            BOMB1 = "bombs/bomb1.png",
            BOMB2 = "bombs/bomb2.png",
            BOMB3 = "bombs/bomb3.png",
            BOMB4 = "bombs/bomb4.png",

            TESTBOMB = "bombs/FireEgg.png",

            EXPLOSION1= "bombs/fires/explosion1.png",
            EXPLOSION2= "bombs/fires/explosion2.png",
            EXPLOSION3= "bombs/fires/explosion3.png",
            EXPLOSION4= "bombs/fires/explosion4.png",
            EXPLOSION5= "bombs/fires/explosion5.png",





            /***************** MENU SCREEN ************************/

            BACKGROUND =    "components/grey_background.jpeg",
            STARTGAME_BTN = "components/start_game.jpeg",
            JOINGAME_BTN =  "components/join_game.jpeg",
            LOGO =          "components/logo.png",

            /***************** GAME OVER SCREEN ************************/

            GAME_OVER = "components/over.png",

            /***************** PLAYER CONTROLLER BUTTONS ************************/

            EXIT_BTN = "components/buttons/exitBtn_small.png",
            BOMB_BTN = "components/buttons/bombBtn_small.png",

            /*********** HEALTH *************/
            FULL_HEALTH = "components/fullhealth.png",
            EMPTY_HEALTH = "components/emptyhealth.png";



    // LAST ELEMENT MUST HAVE ';'!!

    private AssetLoader(){}


}
