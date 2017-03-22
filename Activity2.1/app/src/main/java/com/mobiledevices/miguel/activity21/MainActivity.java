package com.mobiledevices.miguel.activity21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

public class MainActivity extends AppCompatActivity implements JSONRequest.JSONRequestCallback {

    Button load;
    ListView friends;
    JSONArray friendsJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load = (Button) findViewById(R.id.button_load);
        friends = (ListView) findViewById(R.id.lv_friends);

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.request(v);
            }
        });

        friends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), FriendsActivity.class);
                try{
                    i.putExtra("JSON", friendsJSON.getJSONObject(position).toString());
                }
                catch(JSONException e) {
                    e.printStackTrace();
                }
                startActivity(i);
            }
        });

    }

    public void request(View v) {
        JSONRequest r = new JSONRequest(this);
        r.execute("https://api.myjson.com/bins/j5huz");
    }

    public void done(JSONArray jsonArray) {

        try {
            for(int i = 0; i < jsonArray.length(); i++) {
                Toast.makeText(this, jsonArray.getJSONObject(i).getString("name"), Toast.LENGTH_SHORT).show();
            }
            friendsJSON = jsonArray;
            JSONAdapter jsonAdapter = new JSONAdapter(this, friendsJSON);
            friends.setAdapter(jsonAdapter);

        }
        catch(JSONException e) {
            e.printStackTrace();
        }
    }
}
