package com.mobiledevices.miguel.inclassapp1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        Toast.makeText(this, i.getStringExtra("test"), Toast.LENGTH_SHORT).show();
    }

    //Catch button press
    public void getBack(View v){
        Intent i = new Intent();
        i.putExtra("result", "everything is good");
        setResult(Activity.RESULT_OK, i);
        finish();
    }
}
