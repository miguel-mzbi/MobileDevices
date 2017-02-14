package com.mobiledevices.miguel.repasop1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BaseActivity extends AppCompatActivity {

    Button findButton, saveButton, deleteButton;
    EditText dispName, dispId;
    DBClass db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        db = new DBClass(this);
        findButton =(Button)findViewById(R.id.buttonFind);
        saveButton =(Button)findViewById(R.id.buttonSave);
        deleteButton =(Button)findViewById(R.id.buttonRemove);
        dispName =(EditText)findViewById(R.id.editTextName);
        dispId =(EditText)findViewById(R.id.editTextID);
    }

    public void find(View v){
        dispId.setText(db.select(dispName.getText().toString()));
    }
    public void insert(View v){
        db.insert(dispName.getText().toString());
    }
    public void remove(View v){
        db.remove(dispId.getText().toString());
    }
}
