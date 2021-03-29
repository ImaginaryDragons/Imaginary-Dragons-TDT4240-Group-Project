package com.dragons.game.model;

import com.dragons.game.view.modelViews.IModelObserver;

public interface ISubject {
    void addObserver(IModelObserver observer);
    void removeObserver(IModelObserver observer);
    void notifyObservers();
}