package com.example.yourapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText eidEditText;
    private EditText enameEditText;
    private EditText adeptEditText;
    private EditText esalaryEditText;
    private Button insertButton;
    private TextView employeeList;
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
        employeeList = findViewById(R.id.employeeList);

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

        // Display all employees
        displayAllEmployees();
    }

    private void displayAllEmployees() {
        Cursor cursor = dbHelper.getAllEmployees();
        StringBuilder stringBuilder = new StringBuilder();

        if (cursor.moveToFirst()) {
            do {
                int eid = cursor.getInt(cursor.getColumnIndex(EmployeeDatabaseHelper.COLUMN_EID));
                String ename = cursor.getString(cursor.getColumnIndex(EmployeeDatabaseHelper.COLUMN_ENAME));
                String adept = cursor.getString(cursor.getColumnIndex(EmployeeDatabaseHelper.COLUMN_ADEPT));
                float esalary = cursor.getFloat(cursor.getColumnIndex(EmployeeDatabaseHelper.COLUMN_ESALARY));

                stringBuilder.append("ID: ").append(eid)
                        .append(", Name: ").append(ename)
                        .append(", Dept: ").append(adept)
                        .append(", Salary: ").append(esalary)
                        .append("\n");
            } while (cursor.moveToNext());
        }
        cursor.close();

        // Update the TextView with employee list
        employeeList.setText(stringBuilder.toString());
    }
}
