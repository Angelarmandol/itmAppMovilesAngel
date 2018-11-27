package com.example.angel.myapplication.Views;
// move to view
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.angel.myapplication.Net.UserNet;
import com.example.angel.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class UserDetailView extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        ImageView iv_asesor = (ImageView) this.findViewById(R.id.iv_asesor);
        TextView tv_UserName = (TextView) this.findViewById(R.id.tv_UserName);
        TextView tv_phone = (TextView) this.findViewById(R.id.tv_phone);
        TextView tv_email = (TextView) this.findViewById(R.id.tv_email);
        TextView tv_resources = (TextView) this.findViewById(R.id.tv_resources);
        ImageView aviavble = (ImageView) this.findViewById(R.id.led_disp);
        System.out.println(extras.get("email").toString());



        tv_phone.setText(extras.get("phone").toString());
        System.out.println("nombre phone:"+extras.get("phone").toString());
        tv_email.setText(extras.get("email").toString());
        System.out.println("nombre email:"+extras.get("email").toString());
        tv_resources.setText(extras.get("resources").toString());
        System.out.println("nombre resources: "+extras.get("resources").toString());
        tv_UserName.setText(extras.get("name").toString());
        System.out.println("nombre extra:"+extras.get("name").toString());
        Picasso.get().load(extras.get("photo").toString()).into(iv_asesor);
        aviavble.setVisibility(View.INVISIBLE);
        if(extras.get("aviable").equals("true")){
            System.out.println("#############View is true");
            aviavble.setVisibility(View.VISIBLE);
        }

        int score=Integer.parseInt(extras.get("score").toString());
        ImageView s1 = (ImageView) this.findViewById(R.id.s1);
        ImageView s2 = (ImageView) this.findViewById(R.id.s2);
        ImageView s3 = (ImageView) this.findViewById(R.id.s3);
        ImageView s4= (ImageView) this.findViewById(R.id.s4);
        ImageView s5 = (ImageView) this.findViewById(R.id.s5);


        if(score>=1){
            s1.setVisibility(View.VISIBLE);
        }
        if(score>=2){
            s2.setVisibility(View.VISIBLE);
        }
        if(score>=3){
            s3.setVisibility(View.VISIBLE);
        }
        if(score>=4){
            s4.setVisibility(View.VISIBLE);
        }
        if(score>=5){
            s5.setVisibility(View.VISIBLE);
        }

    }


}
