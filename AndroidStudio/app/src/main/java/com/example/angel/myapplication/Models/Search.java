package com.example.angel.myapplication.Models;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.angel.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Search {

    ArrayAdapter<String> adaptador;
    @BindView(R.id.lv_materias) ListView localListview;

    public ListView getSearchListView(Context context, View view) {
        ButterKnife.bind(this, view);
        adaptador = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
        localListview.setAdapter(adaptador);
        adaptador.add("hola");
        adaptador.add("mundo");
        adaptador.add("delagado");
        return localListview;
    }

    public void setLocalListView(ListView searchListView) {
        this.localListview = searchListView;
    }






}
