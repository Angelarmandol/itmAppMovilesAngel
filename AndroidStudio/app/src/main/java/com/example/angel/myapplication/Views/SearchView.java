package com.example.angel.myapplication.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.angel.myapplication.Models.Materia;
import com.example.angel.myapplication.Models.Search;
import com.example.angel.myapplication.Net.LocalTEST;
import com.example.angel.myapplication.R;

import java.util.ArrayList;

public class SearchView extends AppCompatActivity {

      LocalTEST test;

    ListView localListview= new Search().getSearchListView();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        localListview = (ListView) findViewById(R.id.rv_materias);




                MateriaAdapter adapter = new RecipeAdapter(this, recipeList);
        localListview.setAdapter(adapter);

    }
}
