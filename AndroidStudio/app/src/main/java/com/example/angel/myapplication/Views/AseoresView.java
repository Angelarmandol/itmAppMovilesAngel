package com.example.angel.myapplication.Views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.angel.myapplication.Models.UserDetail;
import com.example.angel.myapplication.Net.UserNet;
import com.example.angel.myapplication.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AseoresView extends AppCompatActivity {
    UserNet jk = new UserNet();

    @BindView(R.id.lv_asesores)
    ListView localListview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aseores_view);
        ButterKnife.bind(this);


        Log.i("o0o0o0o0o","start");
        localListview =  jk.getSearchListView(this, findViewById(android.R.id.content));


        ///handler
        final Context context = this;
        localListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                Log.i("se preciono", "uno");
                System.out.println("numero lista 000000"+localListview.getSelectedItemPosition());
                System.out.println("size es -----:"+jk.getDetailUsers().size());
                Intent detailIntent = new Intent(context, UserDetailView.class);
                startActivity(detailIntent);
            }
        });



    }


}
