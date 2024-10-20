package com.example.yourapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LifecycleActivity extends AppCompatActivity {

    private static final String TAG = "LifecycleActivity";
    private TextView lifecycleTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        lifecycleTextView = findViewById(R.id.lifecycleTextView);
        lifecycleTextView.setText("onCreate called");
        showToast("onCreate called");
        Log.d(TAG, "onCreate called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        lifecycleTextView.setText("onStart called");
        showToast("onStart called");
        Log.d(TAG, "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        lifecycleTextView.setText("onResume called");
        showToast("onResume called");
        Log.d(TAG, "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        lifecycleTextView.setText("onPause called");
        showToast("onPause called");
        Log.d(TAG, "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        lifecycleTextView.setText("onStop called");
        showToast("onStop called");
        Log.d(TAG, "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifecycleTextView.setText("onDestroy called");
        showToast("onDestroy called");
        Log.d(TAG, "onDestroy called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        lifecycleTextView.setText("onRestart called");
        showToast("onRestart called");
        Log.d(TAG, "onRestart called");
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
