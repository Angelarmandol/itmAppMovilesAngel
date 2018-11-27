package com.example.angel.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.angel.myapplication.Models.Materia;
import com.example.angel.myapplication.Models.MateriaInteractor;
import com.example.angel.myapplication.Models.MateriaPresenter;
import com.example.angel.myapplication.Net.FireBaseInstances;
import com.example.angel.myapplication.Net.LocalTEST;
import com.example.angel.myapplication.Net.UserNet;
import com.example.angel.myapplication.Views.AseoresView;
import com.example.angel.myapplication.Views.FacebookLoginView;
import com.example.angel.myapplication.Views.SearchView;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivityDesarrolloAcademico extends AppCompatActivity


/// move to model

        implements NavigationView.OnNavigationItemSelectedListener {
    private WebView mWebview;
    private TextView info;
    private CallbackManager callbackManager;
    private LoginButton loginButton;

    LocalTEST test = new LocalTEST();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_desarrollo_academico);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        MateriaPresenter ps = new MateriaPresenter();
        ps.obtenerMaterias();

        UserNet un = new UserNet();


    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_desarrollo_academico, menu);
        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent facebookLoginActivityIntent = new Intent(getApplicationContext(), FacebookLoginView.class);
            startActivity(facebookLoginActivityIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Toast toast2 =
                Toast.makeText(getApplicationContext(), "Selected: "+item.getItemId(), Toast.LENGTH_SHORT);
        toast2.show();
        if (id == R.id.item_search) {
            Toast toast4 =
                    Toast.makeText(getApplicationContext(), "Activity MateriaPresenter", Toast.LENGTH_SHORT);
            toast4.show();
            Intent searchActivityIntent = new Intent(getApplicationContext(), SearchView.class);
            startActivity(searchActivityIntent);
        }

        if (id == R.id.item_asesores) {

            Toast toast4 =
                    Toast.makeText(getApplicationContext(), "Activity AsesoresPresenter", Toast.LENGTH_SHORT);
            toast4.show();
            Intent searchActivityIntent = new Intent(getApplicationContext(), AseoresView.class);
            startActivity(searchActivityIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState ){
        super.onPostCreate(savedInstanceState);
    }
}
