package com.mobiledevices.miguel.activity3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HobbyActivity extends AppCompatActivity {

    Button returnMenu;
    EditText hisHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobby);

        returnMenu = (Button)findViewById(R.id.buttonReturnHobby);
        hisHobby = (EditText)findViewById(R.id.editHobby);
    }

    public void returnButtonWasClicked(View v){
        Intent menu = new Intent();
        menu.putExtra("hisHobby", hisHobby.getText().toString());
        setResult(Activity.RESULT_OK, menu);
        finish();
    }
}
