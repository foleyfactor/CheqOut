package com.masseyhacks.sjam.cheqout;

import android.app.Activity;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Home extends Activity {

    private FirebaseDatabase firebase;
    private DatabaseReference ref;
    private ArrayList stores;

    public void getDataFromFirebase(String s) {
        boolean error = false;
        ref.child(s).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList values = (ArrayList) dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void getDataFromFirebase(String s1, String s2) {
        boolean error = false;
        ref.child(s1).child(s2).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public ArrayList returnArrayList(ArrayList a) {
        return a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebase = FirebaseDatabase.getInstance();
        ref = firebase.getReference();

        setContentView(R.layout.activity_home);
    }
}
