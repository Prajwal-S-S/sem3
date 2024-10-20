package com.example.yourapp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class DialogDemoActivity extends AppCompatActivity {

    private Button alertDialogButton;
    private Button progressDialogButton;
    private Button datePickerButton;
    private Button timePickerButton;
    private Button customDialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_demo);

        alertDialogButton = findViewById(R.id.alertDialogButton);
        progressDialogButton = findViewById(R.id.progressDialogButton);
        datePickerButton = findViewById(R.id.datePickerButton);
        timePickerButton = findViewById(R.id.timePickerButton);
        customDialogButton = findViewById(R.id.customDialogButton);

        // Show Alert Dialog
        alertDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });

        // Show Progress Dialog
        progressDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressDialog();
            }
        });

        // Show Date Picker Dialog
        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        // Show Time Picker Dialog
        timePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });

        // Show Custom Dialog
        customDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert Dialog")
                .setMessage("This is an alert dialog.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogDemoActivity.this, "OK clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogDemoActivity.this, "Cancel clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setCancelable(true)
                .show();
    }

    private void showProgressDialog() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Progress Dialog");
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        // Simulate a long-running operation
        new Thread(() -> {
            try {
                Thread.sleep(3000); // Simulate a delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            runOnUiThread(() -> progressDialog.dismiss());
        }).start();
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                Toast.makeText(DialogDemoActivity.this,
                        "Selected Date: " + selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear,
                        Toast.LENGTH_SHORT).show();
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
                Toast.makeText(DialogDemoActivity.this, "Selected Time: " + selectedHour + ":" + selectedMinute,
                        Toast.LENGTH_SHORT).show();
            }
        }, hour, minute, true);
        timePickerDialog.show();
    }

    private void showCustomDialog() {
        // Create a custom dialog layout
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Custom Dialog");
        builder.setMessage("This is a custom dialog.");

        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogDemoActivity.this, "Dialog closed", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog customDialog = builder.create();
        customDialog.show();
    }
}
