package com.mobiledevices.miguel.activity3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView inputName;
    Button goNextAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = (TextView)findViewById(R.id.inputName);
        goNextAct = (Button)findViewById(R.id.buttonToNext);
    }

    public void buttonWasClicked(View v){
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("name", inputName.getText().toString());
        startActivity(intent);
    }
}
