package com.example.angel.myapplication.Net;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.angel.myapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubjectPresenter {

    public ArrayAdapter<String> getAdaptor() {
        return adaptor;
    }

    public void setAdaptor(ArrayAdapter<String> adaptor) {
        this.adaptor = adaptor;
    }
    ArrayAdapter<String> adaptor;
    @BindView(R.id.lv_materias) ListView localListview;
    public void setLocalListView(ListView searchListView) {
        this.localListview = searchListView;
    }

    FirebaseHolder instance = new FirebaseHolder();


    public ListView getSearchListView(Context context, View view) {
        ButterKnife.bind(this, view);
        adaptor = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
        localListview.setAdapter(adaptor);

        instance.getMateria().addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    adaptor.add(snapshot.getValue(String.class));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("Error", databaseError.getMessage());
            }
        });


        return localListview;
    }








}
