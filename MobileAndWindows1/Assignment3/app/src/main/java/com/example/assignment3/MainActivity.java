package com.example.assignment3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    TextView numQuestions, message;
    public Button button, minus, plus;
    int num = 1;
    RadioGroup diff, operation;
    RadioButton choice1, choice2;

    public static final String OPERAND = "OPERAND";
    public static final String DIFFICULTY = "DIFFICULTY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numQuestions = findViewById(R.id.numOfQuestions);
        minus = findViewById(R.id.minusButton);
        //updating how many questions needed with plus and minus
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(num <= 1)) {
                    num--;
                    numQuestions.setText(String.valueOf(num));
                }
            }
        });

        plus = findViewById(R.id.plusButton);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num++;
                numQuestions.setText(String.valueOf(num));
            }
        });


        //connecting first and second screen
        button = findViewById(R.id.startButton);

        diff = findViewById(R.id.diffGroup);
        operation = findViewById(R.id.operGroup);
        message = findViewById(R.id.ResultID);

    }

    //method for "Start" button on main page, connected through XML file
    public void sendMessage(View view)
    {
        try {
            Intent intent = new Intent(MainActivity.this, Practice.class);
            intent.putExtra("PROBLEMS", Integer.parseInt(numQuestions.getText().toString()));

            //puts operation to next screen
            int radioID = operation.getCheckedRadioButtonId();
                choice1 = findViewById(radioID);
                intent.putExtra(OPERAND, choice1.getText().toString());

                //puts difficulty
            int radio2 = diff.getCheckedRadioButtonId();
                choice2 = findViewById(radio2);
                intent.putExtra(DIFFICULTY, choice2.getText().toString());


            mStartForResult.launch(intent);
            //exception catches if the RadioGroup is empty or not
        }catch (Exception e)
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Choose Difficulty/Operation", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new
                    ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == Activity.RESULT_OK)
            {
                Intent intent = result.getData();
                String msg = intent.getStringExtra("CORRECT");
                String denom = intent.getStringExtra("QUESTIONS");
                String math = intent.getStringExtra("OPERATOR");
                if(Double.parseDouble(msg)/Double.parseDouble(denom) >= 0.8)
                {
                    message.setTextColor(Color.BLACK);
                    message.setText("You got " + String.valueOf(msg) + " out of " + String.valueOf(denom) + " correct in " + String.valueOf(math) + ". Good Work!");
                }
                else
                {
                    message.setTextColor(Color.RED);
                    message.setText("You got " + msg + " out of " + denom + " correct in " + math + ". You need to practice more!");
                }
            }
        }
    });
}