package com.example.angel.myapplication.Models;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MateriaInteractor {


        private static final String TAG =  MateriaInteractor.class.getSimpleName();

        private FirebaseDatabase database = FirebaseDatabase.getInstance();

        private DatabaseReference chatElementReference = database.getReference("chat");

        private MateriaPresenter presenter;

        private ArrayList<String>mCurrentChatList = new ArrayList<>();

       public MateriaInteractor(MateriaPresenter presenter) {
            this.presenter = presenter;
            retrieveCurrentChat();
        }
////
        public void retrieveCurrentChat() {
            chatElementReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    mCurrentChatList.clear();

                    for (DataSnapshot messagesSnapshot : dataSnapshot.getChildren()) {
                        String chatMessage = messagesSnapshot.getValue(String.class);
                        mCurrentChatList.add(chatMessage);
                    }

                    presenter.refreshCurrentChatList(mCurrentChatList);
                    Log.i("Se hizio",""+mCurrentChatList);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    //TODO: Handle error on presenter here.
                }
            });
        }

}
