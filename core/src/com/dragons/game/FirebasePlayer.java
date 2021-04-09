package com.dragons.game;

import com.dragons.game.model.player.PlayerColor;

import com.dragons.game.model.player.Player;

public class FirebasePlayer {

        public String name;
        public float positionX;
        public float positionY;
        public int speed;
        public float bombRange;
        public int health;
        public PlayerColor color;
        Player player;


        public FirebasePlayer() {
        }

        public FirebasePlayer(String name, float positionX, float positionY, int speed, float bombRange, int health, PlayerColor color) {
            this.name = name;
            this.positionX = player.getPosition().x;
            this.positionY = player.getPosition().y;
            this.speed = player.getSpeed();
            this.bombRange = player.getBombRange();
            this.health = player.getHealth();
            this.color = player.getCol();
        }

/*
        public PlayerColor getColor() {
            return color;
        }

        public void setColor(PlayerColor color) {
            this.color = color;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getPositionX() {
            return positionX;
        }

        public void setPositionX(float positionX) {
            this.positionX = positionX;
        }

        public float getPositionY() {
            return positionY;
        }

        public void setPositionY(float positionY) {
            this.positionY = positionY;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public float getBombRange() {
            return bombRange;
        }

        public void setBombRange(float bombRange) {
            this.bombRange = bombRange;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }
    }
    */

}
