package com.example.android.firebase.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.example.android.firebase.R;
import com.example.android.firebase.model.Message;
import com.example.android.firebase.viewmodel.MyViewModel;

public class MainActivity extends AppCompatActivity {

    MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        viewModel.getData().observe(this, new Observer<Message>() {
            @Override
            public void onChanged(Message message) {
                Log.d("TAG_X", "onChanged: "+message);
            }
        });


        viewModel.sendRealMessage(new Message("Hey, how's it going?",
                "1/15/2020",
                "Convo",
                "chrisfitz"
                ));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.getData().removeObservers(this);
    }
}
