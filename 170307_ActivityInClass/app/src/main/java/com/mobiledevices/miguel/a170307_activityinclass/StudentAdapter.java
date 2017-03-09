package com.mobiledevices.miguel.a170307_activityinclass;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by miguel on 7/03/17.
 */

public class StudentAdapter extends BaseAdapter{

    private ArrayList<Student> data;
    private Activity activity;

    public StudentAdapter(ArrayList<Student> d, Activity a) {

        this.data = d;
        this.activity = a;
    }

    @Override
    public int getCount() {

        return data.size();
    }

    @Override
    public Object getItem(int position) {

        return data.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Create if doesn't exist
        if(convertView == null) {

            convertView = this.activity.getLayoutInflater().inflate(R.layout.row, null);
        }

        // Populate with data
        TextView name = (TextView) convertView.findViewById(R.id.Large);
        TextView gradeText = (TextView) convertView.findViewById(R.id.Medium);

        Student current = this.data.get(position);
        name.setText(current.getName());
        gradeText.setText(current.getGrade() + "");

        return convertView;
    }
}
