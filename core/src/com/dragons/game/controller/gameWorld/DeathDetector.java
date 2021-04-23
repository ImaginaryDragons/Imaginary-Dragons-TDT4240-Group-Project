package com.dragons.game.controller.gameWorld;

import com.dragons.game.controller.gameWorld.GameObject;
import com.dragons.game.model.players.Player;

import java.util.ArrayList;
import java.util.List;

public class DeathDetector {


    private GameObject gameObject;
    private boolean isDead;
    private List<Player> players;

    public DeathDetector (){
        isDead = false;
        players = new ArrayList<>();
    }

    public void addPlayer(GameObject gameObject){
        this.gameObject = gameObject;
        players.add((Player) gameObject.getModel());

    }

    public boolean isDead(){
        for(int i=0; i < players.size(); i++){
            if(players.get(i) != null && players.get(i).getLives() == 0){
                isDead = true;
            }
        }

        return isDead;
    }
}
