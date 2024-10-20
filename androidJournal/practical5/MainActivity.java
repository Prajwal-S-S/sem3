package com.example.yourapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText mobileNumberEditText;
    private EditText emailEditText;
    private Button submitButton;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        mobileNumberEditText = findViewById(R.id.mobileNumberEditText);
        emailEditText = findViewById(R.id.emailEditText);
        submitButton = findViewById(R.id.submitButton);

        dbHelper = new DatabaseHelper(this);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    private void saveData() {
        String firstName = firstNameEditText.getText().toString().trim();
        String lastName = lastNameEditText.getText().toString().trim();
        String mobileNumber = mobileNumberEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();

        // Validate inputs
        if (TextUtils.isEmpty(firstName)) {
            Toast.makeText(this, "First Name is required", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(lastName)) {
            Toast.makeText(this, "Last Name is required", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(mobileNumber) || mobileNumber.length() != 10) {
            Toast.makeText(this, "Enter a valid 10-digit Mobile Number", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Enter a valid Email Address", Toast.LENGTH_SHORT).show();
            return;
        }

        // Insert data into the database
        dbHelper.insertUser(firstName, lastName, mobileNumber, email);
        Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();

        // Clear input fields
        firstNameEditText.setText("");
        lastNameEditText.setText("");
        mobileNumberEditText.setText("");
        emailEditText.setText("");
    }
}
