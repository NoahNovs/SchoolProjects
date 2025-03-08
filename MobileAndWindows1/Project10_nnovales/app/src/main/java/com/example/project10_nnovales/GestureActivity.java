package com.example.project10_nnovales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class GestureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment1, ballFragment.class, null)
                .add(R.id.fragment2, logFragment.class,null)
                .commit();

    }
}