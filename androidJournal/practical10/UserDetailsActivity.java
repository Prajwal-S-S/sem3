package com.example.yourapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UserDetailsActivity extends AppCompatActivity {

    private Button loginButton;
    private Button registrationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        // Initialize buttons
        loginButton = findViewById(R.id.loginButton);
        registrationButton = findViewById(R.id.registrationButton);

        // Set onClickListener for the Login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle login action
                Toast.makeText(UserDetailsActivity.this, "Login Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Set onClickListener for the Registration button
        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle registration action
                Toast.makeText(UserDetailsActivity.this, "Registration Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
