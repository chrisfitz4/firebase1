package com.example.android.firebase.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.android.firebase.model.Message;
import com.example.android.firebase.util.Constants;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyViewModel extends AndroidViewModel {


    private DatabaseReference messageReference;
    private MutableLiveData<Message> messageMutableLiveData = new MutableLiveData<>();

    public MyViewModel(@NonNull Application application) {
        super(application);
        messageReference = FirebaseDatabase.getInstance().getReference(Constants.DATABASE_PATH);

        messageReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot currentData:dataSnapshot.getChildren()){
                    messageMutableLiveData.setValue(currentData.getValue(Message.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("TAG_X", "onCancelled: "+databaseError.getMessage());
            }
        });
    }

    public MutableLiveData<Message> getData(){
        return messageMutableLiveData;
    }


    public void sendRealMessage(Message message){
        String childKey = messageReference.push().getKey();
        if(childKey!=null){
            messageReference.child(childKey).setValue(message);
        }
    }



}
