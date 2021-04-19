package com.dragons.game.model;

import com.dragons.game.view.Observer;

public interface Observable {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
