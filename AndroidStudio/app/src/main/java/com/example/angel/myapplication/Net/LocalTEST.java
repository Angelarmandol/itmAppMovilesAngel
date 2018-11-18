package com.example.angel.myapplication.Net;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.angel.myapplication.Adaptadores.MateriaAdapter;
import com.example.angel.myapplication.Models.Materia;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class LocalTEST {
    String lol;

    ArrayList localArrayList = new ArrayList();

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference(FireBaseInstances.References);

    ChatInteractor(ChatPresenter presenter) {
        this.presenter = presenter;
        retrieveCurrentChat();
    }


    public void obtenerMaterias(){


        final ArrayList<String> list_Materias = new ArrayList<>();


        myRef.addValueEventListener(new ValueEventListener() {

            Holder holder = new Holder();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("normal", "val: "+dataSnapshot.getValue());
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String users = snapshot.getValue(String.class);
                    list_Materias.add(users);
                    localArrayList.add(dataSnapshot.getChildren());



                }

                Log.i("nombres red:"," "+list_Materias.toString());

                holder.setHolder(list_Materias.toString());
                holder.setHolderArray(list_Materias);
                Log.i("holder vale: ",""+holder.getHolder());
                Log.i("holder array vale: ",""+holder.getHolderArray());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("Error", databaseError.getMessage());
            }
        });





    }


}
