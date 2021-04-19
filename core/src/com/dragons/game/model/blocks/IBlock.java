package com.dragons.game.model.blocks;

import com.dragons.game.model.IModel;

public interface IBlock extends IModel {
    void handleHitByBomb();
}
