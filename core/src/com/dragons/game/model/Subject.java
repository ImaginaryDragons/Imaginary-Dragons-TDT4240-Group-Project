package com.dragons.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.dragons.game.view.modelViews.IModelObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * The Subject abstract class primarily contains the observer-related methods that we
 * will use on all our subjects throughout the program. A subject is primarily an object
 * or instance of something that is in our game world.
 *
 * @author Jakob Eikeland
 * */

public abstract class Subject implements ISubject{

    private List<IModelObserver> observers = new ArrayList<IModelObserver>();

    public Subject() {}

    // TODO: Consider whether the get/set methods for shape and position should be written in here

    @Override
    public void addObserver(IModelObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IModelObserver observer) {
        int observerIndex = observers.indexOf(observer);
        // if observer is in observers
        if (observerIndex >= 0) observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IModelObserver observer : observers){
            observer.update(this);
        }
    }
}

