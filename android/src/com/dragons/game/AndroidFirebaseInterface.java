package com.dragons.game;


import android.util.Log;

import androidx.annotation.NonNull;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.players.NormalPlayer;
import com.dragons.game.model.players.PlayerColor;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class AndroidFirebaseInterface implements FireBaseInterface {
    FirebaseDatabase database;
    DatabaseReference playerRef;
    DatabaseReference gameRef;
    private NormalPlayer player;
    DatabaseReference playerName;
    DatabaseReference check;

    String name;
    Vector2 position;
    int speed;
    float bombRange;
    int health;
    Color color;
    int userId;


    public AndroidFirebaseInterface() {
        database = FirebaseDatabase.getInstance("https://imaginary-dragons-default-rtdb.europe-west1.firebasedatabase.app/"); //rotnoden, hele databasen
        gameRef = database.getReference("GameScreen");
        playerRef = database.getReference("Players"); //får tak i referansen Players, peker på alle players

    }

    @Override
    public void SomeFunction() {
        check = database.getReference("message3");
        check.setValue("Screen blir ikke kjørt2");
    }


    @Override
    public void writePlayerToFB(int ID, Vector2 position, Color color, int width, int height) {


        NormalPlayer firebasePlayer = new NormalPlayer(ID, position, color, width, height); //Lage en unik Id der vi kaller funksjonen
        playerRef.child(String.valueOf(ID)).setValue(firebasePlayer);

    }


    @Override
    public void SetOnValueChangedListener() {
        playerRef.addValueEventListener((new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            /*
            ArrayList<Player> playerFromDB = (ArrayList<Player>) snapshot.getValue(); //Henter player objektet fra firebase for å bruke i UI

                //følge med på når player oppdateres
                //når gamemap oppdateres

                if (snapshot.exists()) {

                       NormalPlayer playerFromDB = snapshot.getValue(NormalPlayer.class); //Henter player objektet fra firebase for å bruke i UI
*/
                /*Funker ikke
            Player player1 = playerFromDB.get(1);
            Player player2 = playerFromDB.get(2);
            Player player3 = playerFromDB.get(3);
            Player player4 = playerFromDB.get(4);
*/
            //System.out.println(playerFromDB);

                        /*
                        String nameFromDB = snapshot.child(userId).child("name").getValue(String.class);
                        float posXFromDB = snapshot.child(userId).child("positionX").getValue(float.class);
                        float posYFromDB = snapshot.child(userId).child("positionY").getValue(float.class);
                        int speedFromDB = snapshot.child(userId).child("speed").getValue(int.class);
                        float bombRangeFromDB = snapshot.child(userId).child("bombRange").getValue(float.class);
                        int healthFromDB = snapshot.child(userId).child("health").getValue(int.class);
                        PlayerColor colorFromDB = snapshot.child(userId).child("color").getValue(PlayerColor.class);

                        */

                        }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        }));
    }

    /*
    @Override
    private void addPlayerEventListener(DatabaseReference mPlayerReference) {
        ValueEventListener playerListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", error.toException());
            }
        };
        mPlayerReference.addValueEventListener(playerListener);
    }
*/

}
