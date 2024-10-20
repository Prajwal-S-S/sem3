package com.example.yourapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class StudentListActivity extends AppCompatActivity {

    private ListView studentListView;
    private ArrayList<String> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        studentListView = findViewById(R.id.studentListView);

        // Create a list of students
        studentList = new ArrayList<>();
        studentList.add("John Doe");
        studentList.add("Jane Smith");
        studentList.add("Michael Brown");
        studentList.add("Emily Davis");
        studentList.add("Daniel Wilson");

        // Create an ArrayAdapter to bind the student list to the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.list_item_student, // Custom layout for each item
                R.id.studentNameTextView, // TextView inside the custom layout
                studentList // Data source
        );

        // Set the adapter to the ListView
        studentListView.setAdapter(adapter);
    }
}
