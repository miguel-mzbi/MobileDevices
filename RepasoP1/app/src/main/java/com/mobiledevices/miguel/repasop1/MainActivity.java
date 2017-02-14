package com.mobiledevices.miguel.repasop1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    Button toMenuButton;
    TextView welcomeMessText;
    EditText userInputEditText;
    Properties fileProperties;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toMenuButton = (Button)findViewById(R.id.to_menu_button);
        welcomeMessText = (TextView)findViewById(R.id.welcome_mess_text);
        userInputEditText = (EditText)findViewById(R.id.user_input_edit_text);

        fileProperties = new Properties();
        File editFile = new File(getFilesDir(), "appfile.xml");
        try {
            if(editFile.exists()){
                FileInputStream fileData = openFileInput("appfile.xml");
                fileProperties.loadFromXML(fileData);
                userInputEditText.setText(fileProperties.getProperty("input_data"));
            }
            else {
                FileOutputStream fos = openFileOutput("appfile.xml", MODE_PRIVATE);
                fileProperties.storeToXML(fos, null);
                userInputEditText.setText("Write something here!");
            }

            InputStream welcome1 = getAssets().open("welcome1.txt");
            InputStreamReader isrw1 = new InputStreamReader(welcome1);
            BufferedReader brw1 = new BufferedReader(isrw1);
            String contenido1 = "", contenido2 = "";
            String pre;
            while((pre = brw1.readLine()) != null) {

                contenido1 += " " + pre;
            }

            InputStream welcome2 = getResources().openRawResource(R.raw.welcome2);
            InputStreamReader isrw2 = new InputStreamReader(welcome2);
            BufferedReader brw2 = new BufferedReader(isrw2);
            while((pre = brw2.readLine()) != null) {

                contenido2 += " " + pre;
            }

            welcomeMessText.setText(contenido1 + contenido2);

            brw1.close();
            brw2.close();

        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void toMenu(View v){
        try {
            FileOutputStream fos = openFileOutput("appfile.xml", MODE_PRIVATE);
            fileProperties.setProperty("input_data", userInputEditText.getText().toString());
            fileProperties.storeToXML(fos, null);
            fos.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        Intent i = new Intent(this, MenuActivity.class);
        i.putExtra("data", userInputEditText.getText().toString());
        startActivity(i);

    }
}
