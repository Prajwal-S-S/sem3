package com.example.yourapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText eidEditText;
    private EditText enameEditText;
    private EditText adeptEditText;
    private EditText esalaryEditText;
    private Button insertButton;
    private EmployeeDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eidEditText = findViewById(R.id.eid);
        enameEditText = findViewById(R.id.ename);
        adeptEditText = findViewById(R.id.adept);
        esalaryEditText = findViewById(R.id.esalary);
        insertButton = findViewById(R.id.insertButton);

        dbHelper = new EmployeeDatabaseHelper(this);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertEmployee();
            }
        });
    }

    private void insertEmployee() {
        String eidString = eidEditText.getText().toString().trim();
        String ename = enameEditText.getText().toString().trim();
        String adept = adeptEditText.getText().toString().trim();
        String esalaryString = esalaryEditText.getText().toString().trim();

        // Validate inputs
        if (eidString.isEmpty() || ename.isEmpty() || adept.isEmpty() || esalaryString.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Parse employee ID and salary
        int eid = Integer.parseInt(eidString);
        float esalary = Float.parseFloat(esalaryString);

        // Insert employee into database
        dbHelper.insertEmployee(eid, ename, adept, esalary);
        Toast.makeText(this, "Employee inserted successfully", Toast.LENGTH_SHORT).show();

        // Clear input fields
        eidEditText.setText("");
        enameEditText.setText("");
        adeptEditText.setText("");
        esalaryEditText.setText("");
    }
}
