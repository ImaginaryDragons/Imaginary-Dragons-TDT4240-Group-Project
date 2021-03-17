package com.dragons.game.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;

public class CharacterView {
    private Texture character;
    private Animation characterAnimation;

    public CharacterView (){
        character = new Texture(""); // legg til texture
        characterAnimation = new Animation(2.5f); // legg til animations
     }
}
