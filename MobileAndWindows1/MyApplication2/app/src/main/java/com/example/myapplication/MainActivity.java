package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button myButton;
    String TAG = "MYTAG";
    EditText editTextTextPersonName;

    public static final String KEYFORINT = "KEYFORINT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate");


        myButton = findViewById(R.id.button);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);

        myButton.setOnClickListener(this);


//        // GetContent creates an ActivityResultLauncher<String> to allow you to pass
//        // in the mime type you'd like to allow the user to select
//        ActivityResultLauncher<Intent> mGetContent = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
//                new ActivityResultCallback<ActivityResult>() {
//                    @Override
//                    public void onActivityResult(ActivityResult result) {
//
//                    }
//                });
//
//        Intent intent = new Intent(this,MainActivity.class);
//
//        mGetContent.launch(intent);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("KEY", editTextTextPersonName.getText().toString());
        intent.putExtra(KEYFORINT, 34);

        startActivity(intent);
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