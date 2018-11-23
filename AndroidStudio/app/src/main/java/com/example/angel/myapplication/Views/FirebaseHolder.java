package com.example.angel.myapplication.Views;

import com.example.angel.myapplication.Net.FireBaseInstances;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHolder {


    public FirebaseDatabase getDatabase() {
        return database;
    }

    public void setDatabase(FirebaseDatabase database) {
        this.database = database;
    }

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    public DatabaseReference getMyRef() {
        return myRef;
    }

    public void setMyRef(DatabaseReference myRef) {
        this.myRef = myRef;
    }

    DatabaseReference myRef = database.getReference(FireBaseInstances.ReferenceAlumno);




}
