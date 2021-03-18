package com.dragons.game.model.powerups;

import javax.sound.midi.MetaEventListener;


public abstract class Powerups implements PowerupsInterface, MetaEventListener {
        
        // TODO: Splitt disse inn i tre ulike power-ups!
        
        int speed = 10;  //startfart
        int bombs = 1; //antall bomber i starten
        int bombRange = 1; //Hvor langt ilden går

        @Override
        public void initialize() {

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

        public int getBombs() {
            return bombs;
        }

}
