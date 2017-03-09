package com.mobiledevices.miguel.a170221_activityinclass;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// 3 genereic types
    // 1- input type
    // 2- update type
    // 3- output type
public class JSONRequest extends AsyncTask<String, Void, JSONObject> {

    private JSONRequestCallback listener;

    public JSONRequest(JSONRequestCallback list) {
        this.listener = list;
    }

    protected JSONObject doInBackground(String... params) {

        // Whatever is here is what is going to be done asynchronously
        JSONObject result = null;
        try {

            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            int code = connection.getResponseCode();

            if(code == HttpURLConnection.HTTP_OK) {
                InputStream is = connection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                StringBuilder sb = new StringBuilder();
                String currentLine = "";

                while((currentLine = br.readLine()) != null) {
                    Log.d("JSON RECEIBED", currentLine);
                    sb.append(currentLine);
                }

                result = new JSONObject(sb.toString());
            }
        }
        catch(Exception e) {

            e.printStackTrace();
        }

        return result;
    }

    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);
        listener.done(jsonObject);
    }

    public interface JSONRequestCallback {

        void done(JSONObject jsonObject);
    }
}
