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
import com.google.android.gms.common.data.DataHolder;
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

    DatabaseReference playerRef;


    public AndroidFirebaseInterface() {
        database = FirebaseDatabase.getInstance("https://imaginary-dragons-default-rtdb.europe-west1.firebasedatabase.app/"); //rotnoden, hele databasen
        playerRef = database.getReference("Score"); //får tak i referansen Players, peker på alle players
    }

    @Override
    public void writeHighscoreToFB(String name, double score) {
        FirebasePlayer firebasePlayer = new FirebasePlayer(name, score); //Lage en unik Id der vi kaller funksjonen
        playerRef.setValue(firebasePlayer);

    }


    @Override
    public void SetOnValueChangedListener(FirebasePlayer firebasePlayer) {
        //scoreRef = playerRef.child("id");
        Query query = playerRef.orderByChild("score");
        ValueEventListener valueEventListener = new ValueEventListener() {
            private final Log LOG = null;

            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                // Adds the values to the database
                Log.d(TAG, "User: " + snapshot.getKey() + ". Score: " + snapshot.getValue(Integer.class));
                firebasePlayer.setScores(snapshot.getKey(), snapshot.getValue(Integer.class));
            }


            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                        FirebasePlayer scoreFromDB = childSnapshot.child("id").getValue(FirebasePlayer.class);
                        String nameFromDB = childSnapshot.child("name").getValue(String.class);
                        double score1FromDB = childSnapshot.child("score").getValue(Double.class);
                        LOG.d("TAG", nameFromDB);
                        LOG.d("TAG", String.valueOf(score1FromDB));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Funker ikke");
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
