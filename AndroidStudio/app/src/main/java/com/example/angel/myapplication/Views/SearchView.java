package com.example.angel.myapplication.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.angel.myapplication.Net.MateriaPresenter;
import com.example.angel.myapplication.Net.LocalTEST;
import com.example.angel.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchView extends AppCompatActivity {

      LocalTEST test;
      ArrayAdapter<String> adaptador;
      MateriaPresenter test2 = new MateriaPresenter();

    @BindView(R.id.lv_materias) ListView localListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);


        localListview = new MateriaPresenter().getSearchListView(this, findViewById(android.R.id.content));

    }
}
