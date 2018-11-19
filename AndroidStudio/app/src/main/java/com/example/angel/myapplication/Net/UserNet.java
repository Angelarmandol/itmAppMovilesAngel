package com.example.angel.myapplication.Net;

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
                    //adaptador.add(users);


                }
                Log.i("mandar","snapshot");
                jSONParsin(localArrayList);
                Log.i("nombres as red:"," "+list_Materias.toString());

                holder.setHolder(list_Materias.toString());
                //holder.setHolderArray(list_Materias);
                Log.i("holder ase vale: ",""+holder.getHolder());
                Log.i("holder ase  ",""+holder.getHolderArray());


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

    public void jSONParsin(ArrayList result){



        Log.i("valor", ""+result);

        System.out.println("****** principal thread"+result.toString());

        System.out.println("****** secondary thread"+result);

        JSONObject json = null;

        String hola = result.toString();

        json.put(hola,2);

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
                */


        }



    }



}
