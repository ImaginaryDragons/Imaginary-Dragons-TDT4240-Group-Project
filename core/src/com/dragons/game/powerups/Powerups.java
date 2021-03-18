package com.dragons.game.powerups;

import java.util.ArrayList;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;


public abstract class Powerups implements PowerupsInterface, MetaEventListener {
        int speed = 10;  //startfart
        int bombs = 1; //antall bomber i starten
        int bombRange = 1; //Hvor langt ilden går

        @Override
        public void initialize() {

        }

        @Override
        public void increaseSpeed() {
            speed += 2;
        }

        @Override
        public void setSpeed(int speed) {
            this.speed = speed;
        }

        @Override
        public int getSpeed() {
            return speed;
        }

        public void increaseBombRange() {
            bombRange += 2;
        }
        public void setBombRange(int bombRange) {
            this.bombRange = bombRange;
        }

        public int getBombRange() {
            return bombRange;
    }

        public void increaseBombs() {
            bombRange += 1;
    }
        public void setBombs(int bombs) {
            this.bombs = bombs;
    }

        public int getBombs() {
            return bombs;
    }

}
