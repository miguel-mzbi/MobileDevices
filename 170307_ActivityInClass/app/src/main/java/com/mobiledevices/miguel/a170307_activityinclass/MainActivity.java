package com.mobiledevices.miguel.a170307_activityinclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    ArrayList<Student> students2 = new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data source
        // -array
        // -table on db
        // -JSON answer
        String[] students = {"Daniel", "Dom", "Pablo", "El Infame"};
        students2.add(new Student("Memo", 33));
        students2.add(new Student("Isra", 40));
        students2.add(new Student("Pablo", 99));
        String json = "[{'name':'A', 'grade':75}," +
                       "{'name':'B', 'grade':80}," +
                       "{'name':'C', 'grade':90}]";
        JSONArray jsonArray = null;
        try {

            jsonArray = new JSONArray(json);
        }
        catch(JSONException je) {

            je.printStackTrace();
        }

        // Adapter
        // -translates from data source to UI
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, students);
        StudentAdapter sAdapter = new StudentAdapter(students2, this);
        JSONAdapter jAdapter = new JSONAdapter(jsonArray, this);

        // UI widget
        // -ListView
        // -Spinner
        ListView listView = (ListView) findViewById(R.id.listview);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        listView.setAdapter(sAdapter);
        spinner.setAdapter(sAdapter);

        listView.setOnItemClickListener(this);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(getApplicationContext(), students2.get(position).getName(), Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(), TabActivity.class);
        startActivity(i);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(getApplicationContext(), students2.get(position).getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        Toast.makeText(getApplicationContext(), "NOTHING SELECTED", Toast.LENGTH_SHORT).show();
    }
}
