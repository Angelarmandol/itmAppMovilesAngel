package com.example.angel.myapplication.Net;

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


    public DatabaseReference getAsesor() {
        return asesor;
    }

    public void setAsesor(DatabaseReference asesor) {
        this.asesor = asesor;
    }

    public DatabaseReference getMateria() {
        return materia;
    }

    public void setMateria(DatabaseReference materia) {
        this.materia = materia;
    }

    DatabaseReference asesor = database.getReference("alumno");


    DatabaseReference materia = database.getReference("materia");

    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("alumno");



}
