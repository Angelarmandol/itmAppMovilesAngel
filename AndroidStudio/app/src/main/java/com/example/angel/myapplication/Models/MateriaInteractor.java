package com.example.angel.myapplication.Models;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MateriaInteractor {



        private static final String TAG =  MateriaInteractor.class.getSimpleName();

        private FirebaseDatabase database = FirebaseDatabase.getInstance();

        private DatabaseReference chatElementReference = database.getReference("chat");

        private ChatPresenter presenter;

        private ArrayList<ChatMessage> mCurrentChatList = new ArrayList<>();

        ChatInteractor(ChatPresenter presenter) {
            this.presenter = presenter;
            retrieveCurrentChat();
        }

        private void retrieveCurrentChat() {
            chatElementReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    mCurrentChatList.clear();

                    for (DataSnapshot messagesSnapshot : dataSnapshot.getChildren()) {
                        ChatMessage chatMessage = messagesSnapshot.getValue(ChatMessage.class);
                        mCurrentChatList.add(chatMessage);
                    }

                    presenter.refreshCurrentChatList(mCurrentChatList);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    //TODO: Handle error on presenter here.
                }
            });
        }

        void sendNewMessageToChat(ChatMessage message) {
            chatElementReference.child(message.getTimestamp()).setValue(message);
        }

}
