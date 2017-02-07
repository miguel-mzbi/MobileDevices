package com.mobiledevices.miguel.activity3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MenuActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_HOBBY = 1;
    TextView hello, hiddenT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        hiddenT = (TextView)findViewById(R.id.textHidden);

        hello = (TextView)findViewById(R.id.textHello);
        Intent main = getIntent();
        hello.append(" " + main.getStringExtra("name"));
    }

    public void buttonToHobbyWasClicked(View v){
        Intent hobby = new Intent(this, HobbyActivity.class);
        startActivityForResult(hobby, REQUEST_CODE_HOBBY);
    }

    public void buttonToFriendsWasClicked(View v){
        Intent friend = new Intent(this, FriendActivity.class);
        startActivity(friend);
    }

    public void buttonToMessagesWasClicked(View v){
        Intent message = new Intent(this, MessagesActivity.class);
        startActivity(message);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == REQUEST_CODE_HOBBY && resultCode == Activity.RESULT_OK){
            hiddenT.setText("Your hobby is: " + data.getStringExtra("hisHobby"));
        }
    }
}
