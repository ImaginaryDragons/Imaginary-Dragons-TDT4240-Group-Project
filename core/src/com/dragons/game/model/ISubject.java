package com.dragons.game.model;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.view.modelViews.IModelObserver;

import java.awt.Shape;

/**
 * The ISubject interface is used to implement our top-level observer type that will be common
 * for all game-classes that may implement the observer pattern.
 *
 * @author Jakob Eikeland
 * */

public interface ISubject {

    void setPosition(Vector2 pos);
    Vector2 getPosition();
    void setShape(Shape2D shape);
    Shape2D getShape();

    void addObserver(IModelObserver observer);
    void removeObserver(IModelObserver observer);
    void notifyObservers();
}
