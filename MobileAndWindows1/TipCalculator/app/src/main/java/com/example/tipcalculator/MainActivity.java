package com.example.tipcalculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Initialize all views:
    EditText editTextTotalBill, editTextTipPercentage;
    Button buttonCalculateTip;
    TextView tipText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hook them up with the XML views:
        editTextTotalBill = findViewById(R.id.editTextTotalBill);
        editTextTipPercentage = findViewById(R.id.editTextTipPercentage);
        buttonCalculateTip = findViewById(R.id.buttonCalculateTip);
        tipText = findViewById(R.id.tipText);

        //Set on click listener:
        buttonCalculateTip.setOnClickListener(this);

        /*//One could also do this instead using anonymous inner class:
        buttonCalculateTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SAME CODE AS onClick method below...

            }
        });

        */





    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {

        /*We are assuming all the fields are filled up correctly (only numbers).

        Otherwise the app will crash...for now!

        We will work on exception handling in the coming weeks! :)

         */
        //Read the editText and convert to double...
        double totalBill = Double.parseDouble(editTextTotalBill.getText().toString());
        double totalPercentage = Double.parseDouble(editTextTipPercentage.getText().toString());

        double billAmount = totalBill * totalPercentage / 100.0;

        tipText.setText("Tip Due: " + billAmount);
        Log.d("HELLO", "onClick: tip calculated");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ONSTART", "onStart: app started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ONSTOP", "onStop: app stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("WOAH", "onDestroy: app destroyed");
    }
}