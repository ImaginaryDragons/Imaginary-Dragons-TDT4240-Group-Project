package com.dragons.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.dragons.game.view.modelViews.IModelObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject implements ISubject{

    private List<IModelObserver> observers = new ArrayList<>();

    public Subject(IModelObserver observer) {
        addObserver(observer);
    }


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

