package com.example.myapplication;

import static com.example.myapplication.MainActivity.KEYFORINT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    String TAG = "GameActivity";
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        text = findViewById(R.id.text);
        Intent intent = getIntent();
        String message = intent.getStringExtra("KEY");
        int intValue = intent.getIntExtra(KEYFORINT, 90);
        text.setText(message + intValue);

        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
}