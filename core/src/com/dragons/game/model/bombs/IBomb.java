package com.dragons.game.model.bombs;

public interface IBomb {

    boolean isExploded();
    void hitByFire();
    BombType getType();
    float getDetonationTime();
    float getFireDisplayTime();
    void increaseRange(int amount);
    int getBombRange();

}
