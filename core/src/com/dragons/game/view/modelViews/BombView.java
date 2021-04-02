package com.dragons.game.view.modelViews;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.dragons.game.model.bomb.Bomb;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

public class BombView {
    private Bomb bomb;
    private Texture fireball;
    private Texture explosion;
    private Animation character;
    private AnnotationAssetManager manager;

    public BombView (Bomb bomb, AnnotationAssetManager manager){
        this.bomb = bomb;
        this.manager = manager;
        this.fireball = manager.get("FIREBALL");
        this.explosion = manager.get("EXPLOSION");
        //this.character = new Animation(frame, list med textures)

    }

}
