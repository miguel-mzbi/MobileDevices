package com.mobiledevices.miguel.a170131activityinclass;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;


public class MainActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private TextView textView;
    private EditText editText;

    private Properties properties;
    private static final String MY_FILE = "properties.xml";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);
        textView = (TextView)findViewById(R.id.textView);
        editText = (EditText)findViewById(R.id.editText);

        // Code for properties
        File file = new File(getFilesDir(), MY_FILE);
        properties = new Properties();

        // Try to open
        try {

            // If the file exists
            if(file.exists()) {

                // Load information from the file
                FileInputStream fis = openFileInput(MY_FILE);
                properties.loadFromXML(fis);
                fis.close();
                Toast.makeText(this, "Loading from storage", Toast.LENGTH_SHORT).show();
            } else {

                // Create new file if none exist to a private folder
                FileOutputStream fos = openFileOutput(MY_FILE, Context.MODE_PRIVATE);
                properties.storeToXML(fos, null);
                Toast.makeText(this, "File created", Toast.LENGTH_SHORT).show();
            }

        } catch(Exception e) {
            Log.wtf("MAIN", "Error loading file. Error: " + e.toString());
        }

    }

    public void add(View v) {

        dbHelper.save(editText.getText().toString());
        Toast.makeText(this, "Value saved!", Toast.LENGTH_SHORT).show();
    }

    public void find(View v) {

        int result = dbHelper.find(editText.getText().toString());
        Toast.makeText(this, "Value found: " + result, Toast.LENGTH_SHORT).show();
    }

    public void delete(View v) {

        int r = dbHelper.delete(Integer.parseInt(editText.getText().toString()));
        Toast.makeText(this, "Value affected: " + r, Toast.LENGTH_SHORT).show();
    }

    public void saveProperty(View v) {

        // Save the property with KEY demo
        properties.setProperty("demo", editText.getText().toString());
        Log.d("MAIN", "Saved property");
    }

    public void loadProperty(View v) {

        // Load the property from the file with the KEY demo
        editText.setText(properties.getProperty("demo"));
    }

    public void savePropertiesFile(View v) {

        try {

            // Try to save the demo
            FileOutputStream fos = openFileOutput(MY_FILE, Context.MODE_PRIVATE);
            properties.storeToXML(fos, null);
            fos.close();

        } catch(IOException ioe) {

            ioe.printStackTrace();
        }
    }

    public void loadRawFile(View v){

        try {

            // Open indexed file
            InputStream is = getResources().openRawResource(R.raw.file1);
            // Load to stream (Input)
            InputStreamReader isr = new InputStreamReader(is);
            // Load to buffer
            BufferedReader br = new BufferedReader(isr);

            String pre;
            String contenido = "";
            while((pre = br.readLine()) != null) {

                contenido += " " + pre;
            }
            Log.d("RAW", contenido);
            Toast.makeText(this, contenido, Toast.LENGTH_SHORT).show();

        } catch(IOException ioe) {

            ioe.printStackTrace();
        }
    }

    public void loadAssetFile(View v){

        try {

            // Open non-indexed file in assets
            InputStream is = getAssets().open("file2.txt");
            // Load to stream (Input)
            InputStreamReader isr = new InputStreamReader(is);
            // Load to buffer
            BufferedReader br = new BufferedReader(isr);

            String contenido;
            while((contenido = br.readLine()) != null) {

                Log.d("ASSET:", contenido);
            }

        } catch(IOException ioe) {

            ioe.printStackTrace();
        }
    }
}
