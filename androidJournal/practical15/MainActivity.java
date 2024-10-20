package com.example.two_fragments_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        // Load FragmentOne into the first container
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer1, new FragmentOne())
                .commit();

        // Load FragmentTwo into the second container
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer2, new FragmentTwo())
                .commit();
    }
}
