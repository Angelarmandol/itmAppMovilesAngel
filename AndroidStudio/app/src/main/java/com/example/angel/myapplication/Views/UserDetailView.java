package com.example.angel.myapplication.Views;
// move to view
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.angel.myapplication.R;

import butterknife.ButterKnife;

public class UserDetailView extends AppCompatActivity {




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        ButterKnife.bind(this);

    }
}
