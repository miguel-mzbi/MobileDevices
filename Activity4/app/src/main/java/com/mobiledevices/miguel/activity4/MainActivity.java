package com.mobiledevices.miguel.activity4;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Properties;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;

    private Properties properties;
    private static final String MY_FILE3 = "properties.xml";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText) findViewById(R.id.editTextName);

        File file3 = new File(getFilesDir(), MY_FILE3);
        properties = new Properties();

        try {

            if(file3.exists()) {

                // Load properties from the file
                FileInputStream fis3 = openFileInput(MY_FILE3);
                properties.loadFromXML(fis3);
                fis3.close();

                editTextName.setText(properties.getProperty("userName"));

            } else {

                // Create new file if none exist to a private folder
                FileOutputStream fos = openFileOutput(MY_FILE3, Context.MODE_PRIVATE);
                properties.storeToXML(fos, null);
                Toast.makeText(this, "Properties file created", Toast.LENGTH_SHORT).show();
            }

        } catch(Exception e) {
            Log.wtf("MAIN", "Error loading file. Error: " + e.toString());
        }

        try {
            InputStream is1 = getAssets().open("greeting1.txt");
            InputStream is2 = getResources().openRawResource(R.raw.greeting2);
            InputStreamReader isr1 = new InputStreamReader(is1);
            InputStreamReader isr2 = new InputStreamReader(is2);
            BufferedReader buf1 = new BufferedReader(isr1);
            BufferedReader buf2 = new BufferedReader(isr2);

            String welcome = buf1.readLine() + "\n" + buf2.readLine();
            Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_SHORT).show();

        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void buttonToHobbiesWasClicked(View v){
        properties.setProperty("userName", editTextName.getText().toString());

        try {

            FileOutputStream fos = openFileOutput(MY_FILE3, Context.MODE_PRIVATE);
            properties.storeToXML(fos, null);
            fos.close();

        } catch(IOException ioe) {

            ioe.printStackTrace();
        }

        Intent message = new Intent(this, MenuActivity.class);
        startActivity(message);
    }
}
