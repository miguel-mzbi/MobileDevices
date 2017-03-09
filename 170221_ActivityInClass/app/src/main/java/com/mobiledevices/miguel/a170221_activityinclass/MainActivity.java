package com.mobiledevices.miguel.a170221_activityinclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements JSONRequest.JSONRequestCallback {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void request(View v) {

        JSONRequest r = new JSONRequest(this);
        r.execute("https://api.github.com/");
    }

    public void done(JSONObject jsonObject) {

        try {
            Log.d("JSON", jsonObject.getString("current_user_url"));

            String json2 = "[{'name': 'a', 'grade':'0'},{'name': 'b', 'grade':'10'},{'name': 'a', 'grade':'5'}]";
            JSONArray jsonarray = new JSONArray(json2);
            for(int i = 0; i < jsonarray.length(); i++) {
                JSONObject primero = jsonarray.getJSONObject(i);
                Log.d("JSON PERS", primero.getString("name"));

            }
        }
        catch(JSONException e) {
            e.printStackTrace();
        }
    }
}
