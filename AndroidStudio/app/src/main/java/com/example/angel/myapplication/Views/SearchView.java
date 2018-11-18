package com.example.angel.myapplication.Views;

import android.app.Service;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.angel.myapplication.Adaptadores.MateriaAdapter;
import com.example.angel.myapplication.MainActivityDesarrolloAcademico;
import com.example.angel.myapplication.Models.Materia;
import com.example.angel.myapplication.Models.Search;
import com.example.angel.myapplication.Net.LocalTEST;
import com.example.angel.myapplication.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchView extends AppCompatActivity {

      LocalTEST test;
      ArrayAdapter<String> adaptador;
      Search test2 = new Search();

    @BindView(R.id.lv_materias) ListView localListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        localListview = new Search().getSearchListView(this, findViewById(android.R.id.content ));

    }
}
