package com.dragons.game;

import android.util.Log;
import androidx.annotation.NonNull;
import com.dragons.game.model.players.NormalPlayer;
import com.dragons.game.networking.FireBaseInterface;
import com.dragons.game.networking.FirebasePlayer;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class AndroidFirebaseInterface implements FireBaseInterface {
    FirebaseDatabase database;
    DatabaseReference playerRef;
    DatabaseReference scoreRef;

    public AndroidFirebaseInterface() {
        database = FirebaseDatabase.getInstance("https://imaginary-dragons-default-rtdb.europe-west1.firebasedatabase.app/"); //rotnoden, hele databasen
        playerRef = database.getReference("Score"); //får tak i referansen Players, peker på alle players
    }

    @Override
    public void writeHighscoreToFB(FirebasePlayer firebasePlayer) {
        scoreRef = playerRef.push();
        scoreRef.setValue(firebasePlayer);
    }

    @Override
    public void SetOnValueChangedListener(FirebasePlayer firebasePlayer) {
        FirebasePlayer finalFirebasePlayer = firebasePlayer;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Query query = playerRef.orderByChild("score");
        ValueEventListener valueEventListener = new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {
              if (snapshot.exists()) {
                  for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                      String nameFromDB = childSnapshot.child("name").getValue(String.class);
                      int scoreFromDB = childSnapshot.child("score").getValue(Integer.class);
                      Map<String, Integer> scoresDB = new LinkedHashMap<>();
                      scoresDB.put(nameFromDB, scoreFromDB);
                      finalFirebasePlayer.scores.put(childSnapshot.getKey(), scoresDB);
                  }
              }
          }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        query.addListenerForSingleValueEvent(valueEventListener);
    }
}
