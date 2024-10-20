package com.example.yourapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView displayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        displayTextView = findViewById(R.id.displayTextView);

        // Get data from the Intent
        String firstName = getIntent().getStringExtra("FIRST_NAME");
        String lastName = getIntent().getStringExtra("LAST_NAME");

        // Display the received data
        displayTextView.setText("First Name: " + firstName + "\nLast Name: " + lastName);
    }
}
