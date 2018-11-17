package com.example.angel.myapplication.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.angel.myapplication.Models.Materia;
import com.example.angel.myapplication.Models.Search;
import com.example.angel.myapplication.Net.LocalTEST;
import com.example.angel.myapplication.R;

import java.util.ArrayList;

public class SearchView extends AppCompatActivity {


    ListView localListview= new Search().getSearchListView();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        localListview = (ListView) findViewById(R.id.rv_materias);

        final ArrayList<Materia> materiaList = LocalTEST.getMaterias();



    }
}
