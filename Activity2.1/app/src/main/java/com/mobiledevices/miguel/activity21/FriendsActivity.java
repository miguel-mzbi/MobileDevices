package com.mobiledevices.miguel.activity21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class FriendsActivity extends AppCompatActivity {

    JSONObject friend;
    TextView name, hobby, age, phone, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        Intent i = getIntent();
        try{
            friend = new JSONObject(i.getStringExtra("JSON"));
        }
        catch(JSONException e) {
            e.printStackTrace();
        }
        name = (TextView) findViewById(R.id.friend_name);
        hobby = (TextView) findViewById(R.id.friend_hobby);
        age = (TextView) findViewById(R.id.friend_age);
        phone = (TextView) findViewById(R.id.friend_phone);
        address = (TextView) findViewById(R.id.friend_address);

        try {
            name.setText(friend.getString("name"));
            hobby.setText("Hobby: " + friend.getString("hobby"));
            age.setText("Age: " + friend.getString("age"));
            phone.setText("Phone: " + friend.getString("phone"));
            address.setText("Address: " + friend.getString("adress"));
        }
        catch(JSONException e) {
            e.printStackTrace();
        }
    }
}
