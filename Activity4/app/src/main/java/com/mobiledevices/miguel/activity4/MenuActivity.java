package com.mobiledevices.miguel.activity4;

import android.icu.util.BuddhistCalendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MenuActivity extends AppCompatActivity {

    private Button saveUserHobby, saveFriend, loadFriend, deleteFriend;
    private EditText newUserHobby, friendName, friendHobby;
    private DBFriends dbFriends;
    private DBHobbies dbHobbies;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        dbFriends = new DBFriends(this);
        dbHobbies = new DBHobbies(this);
        TextView userHobbies = (TextView) findViewById(R.id.userHobbies);
        newUserHobby = (EditText) findViewById(R.id.newUserHobby);
        friendName = (EditText) findViewById(R.id.editFriendName);
        friendHobby = (EditText) findViewById(R.id.editFriendHobby);
        saveUserHobby = (Button) findViewById(R.id.saveUserHobby);
        saveFriend = (Button) findViewById(R.id.saveFriendHobby);
        loadFriend = (Button) findViewById(R.id.loadFriend);
        deleteFriend = (Button) findViewById(R.id.deleteFriend);

        userHobbies.setText(dbHobbies.find());

    }

    public void saveHobbyClick(View v){
        dbHobbies.save(newUserHobby.getText().toString());
    }

    public void saveFriendClick(View v){
        dbFriends.save(friendName.getText().toString(), friendHobby.getText().toString());
    }

    public void findFriendClick(View v){
        friendHobby.setText(dbFriends.find(friendName.getText().toString()));
    }

    public void deleteFriendClick(View v){
        dbFriends.delete(friendName.getText().toString());
    }
}
