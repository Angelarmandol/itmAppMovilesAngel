package com.example.angel.myapplication.Net;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.angel.myapplication.Models.UserDetail;
import com.example.angel.myapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserNet {


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference(FireBaseInstances.ReferenceAlumno);


    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("alumno");

    public void subir(){


      // UserDetail user = new UserDetail("Elma Rovers", "(825)-172-7102", "elma.rovers@example.com", "aac41f269050ceddeecbd1ace2d", "https://randomuser.me/api/portraits/med/women/56.jpg", 5);

      //  dbRef.child("ki87654d").setValue(user);

    }


    public ArrayAdapter<String> getAdaptador() {
        return adaptador;
    }

    public void setAdaptador(ArrayAdapter<String> adaptador) {
        this.adaptador = adaptador;
    }
    Holder holder = new Holder();
    ArrayAdapter<String> adaptador;
    @BindView(R.id.lv_asesores) ListView localListview;
    ArrayList localArrayList = new ArrayList();

    HashMap test2 = new HashMap();

    final HashMap list_Materias = new HashMap();


    public ListView getSearchListView(Context context, View view) {

        Log.i("o0o0o0o0o","es"+database.getReference());

        ButterKnife.bind(this, view);
        adaptador = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
        localListview.setAdapter(adaptador);

        myRef.addValueEventListener(new ValueEventListener() {




            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("normal ase", "val: "+dataSnapshot.getValue());
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {


                    list_Materias.put(snapshot,dataSnapshot.getValue());
                    localArrayList.add(dataSnapshot.getChildren());
                    test2.put(snapshot, dataSnapshot);
                    adaptador.add(dataSnapshot.toString());


                }

                Log.i("mandar","snapshot");
                jSONParsin(test2);
                //Log.i("nombres as red:"," "+list_Materias.toString());

                holder.setHolder(list_Materias.toString());
                //holder.setHolderArray(list_Materias);
                //Log.i("holder ase vale: ",""+holder.getHolder());
                //Log.i("holder ase  ",""+holder.getHolderArray());


            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("Error", databaseError.getMessage());
            }
        });





        ArrayList<String> nombresss = new ArrayList<>();
        // nombresss=test.obtenerMaterias();

        Holder holder = new Holder();
        Log.i("obtenerMAterias:"," "+holder.getHolder());
        nombresss=holder.getHolderArray();



        return localListview;
    }

    public void setLocalListView(ListView searchListView) {
        this.localListview = searchListView;
    }

String text;

    public void jSONParsin(HashMap test){

        ArrayList<UserDetail> detailUsers= new ArrayList<UserDetail>();
        ArrayList<String>datos = new ArrayList<String>();
        String conv = test.toString();
        String[] fff = conv.split("val: ");

        System.out.println("33333333333333");
        System.out.println("Longitud de array"+fff.length);
        //System.out.println(fff[0]);
        System.out.println("------");
        String source = fff[0];
        String[] users = source.split("DataSnapshot");
/////del 1 en adelante
        System.out.println("1"+users[1]);

        System.out.println("Empieza separaciono0o0o0o0ooo00ooo0o");

        for(int x=1; x<24; x++){

        String id = users[x].substring(9);
        String[] id2 = id.split(", ");
        System.out.println("id2:"+id2[0]);
        datos.add(0, id2[0]);
        /////////////////////////////
        String[] telefono = users[x].split("tv_telephone=");
        telefono=telefono[1].split(", ");
        System.out.println("valor de thelepohe:"+telefono[0]);
        /////////////////////////////
        String[] score = users[x].split("score=");
        score=score[1].split(", ");
        System.out.println("valor de score:"+score[0]);
        ////////////////////////////
        String[] area = users[x].split("area_resources=");
        area=area[1].split(", ");
        System.out.println("valor de area:"+area[0]);
        ////////////////////////////
        String[] name = users[x].split("fbUserName=");
        name=name[1].split(", ");
        System.out.println("valor de name:"+name[0]);
        ////////////////////////////
        String[] link = users[x].split("link=");
        link=link[1].split(", ");
        System.out.println("valor de link:"+link[0]);
        ////////////////////////////
        String[] tv_email = users[x].split("tv_email=");
        tv_email=tv_email[1].split(", ");
        System.out.println("valor de tv_email:"+tv_email[0]);

        System.out.println("..............................................................");
x++;

        }

/*

        JSONArray lista = null;
        try {
            lista = json.getJSONArray("568749");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < lista.length(); i++){
            UserDetail conditions = new UserDetail();
            JSONObject c = null;
            try {
                c = lista.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }

                /*
                JSONObject phone = c.getJSONObject("main");
                JSONArray wt = c.getJSONArray("weather");
                conditions.weatherSimple =wt.getJSONObject(0).getString("main");
                conditions.dateComplete = c.getString("dt_txt");
                String kelvin = phone.getString("temp");
                String subString = kelvin.toString();
                conditions.temp = (subString);
                String idIcon = wt.getJSONObject(0).getString("id");
                conditions.imageUrl=getUrlIcon(idIcon);
                System.out.println(conditions.imageUrl);
                conditions.humidity = phone.getString("humidity")+"%";
                conditions.pressure = phone.getString("pressure")+" bar";
                JSONObject ws = c.getJSONObject("wind");
                conditions.windSpeed =ws.getString("speed");



        }

 */

    }



}
