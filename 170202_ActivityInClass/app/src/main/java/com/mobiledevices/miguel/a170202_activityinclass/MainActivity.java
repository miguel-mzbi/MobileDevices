package com.mobiledevices.miguel.a170202_activityinclass;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void addFragment(View v) {

        // Fragment manager
        FragmentManager manager = getFragmentManager();

        // Transaction
        FragmentTransaction transaction = manager.beginTransaction();

        // Logic here
        // Create reference to a new fragment
        // BlankFragment fragment = new BlankFragment();
        // BlankFragment fragment = BlankFragment.newInstance("", "");
        ExampleFragment fragment = ExampleFragment.newInstance("THE BIG", "THE MEDIUM", "THE SMALL");

        // Add new fragment to activity
        transaction.add(R.id.lay_fragment, fragment, "fragmentTag");

        // Commit
        transaction.commit();
    }

    public void removeFragment(View v) {

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        Fragment f = manager.findFragmentByTag("fragmentTag");
        if(f == null) {
            Toast.makeText(this, "There is no fragment", Toast.LENGTH_SHORT).show();
            return;
        }

        transaction.remove(f);

        transaction.commit();

    }
}
