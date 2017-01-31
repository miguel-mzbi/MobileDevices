package com.mobiledevices.miguel.activity4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bChecklist, bCalendar, bNotioli, bPlaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bChecklist = (Button)findViewById(R.id.buttonChecklist);
        bCalendar = (Button)findViewById(R.id.buttonCalendar);
        bNotioli = (Button)findViewById(R.id.buttonNotioli);
        bPlaces = (Button)findViewById(R.id.buttonPlaces);
    }

    public void toChecklist (View v){
        Intent i = new Intent(this, ChecklistActivity.class);
        startActivity(i);
    }

    public void toCalendar (View v){
        Intent i = new Intent(this, CalendarActivity.class);
        startActivity(i);
    }

    public void toNotioli (View v){
        Intent i = new Intent(this, NotioliActivity.class);
        startActivity(i);
    }

    public void toPlaces (View v){
        Intent i = new Intent(this, PlacesActivity.class);
        startActivity(i);
    }

}
