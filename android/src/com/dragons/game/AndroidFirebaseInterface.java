package com.dragons.game;


import android.provider.ContactsContract;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.badlogic.gdx.backends.android.DefaultAndroidAudio;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.dragons.game.model.players.NormalPlayer;
import com.dragons.game.model.players.PlayerColor;
import com.dragons.game.view.screens.GameOverScreen;
import com.google.android.gms.common.data.DataHolder;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class AndroidFirebaseInterface implements FireBaseInterface {
    FirebaseDatabase database;
    DatabaseReference scoreRef;
    private NormalPlayer player;
    DatabaseReference playerName;
    FirebasePlayer firebasePlayer;
    DatabaseReference playerRef;


    public AndroidFirebaseInterface() {
        database = FirebaseDatabase.getInstance("https://imaginary-dragons-default-rtdb.europe-west1.firebasedatabase.app/"); //rotnoden, hele databasen
        playerRef = database.getReference("Score"); //får tak i referansen Players, peker på alle players
        //firebasePlayer = new FirebasePlayer();

    }

    @Override
    public void writeHighscoreToFB(FirebasePlayer firebasePlayer) {
        String name = firebasePlayer.getName();
       // FirebasePlayer firebasePlayer = new FirebasePlayer(); //Lage en unik Id der vi kaller funksjonen
        playerRef.child(name).setValue(firebasePlayer);

    }
    /*
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                // Adds the values to the database
                //double timeScore = snapshot.child("score").getValue(Double.class);
                Log.d(TAG, "User: " + snapshot.getKey() + ". Score: ");

                //firebasePlayer.setScores(snapshot.getKey(), timeScore);
            }
            */

    @Override
    public void SetOnValueChangedListener(FirebasePlayer firebasePlayer) {
        //firebasePlayer = new FirebasePlayer();
        //scoreRef = playerRef.child("id");
        Query query = playerRef.orderByChild("score");
        FirebasePlayer finalFirebasePlayer = firebasePlayer;
        ValueEventListener valueEventListener = new ValueEventListener() {
        private final Log LOG = null;
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {
              if (snapshot.exists()) {
                  for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                      String nameFromDB = childSnapshot.child("name").getValue(String.class);
                      //LOG.d("TAG", nameFromDB);
                      int scoreFromDB = childSnapshot.child("score").getValue(Integer.class);
                      //LOG.d("TAG", String.valueOf(scoreFromDB));
                      //finalFirebasePlayer.setName(nameFromDB);
                      //finalFirebasePlayer.setScore(scoreFromDB);
                      finalFirebasePlayer.scores.put(nameFromDB, scoreFromDB);
                      //LOG.d("TAG", finalFirebasePlayer.getName());
                  }

              }
          }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        query.addListenerForSingleValueEvent(valueEventListener);
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
