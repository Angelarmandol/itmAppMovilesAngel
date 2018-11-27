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

import java.util.ArrayList;
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

        final Context context = this;

        localListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent detailIntent = new Intent(context, UserDetailView.class);



                ArrayList<String> extras = jk.getDetailUsers().get(0);
                System.out.println(extras.size());
                //iteracion de 7


                Long pos= jk.getDetailUsers().size()-id;
                position= Integer.parseInt(pos.toString());
                position = position-1;

                System.out.println("position "+position);
                System.out.println("indes es: "+((8*position)+4));
                //System.out.println("0o0o0o0id  es:"+extras.get((7*position)+0));
                detailIntent.putExtra("id",extras.get((8*position)+0));
                //System.out.println("0o0o0o0telefono  es:"+extras.get((7*position)+1));
                detailIntent.putExtra("phone",extras.get((8*position)+1));
                //System.out.println("0o0o0o0estrellas  es:"+extras.get((7*position)+2));
                detailIntent.putExtra("score",extras.get((8*position)+2));
                //System.out.println("0o0o0o0recursos  es:"+extras.get((7*position)+3));
                detailIntent.putExtra("resources",extras.get((8*position)+3));
                //System.out.println("0o0o0o0nombre  es:"+extras.get((7*position)+4));
                System.out.println("nombre  es:"+extras.get((8*position)+4));
                detailIntent.putExtra("name",extras.get((8*position)+4));
                //System.out.println("0o0o0o0foto  es:"+extras.get((7*position)+5));
                detailIntent.putExtra("photo",extras.get((8*position)+5));
               // System.out.println("0o0o0o0email  es:"+extras.get((7*position)+6));
                detailIntent.putExtra("email",extras.get((8*position)+6));


                //System.out.println("uiuiuiuiuiUIUIUIUIUU"+extras.get((8*position)+7));
                /*
                for(int x=0; x<extras.size(); x++){
                    System.out.println("nombre "+x+" es:"+extras.get(x));
                }

                for(int x=0; x<jk.getDetailUsers().size(); x++){
                    System.out.println("///nombre  es:"+extras.get((7*x)+4));
                }

*/

                detailIntent.putExtra("aviable",extras.get((8*position)+7));

                detailIntent.putExtra("abc","abc");
                startActivity(detailIntent);

            }
        });


    }


}
