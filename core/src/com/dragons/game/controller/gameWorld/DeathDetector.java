package com.dragons.game.controller.gameWorld;

import com.dragons.game.model.players.IPlayer;

import java.util.ArrayList;
import java.util.List;

public class DeathDetector {
    private final List<IPlayer> players;

    public DeathDetector (){
        players = new ArrayList<>();
    }

    public void addPlayer(GameObject gameObject){
        players.add((IPlayer) gameObject.getModel());

    }
    public boolean isDead(){
        for(int i=0; i < players.size(); i++){
            if(players.get(i) != null && players.get(i).getLives() == 0){
                return true;
            }
        }
        return false;

    }
}
