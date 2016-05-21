package com.masseyhacks.sjam.cheqout;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;

public class Home extends AppCompatActivity {

    private FirebaseDatabase firebase;
    private DatabaseReference ref;

    public ArrayList getDataFromFirebase(String s) {
        ref.child("Stores").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList values = (ArrayList) dataSnapshot.getValue();
                Context c = getApplicationContext();
                int d = Toast.LENGTH_SHORT;
                Toast t = Toast.makeText(c, (String) values.get(0), d);
                t.show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public ArrayList getDataFromFirebase(String s1, String s2) {
        ref.child(s1).child(s2).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList values = (ArrayList) dataSnapshot.getValue();
                Context c = getApplicationContext();
                int d = Toast.LENGTH_SHORT;
                Toast t = Toast.makeText(c, (String) values.get(0), d);
                t.show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebase = FirebaseDatabase.getInstance();
        ref = firebase.getReference();

        setContentView(R.layout.activity_home);
    }
}
