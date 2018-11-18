package com.example.angel.myapplication.Models;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.angel.myapplication.MainActivityDesarrolloAcademico;
import com.example.angel.myapplication.Net.Holder;
import com.example.angel.myapplication.Net.LocalTEST;
import com.example.angel.myapplication.R;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Search {

    ArrayAdapter<String> adaptador;
    @BindView(R.id.lv_materias) ListView localListview;

    public ListView getSearchListView(Context context, View view) {



        ButterKnife.bind(this, view);
        adaptador = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
        localListview.setAdapter(adaptador);

        ArrayList<String> nombresss = new ArrayList<>();
       // nombresss=test.obtenerMaterias();

        Holder holder = new Holder();
        Log.i("obtenerMAterias:"," "+holder.getHolder());
        nombresss=holder.getHolderArray();



        Log.i("getholderarrat---0000:"," "+holder.getHolderArray());

        adaptador.add("hola");
        adaptador.add("mundo");
        adaptador.add("delagado");


        return localListview;
    }

    public void setLocalListView(ListView searchListView) {
        this.localListview = searchListView;
    }






}
