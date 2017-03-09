package com.mobiledevices.miguel.a170307_activityinclass;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by miguel on 7/03/17.
 */

public class JSONAdapter extends BaseAdapter {

    private JSONArray data;
    private Activity activity;

    public JSONAdapter(JSONArray d, Activity a) {

        this.data = d;
        this.activity = a;
    }

    @Override
    public int getCount() {
        return data.length();
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

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {

            convertView = this.activity.getLayoutInflater().inflate(R.layout.row, null);
        }

        TextView name = (TextView) convertView.findViewById(R.id.Large);
        TextView gradeText = (TextView) convertView.findViewById(R.id.Medium);

        try {
            JSONObject current = this.data.getJSONObject(position);
            name.setText(current.getString("name"));
            gradeText.setText(current.getDouble("grade") + "");
        }
        catch(JSONException jse) {
            jse.printStackTrace();
        }

        return null;
    }
}
