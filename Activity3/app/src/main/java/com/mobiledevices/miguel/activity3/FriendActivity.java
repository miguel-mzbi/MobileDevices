package com.mobiledevices.miguel.activity3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FriendActivity extends AppCompatActivity {

    Button returnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        returnMenu = (Button)findViewById(R.id.buttonReturnFriends);
    }

    public void returnButtonWasClicked(View v){
        finish();
    }
}
