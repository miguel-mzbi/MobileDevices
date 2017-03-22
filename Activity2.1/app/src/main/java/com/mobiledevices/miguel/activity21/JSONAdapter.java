package com.mobiledevices.miguel.activity21;

import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by miguel on 21/03/17.
 */

public class JSONAdapter extends BaseAdapter {

    private JSONArray data;
    private Activity activity;

    public JSONAdapter(Activity a, JSONArray d) {
        this.data = d;
        this.activity = a;
    }

    @Override
    public int getCount() {
        return this.data.length();
    }

    @Override
    public Object getItem(int position) {
        try {

            return data.getJSONObject(position);
        }
        catch(JSONException jse) {

            jse.printStackTrace();
        }

        return null;
    }

    @Override
    public long getItemId(int position) {
        return this.data.length();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = this.activity.getLayoutInflater().inflate(R.layout.row_friends, null);
        }

        TextView name = (TextView) convertView.findViewById(R.id.row_name);
        TextView hobby = (TextView) convertView.findViewById(R.id.row_hobby);

        try {
            JSONObject current = this.data.getJSONObject(position);
            name.setText(current.getString("name"));
            hobby.setText(current.getString("hobby"));
        }
        catch(JSONException e) {
            e.printStackTrace();
        }

        return convertView;

    }
}
