package com.mobiledevices.miguel.activity4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NotioliActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notioli);
    }

    public void toMenu (View v){
        finish();
    }
}
