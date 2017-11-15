package com.example.conan.firebasetester;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button get, put;

    FirebaseDatabase database;
    DatabaseReference myRef;
    ArrayList<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        get = (Button) findViewById(R.id.get);
        put = (Button) findViewById(R.id.put);

        personList = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("TestDaten/Personen/");

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        put.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personList.add(new Person("Conan", "Lightingflash"));
                personList.add(new Person("Matteo", "Powerpunch"));
                personList.add(new Person("Mike", "Magicmaster"));

                myRef.setValue(personList);
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

/*                Toast.makeText(getApplication(), "Key: " + dataSnapshot.getKey(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplication(),"Value: " + dataSnapshot.getValue(Person.class),Toast.LENGTH_SHORT).show();*/

    /*            for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    // TODO: handle the post
                    Toast
                }*/
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Toast.makeText(getApplication(), "Key: " + dataSnapshot.getKey(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplication(),"Value: " + dataSnapshot.getValue(),Toast.LENGTH_SHORT).show();

                Person person = dataSnapshot.getValue(Person.class);

                myRef.child("RandomPush").push().setValue(person);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
