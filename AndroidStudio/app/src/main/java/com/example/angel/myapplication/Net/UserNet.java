package com.example.angel.myapplication.Net;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.angel.myapplication.Models.UserDetail;
import com.example.angel.myapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.facebook.FacebookSdk.getApplicationContext;

public class UserNet {


    ArrayList<ArrayList> detailUsers= new ArrayList<ArrayList>();
    public ArrayList<ArrayList> getDetailUsers() {
        return detailUsers;
    }
    public void setDetailUsers(ArrayList<ArrayList> detailUsers) {
        this.detailUsers = detailUsers;
    }

    ArrayAdapter<String> adaptador;
    public ArrayAdapter<String> getAdaptador() {
        return adaptador;
    }
    public void setAdaptador(ArrayAdapter<String> adaptador) {
        this.adaptador = adaptador;
    }

    ArrayList localArrayList = new ArrayList();

    public void setLocalListView(ListView searchListView) {
        this.localListview = searchListView;
    }

    HashMap filesLocalHashMap = new HashMap();

    @BindView(R.id.lv_asesores) ListView localListview;
    final HashMap list_Materias = new HashMap();

    FirebaseHolder myRef = new FirebaseHolder();

    public ListView getSearchListView(Context context, View view) {

        ButterKnife.bind(this, view);
        adaptador = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
        localListview.setAdapter(adaptador);

        myRef.getAsesor().addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    filesLocalHashMap.put(snapshot, dataSnapshot);
                }
                jSONParsin(filesLocalHashMap);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast toast4 =
                        Toast.makeText(getApplicationContext(), "Cancelacion de acceso a base de datos", Toast.LENGTH_SHORT);
                toast4.show();
            }
        });

        return localListview;
    }



    public void jSONParsin(HashMap test){

        ArrayList<String>data = new ArrayList<String>();

        String conv = test.toString();
        String[] principalInstance = conv.split("val: ");
        String source = principalInstance[0];
        String[] users = source.split("DataSnapshot");

            int iterator=0;
            for(int x=1; x<24; x++){

            String id = users[x].substring(9);
            String[] id2 = id.split(", ");
            //System.out.println("id2:"+id2[0]);
            data.add(0,id2[0]);
            /////////////////////////////
                System.out.println("+++++++++++++++++++++"+users[x]);
            String[] telefono = users[x].split("tv_telephone=");
            telefono=telefono[1].split(", ");
            //System.out.println("valor de thelepohe:"+telefono[0]);
            data.add(1,telefono[0]);
            /////////////////////////////
            String[] score = users[x].split("score=");
            score=score[1].split(", ");
            //System.out.println("valor de score:"+score[0]);
            data.add(2,score[0]);
            ////////////////////////////
            String[] area = users[x].split("area_resources=");
            area=area[1].split(", ");
            //System.out.println("valor de area:"+area[0]);
            data.add(3,area[0]);
            ////////////////////////////
            String[] name = users[x].split("fbUserName=");
            name=name[1].split(", ");
            //System.out.println("valor de name:"+name[0]);
            data.add(4,name[0]);
            adaptador.add(name[0]);
            ////////////////////////////
            String[] link = users[x].split("link=");
            link=link[1].split(", ");
            //System.out.println("valor de link:"+link[0]);
            data.add(5,link[0]);
            ////////////////////////////
            String[] tv_email = users[x].split("tv_email=");
            tv_email=tv_email[1].split(", ");
            //System.out.println("valor de tv_email:"+tv_email[0]);
            data.add(6,tv_email[0]);
                String[] img_aviable = users[x].split("zaviable=");
                if(img_aviable[0].length()<50){
                img_aviable=img_aviable[1].split(", ");
               /// System.out.println("valor de zaviable:"+img_aviable[0]);
                data.add(7,img_aviable[0]);

                }
           // System.out.println("..............................................................");
            detailUsers.add(iterator,data);
            iterator++;
            x++;
        }
    }

    public void setAviable(){


        UserDetail user = new UserDetail("Test", "(825)-172-7102", "elma.rovers@example.com", "aac41f269050ceddeecbd1ace2d", "https://randomuser.me/api/portraits/med/women/56.jpg", 5, true);

        myRef.getDbRef().child("ki87654d").setValue(user);

    }

    public void setUnaviable(){

        UserDetail user2 = new UserDetail("Test", "(825)-172-7102", "elma.rovers@example.com", "aac41f269050ceddeecbd1ace2d", "https://randomuser.me/api/portraits/med/women/56.jpg", 5, false);

        myRef.getDbRef().child("ki87654d").setValue(user2);;

    }

}
