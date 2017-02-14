package com.mobiledevices.miguel.repasop1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    Button toBase;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent end = getIntent();
        Toast.makeText(this, end.getStringExtra("data"), Toast.LENGTH_SHORT).show();

        toBase = (Button)findViewById(R.id.base_button);
        toBase.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                // startActivity(new Intent(MenuActivity.this, BaseActivity.class));
                letsGo(view);
            }
        });
    }

    public void letsGo(View v) {
        Intent i = new Intent(this, BaseActivity.class);
        startActivity(i);
    }
}
