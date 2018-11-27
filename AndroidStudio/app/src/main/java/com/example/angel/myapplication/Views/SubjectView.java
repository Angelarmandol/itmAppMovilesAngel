package com.example.angel.myapplication.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.angel.myapplication.Net.SubjectPresenter;
import com.example.angel.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubjectView extends AppCompatActivity {



    @BindView(R.id.lv_materias) ListView localListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);


        localListview = new SubjectPresenter().getSearchListView(this, findViewById(android.R.id.content));

    }
}
