package com.dragons.game.view.modelViews;

import com.dragons.game.model.ISubject;

public interface IModelObserver {
    void update(ISubject subject);
}
