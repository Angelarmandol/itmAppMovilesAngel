package com.example.angel.myapplication.Views;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.angel.myapplication.Net.UserNet;
import com.example.angel.myapplication.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.util.Strings;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FacebookLoginView extends AppCompatActivity {


    private CallbackManager callbackManager;
    private LoginButton loginButton;

    UserNet user = new UserNet();
    public String getIdFacebook() {
        return idFacebook;
    }

    public void setIdFacebook(String idFacebook) {
        this.idFacebook = idFacebook;
    }

    public String idFacebook;
    @BindView(R.id.img_disp) ImageView greenLigth;
    @BindView(R.id.sw_aviable) Switch sw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_avt);
        ButterKnife.bind(this);

        sw.setChecked(false);
        final TextView info = findViewById(R.id.fbid);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        AccessToken tok;
                        tok = AccessToken.getCurrentAccessToken();
                        info.setText("Login exitoso");
                        Toast toast4 =
                                Toast.makeText(getApplicationContext(), "Login exitoso", Toast.LENGTH_SHORT);
                        toast4.show();
                        sw.setVisibility(View.VISIBLE);
                        setIdFacebook(tok.getUserId());
                        setDisponible();

                    }
                    @Override
                    public void onCancel() {
                        // App code
                        Toast toast4 =
                                Toast.makeText(getApplicationContext(), "Login Cancelado", Toast.LENGTH_SHORT);
                        toast4.show();
                    }
                    @Override
                    public void onError(FacebookException exception) {
                        Toast toast4 =
                                Toast.makeText(getApplicationContext(), "Error de Login", Toast.LENGTH_SHORT);
                        toast4.show();
                    }

                });
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
        if(isLoggedIn){
            sw.setChecked(false);
            sw.setVisibility(View.VISIBLE);
        }else{
            sw.setVisibility(View.INVISIBLE);
            greenLigth.setVisibility(View.INVISIBLE);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick(R.id.sw_aviable)
    public void setDisponible(){
        if (sw.isChecked()) {
            greenLigth.setVisibility(View.VISIBLE);
            user.setAviable();
        }else{
            greenLigth.setVisibility(View.INVISIBLE);
            user.setUnaviable();
        }

    }
}
