package com.dragons.game.view.modelViews;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.dragons.game.view.IView;

public interface IModelView extends IView {

    void setAnimation(Animation<Texture> animation);

}
