package com.example.angel.myapplication.Views;
// move to view
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.angel.myapplication.Net.LocalTEST;
import com.example.angel.myapplication.Net.Search;
import com.example.angel.myapplication.Net.UserNet;
import com.example.angel.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailView extends AppCompatActivity {




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        ButterKnife.bind(this);

    }
}
