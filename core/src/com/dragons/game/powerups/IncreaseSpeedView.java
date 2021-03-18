package com.dragons.game.powerups;

import java.awt.event.ActionListener;

public abstract class IncreaseSpeedView implements ActionListener, powerupsObserver {
    PowerupsInterface increaseSpeed;
    ControllerInterface controller;
    //components for the display here


    public IncreaseSpeedView(ControllerInterface controller, PowerupsInterface increaseSpeed) {
        this.controller = controller;
        this.increaseSpeed = increaseSpeed;
        increaseSpeed.registerObserver((powerupsObserver)this);

    }

    public void createView() {

    }

    public void updateSpeed() {
        int speed = increaseSpeed.getSpeed();
    }



}
