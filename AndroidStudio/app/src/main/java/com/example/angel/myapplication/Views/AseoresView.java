package com.example.angel.myapplication.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.angel.myapplication.Net.UserNet;
import com.example.angel.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AseoresView extends AppCompatActivity {

    @BindView(R.id.subirAsesor) Button subir;
    @BindView(R.id.lv_asesores)
    ListView localListview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aseores_view);
        ButterKnife.bind(this);


        Log.i("o0o0o0o0o","start");
        localListview = new UserNet().getSearchListView(this, findViewById(android.R.id.content));

    }

    @OnClick(R.id.subirAsesor)
    public void submit(View view) {

        Log.i("Subiendo..","");

        UserNet net = new UserNet();
        net.subir();
    }
}