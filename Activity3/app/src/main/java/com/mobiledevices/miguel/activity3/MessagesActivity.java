package com.mobiledevices.miguel.activity3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MessagesActivity extends AppCompatActivity {

    Button buttonSend;
    EditText editMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        buttonSend = (Button)findViewById(R.id.buttonSend);
        editMessage= (EditText)findViewById(R.id.editMessage);
    }

    public void buttonToSendWasClicked(View v){
        Toast.makeText(getApplicationContext(), "Send!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
