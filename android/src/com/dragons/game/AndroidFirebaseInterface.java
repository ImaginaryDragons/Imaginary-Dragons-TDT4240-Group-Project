package com.dragons.game;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AndroidFirebaseInterface implements FireBaseInterface {
    FirebaseDatabase database;
    DatabaseReference myRef;

    public AndroidFirebaseInterface() {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

    }

    @Override
    public void SomeFunction() {

    }

    @Override
    public void FirstFireBaseTest() {

    }
}
