package com.example.angel.myapplication.Models;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.angel.myapplication.MainActivityDesarrolloAcademico;
import com.example.angel.myapplication.Net.FireBaseInstances;
import com.example.angel.myapplication.Net.Holder;
import com.example.angel.myapplication.Net.LocalTEST;
import com.example.angel.myapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Search {

    public ArrayAdapter<String> getAdaptador() {
        return adaptador;
    }

    public void setAdaptador(ArrayAdapter<String> adaptador) {
        this.adaptador = adaptador;
    }
    Holder holder = new Holder();
    ArrayAdapter<String> adaptador;
    @BindView(R.id.lv_materias) ListView localListview;
    ArrayList localArrayList = new ArrayList();

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference(FireBaseInstances.References);
    final ArrayList<String> list_Materias = new ArrayList<>();


    public ListView getSearchListView(Context context, View view) {

        ButterKnife.bind(this, view);
        adaptador = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
        localListview.setAdapter(adaptador);

        myRef.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("normal", "val: "+dataSnapshot.getValue());
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String users = snapshot.getValue(String.class);
                    list_Materias.add(users);
                    localArrayList.add(dataSnapshot.getChildren());
                    adaptador.add(users);


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





        ArrayList<String> nombresss = new ArrayList<>();
       // nombresss=test.obtenerMaterias();

        Holder holder = new Holder();
        Log.i("obtenerMAterias:"," "+holder.getHolder());
        nombresss=holder.getHolderArray();



        return localListview;
    }

    public void setLocalListView(ListView searchListView) {
        this.localListview = searchListView;
    }






}
